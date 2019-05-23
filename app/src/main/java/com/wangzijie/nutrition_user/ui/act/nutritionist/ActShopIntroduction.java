package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.PhotoAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.UpdatadescrContract;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.presenter.UpdatadescrPersenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;


/**
 * @author fanjiangpeng
 * 工作室介绍
 */
public class ActShopIntroduction extends BaseActivity<UpdatadescrPersenter> implements UpdatadescrContract.View {
    @BindView(R.id.release)
    TextView commit;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.et_content)
    EditText etContent;

    private ArrayList<ImageItem> imageItemList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    private String studioId;
    private ProgressDialog waitingDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.act_shop_introduction;
    }

    @Override
    protected void initView() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            studioId = bundle.getString("id");
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        ImageItem imageItem = new ImageItem();
        imageItemList.add(imageItem);
        photoAdapter = new PhotoAdapter(imageItemList, REQUEST_CODE_SELECT);
        photoAdapter.setClickImageListener(commit, this);
        recyclerView.setAdapter(photoAdapter);
    }

    @Override
    protected UpdatadescrPersenter createPresenter() {
        return new UpdatadescrPersenter();
    }


    @OnClick({R.id.back, R.id.et_content, R.id.release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.release://提交
                checkInput();
                break;
            default:
                break;
        }
    }

    private void checkInput() {
        if (PwdCheckUtil.selectViewData(etContent)) {
            onFreali("请输入工作室介绍");
            return;
        }
        boolean isNull = false;
        for (ImageItem item : imageItemList) {
            if (!TextUtils.isEmpty(item.path)) {
                isNull = true;
            }
        }
        if (!isNull) {
            onFreali("请上传工作室照片");
            return;
        }
        waitingDialog = DisplayUtils.showWaitingDialog(this, "图片上传中");
        OssServiceUtil.upload(".jpg", imageItemList, new OssServiceUtil.CallBack1() {
            @Override
            public void ossUploadSucceed(ArrayList<String> urlList) {
                if (waitingDialog!=null) {
                    waitingDialog.dismiss();
                }
                mPresenter.getDietitianStudioGetData(studioId
                        ,etContent.getText().toString(),
                        urlList);
            }

            @Override
            public void ossUploadFailed(String error) {
                if (waitingDialog!=null) {
                    waitingDialog.dismiss();
                }
                onFreali("图片上传失败"+error);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photoAdapter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSuccess(SuccessBean successBean) {
        Toast.makeText(ActShopIntroduction.this, "提交成功", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onFreali(String msg) {
        Toast.makeText(ActShopIntroduction.this, msg, Toast.LENGTH_LONG).show();
    }
}
