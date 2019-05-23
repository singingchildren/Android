package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.PhotoAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.SeniorDietitianRegisterContract;
import com.wangzijie.nutrition_user.presenter.SeniorDietitianApplyPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;


/**
 * @author fanjiangpeng
 * 高级营养师申请
 */
public class ActSeniorDietitianApply extends BaseActivity<SeniorDietitianApplyPresenter> implements SeniorDietitianRegisterContract.SeniorDietitianView {

    @BindView(R.id.rcv_senior_dietitian)
    RecyclerView recycler;
    @BindView(R.id.home_healthtext)
    TextView homeHealthtext;
    @BindView(R.id.edt_name_senior_dietitian)
    EditText edtNameSeniorDietitian;
    @BindView(R.id.edt_idnum_senior_dietitian)
    EditText edtIdnumSeniorDietitian;
    @BindView(R.id.edt_phone_senior_dietitian)
    EditText edtPhoneSeniorDietitian;
    @BindView(R.id.edt_region_senior_dietitian)
    EditText edtRegionSeniorDietitian;
    @BindView(R.id.edt_address_senior_dietitian)
    EditText edtAddressSeniorDietitian;
    @BindView(R.id.commit)
    Button commit;

    private ArrayList<ImageItem> imageItemList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.senior_nutritionist_apply;
    }

    @Override
    protected void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recycler.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        ImageItem imageItem = new ImageItem();
        imageItemList.add(imageItem);
        photoAdapter = new PhotoAdapter(imageItemList, REQUEST_CODE_SELECT);
        recycler.setAdapter(photoAdapter);
        photoAdapter.setClickImageListener(recycler, this);
    }

    @Override
    protected SeniorDietitianApplyPresenter createPresenter() {
        return new SeniorDietitianApplyPresenter();
    }


    @Override
    public void selectSuss(String name, String idNum,String phone, String region, String address) {
        if (TextUtils.isEmpty(imageItemList.get(0).path)){
            selectErr("请先选择图片!");
            return;
        }
        progressDialog= DisplayUtils.showWaitingDialog(this,"图片上传中");
        OssServiceUtil.upload(".jpg", imageItemList, new OssServiceUtil.CallBack1() {
            @Override
            public void ossUploadSucceed(ArrayList<String> urlList) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                mPresenter.dietitianApply(name, idNum,phone, region, address,urlList);
            }

            @Override
            public void ossUploadFailed(String error) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                ToastUtil.show(ActSeniorDietitianApply.this, "上传图片失败"+error);
            }
        });

    }

    @Override
    public void selectErr(String errCode) {
        ToastUtil.show(this, errCode);
    }

    @Override
    public void applySuss() {

    }

    @Override
    public void applyErr(String errCode) {
        ToastUtil.show(this, errCode);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        photoAdapter.onActivityResult(requestCode, resultCode, data);
    }


    @OnClick({R.id.back, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.commit:
                mPresenter.selectViewData(edtNameSeniorDietitian, edtIdnumSeniorDietitian,edtPhoneSeniorDietitian ,edtRegionSeniorDietitian, edtAddressSeniorDietitian);
                break;
        }
    }
}
