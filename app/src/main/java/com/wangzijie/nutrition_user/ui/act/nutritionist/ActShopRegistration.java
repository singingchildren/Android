package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
 * @author fanjiangpeng
 * 工作室注册
 */
public class ActShopRegistration extends BaseActivity {


    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.edt_studio_name)
    EditText etStudioName;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.title)
    TextView title;
    private ArrayList<ImageItem> imageItemList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    private ProgressDialog waitingDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.act_shop_registration;
    }

    @Override
    protected void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recycler.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        title.setText("工作室注册");
        ImageItem imageItem = new ImageItem();
        imageItemList.add(imageItem);
        photoAdapter = new PhotoAdapter(imageItemList, REQUEST_CODE_SELECT);
        photoAdapter.setClickImageListener(commit, activity);
        recycler.setAdapter(photoAdapter);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.back,R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
            break;
            case R.id.commit:
                putData();
                break;
        }

    }

    private void putData() {
        if (PwdCheckUtil.selectViewData(etStudioName)){
            show("请输入工作室名称");
            return;
        }
        if (PwdCheckUtil.selectViewData(etAddress)){
            show("请输入地址");
            return;
        }
        if (PwdCheckUtil.selectViewData(etName)){
            show("请输入注册人姓名");
            return;
        }
        boolean isNull=false;
        for (ImageItem item : imageItemList) {
            if (!TextUtils.isEmpty(item.path)) {
                isNull=true;
            }
        }
        if (!isNull) {
            show("请上传资质证照片!");
            return;
        }
        waitingDialog = DisplayUtils.showWaitingDialog(this, "图片上传中");

        OssServiceUtil.upload(".jpe", imageItemList, new OssServiceUtil.CallBack1() {
            @Override
            public void ossUploadSucceed(ArrayList<String> urlList) {
                RequestBody body= RequestBodyBuilder.objBuilder()
                        .add("name", etStudioName.getText().toString())
                        .add("address", etAddress.getText().toString())
                        .add("legalPerson", etName.getText().toString())
                        .addSingleFieldObjectArray("certUrl","imgUrl",urlList)
                        .build();
                ApiStore.getService()
                        .registerStudio(body)
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
                                    show("注册成功:");
                                    finish();
                                }else {
                                    show("注册失败:"+baseBean.getMessage());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (waitingDialog!=null) {
                                    waitingDialog.dismiss();
                                }
                                show("注册失败:"+e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }

            @Override
            public void ossUploadFailed(String error) {
                show("上传图片失败:"+ error);
            }
        });
    }

    private void show(String s) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photoAdapter.onActivityResult(requestCode, resultCode, data);
    }

}
