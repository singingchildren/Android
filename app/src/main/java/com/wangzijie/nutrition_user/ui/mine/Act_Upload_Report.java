package com.wangzijie.nutrition_user.ui.mine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.PhotoAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;


/**
 * 病例和体检报告
 *
 * @author fanjiangpeng
 */
public class Act_Upload_Report extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.more_detailstb)
    TextView moreDetailstb;
    @BindView(R.id.constraintLayout10)
    ConstraintLayout constraintLayout10;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.rcv_health_record)
    RecyclerView rcvHealthRecord;
    private ArrayList<ImageItem> imageItemList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    private ProgressDialog waitingDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.act_upload_report;
    }

    @Override
    protected void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        rcvHealthRecord.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        ImageItem imageItem = new ImageItem();
        imageItemList.add(imageItem);
        photoAdapter = new PhotoAdapter(imageItemList,REQUEST_CODE_SELECT);
        rcvHealthRecord.setAdapter(photoAdapter);
        photoAdapter.setClickImageListener(commit,activity);
    }


    @OnClick({R.id.back, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.commit://提交
                putData();
                break;
            default:
                break;
        }
    }

    private void putData() {
        if (PwdCheckUtil.selectViewData(etContent)){
            err("请输入内容");
            return;
        }
        boolean isNull=false;
        for (ImageItem item : imageItemList) {
            if (!TextUtils.isEmpty(item.path)) {
                isNull=true;
            }
        }
        if (!isNull) {
            err("请上传资质证照片");
            return;
        }
        waitingDialog = DisplayUtils.showWaitingDialog(this, "图片上传中");
        OssServiceUtil.upload(".jpe", imageItemList, new OssServiceUtil.CallBack1() {
            @Override
            public void ossUploadSucceed(ArrayList<String> urlList) {
                RequestBody body= RequestBodyBuilder.objBuilder()
                        .add("content", etContent.getText().toString())
                        .addSingleFieldObjectArray("url","imgUrl",urlList)
                        .build();
                ApiStore.getService()
                        .putAddCases(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BaseBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(BaseBean baseBean) {
                                if (waitingDialog!=null) {
                                    waitingDialog.dismiss();
                                }
                                if (baseBean.isSuccess()) {
                                    err("提交成功:");
                                    finish();
                                }else {
                                    err("提交失败:"+baseBean.getMessage());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (waitingDialog!=null) {
                                    waitingDialog.dismiss();
                                }
                                err("提交失败:"+e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }

            @Override
            public void ossUploadFailed(String error) {
                if (waitingDialog!=null) {
                    waitingDialog.dismiss();
                }
                err("上传图片失败:"+ error);
            }
        });
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photoAdapter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    private void err(String s) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }


}
