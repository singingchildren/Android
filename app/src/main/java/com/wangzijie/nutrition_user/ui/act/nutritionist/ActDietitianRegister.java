package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.PhotoAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.DietitianRegisterContract;
import com.wangzijie.nutrition_user.model.bean.RegisterData;
import com.wangzijie.nutrition_user.presenter.DietitianRegisterPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;
import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT2;


/**
 * @author fanjiangpeng
 * 营养师注册
 */
public class ActDietitianRegister extends BaseActivity<DietitianRegisterPresenter> implements DietitianRegisterContract.DietitianView {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_idnum)
    EditText etIdnum;
    @BindView(R.id.et_code_dietitian_register_act)
    EditText etCode;
    @BindView(R.id.et_studio_code_dietitian_register)
    EditText etStudioCode;
    @BindView(R.id.et_region)
    EditText etRegion;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.recycler_resume)
    RecyclerView recyclerResume;
    @BindView(R.id.recycler_healty)
    RecyclerView recyclerHealty;
    @BindView(R.id.et_introduction_nutritionist_register)
    EditText etIntroduction;

    ImageItem imageItem = new ImageItem();

    private PhotoAdapter photoAdapter1;
    private PhotoAdapter photoAdapter2;

    private ArrayList<ImageItem> imageItemList1 = new ArrayList<>();
    private ArrayList<ImageItem> imageItemList2 = new ArrayList<>();


    private ProgressDialog progressDialog;
    private String code;
    private String password;
    private String role;
    private String phone;
    private String invitationCode;
    private String stduioCode;


    @Override
    protected int getLayoutId() {
        return R.layout.act_dietitian_register;
    }

    @Override
    protected void initView() {
        recyclerResume.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerHealty.setLayoutManager(new GridLayoutManager(this, 4));

        recyclerResume.setNestedScrollingEnabled(false);
        recyclerHealty.setNestedScrollingEnabled(false);
        imageItemList1.add(imageItem);
        imageItemList2.add(imageItem);

        photoAdapter1 = new PhotoAdapter(imageItemList1, REQUEST_CODE_SELECT,1);
        recyclerResume.setAdapter(photoAdapter1);

        photoAdapter2 = new PhotoAdapter(imageItemList2, REQUEST_CODE_SELECT2,1);
        recyclerHealty.setAdapter(photoAdapter2);
    }


    @Override
    protected void initData() {
        photoAdapter1.setClickImageListener(etName, activity);
        photoAdapter2.setClickImageListener(etName, activity);
        Bundle bundle = getIntent().getExtras();
        phone = bundle.getString("phone");
        code = bundle.getString("code");
        password = bundle.getString("password");
        role = Constant.DIETICIAN;
    }

    @Override
    protected DietitianRegisterPresenter createPresenter() {
        return new DietitianRegisterPresenter();
    }


    @OnClick({R.id.back, R.id.release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.release:
                mPresenter.selectViewData(etName, etIdnum, etRegion, etAddress, etIntroduction);
                invitationCode = etCode.getText().toString();
                stduioCode = etStudioCode.getText().toString();
                break;
        }
    }

    @Override
    public void selectSuss(String name, String idNum, String region, String address,String introduce) {
        //HashMap<String(列表类型), String(文件path)>
        ArrayList<HashMap<String, String>> urlMapList = new ArrayList<>();
        for (ImageItem item : imageItemList1) {
            if (!TextUtils.isEmpty(item.path)) {
                HashMap<String, String> urlMap = new HashMap();
                urlMap.put(OssServiceUtil.UPLOAD_FILE_LIST_TYPE1, item.path);
                urlMapList.add(urlMap);
            }
        }
        if (urlMapList.size()==0) {//必填
            Toast.makeText(activity, "请上传资历证照片!", Toast.LENGTH_SHORT).show();
            return;
        }else {
            progressDialog = DisplayUtils.showWaitingDialog(this,"图片上传中");
        }
        for (ImageItem item : imageItemList2) {//选填字段不做要求
            if (!TextUtils.isEmpty(item.path)) {
                HashMap<String, String> urlMap = new HashMap();
                urlMap.put(OssServiceUtil.UPLOAD_FILE_LIST_TYPE2, item.path);
                urlMapList.add(urlMap);
            }
        }
        OssServiceUtil.upload(".jpg", urlMapList, new OssServiceUtil.CallBack2() {

            @Override
            public void ossUploadSucceed(ArrayList<String>... urlList) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                //String code, String phone,String password, String role, String name, String idNumber, String InvitationCode, String studioCode, String area, String address, ArrayList<String> urlList1, ArrayList<String> urlList2, String introduce
                mPresenter.registerDietitian(code,phone,password,role,name, idNum, invitationCode,stduioCode,region, address, urlList[0], urlList[1],introduce);
            }

            @Override
            public void ossUploadFailed(String error) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                ToastUtil.show(ActDietitianRegister.this, "上传图片失败"+error);
            }
        });
    }

    @Override
    public void selectErr(String errCode) {
        ToastUtil.show(this, errCode);
    }

    @Override
    public void registSuss(RegisterData registerData) {
        new Thread(() -> {
            try {
                EMClient.getInstance().createAccount(registerData.getData().getHxLogId(), registerData.getData().getHxPwd());
                runOnUiThread(() -> ToastUtil.show(this, "注册成功！"));
            } catch (final HyphenateException e) {
                runOnUiThread(() -> {
                    Log.d("ActDietitianRegisterljq", e.getMessage());
                    int errorCode=e.getErrorCode();
                    if(errorCode== EMError.NETWORK_ERROR){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.network_anomalies), Toast.LENGTH_SHORT).show();
                    }else if(errorCode == EMError.USER_ALREADY_EXIST){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.User_already_exists), Toast.LENGTH_SHORT).show();
                    }else if(errorCode == EMError.USER_AUTHENTICATION_FAILED){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.registration_failed_without_permission), Toast.LENGTH_SHORT).show();
                    }else if(errorCode == EMError.USER_ILLEGAL_ARGUMENT){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.illegal_user_name),Toast.LENGTH_SHORT).show();
                    }else if(errorCode == EMError.EXCEED_SERVICE_LIMIT){
                        Toast.makeText(ActDietitianRegister.this, getResources().getString(R.string.register_exceed_service_limit), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registration_failed), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
        finish();
    }


    @Override
    public void registErr(String errCode) {
        ToastUtil.show(this, errCode);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT) {
            photoAdapter1.onActivityResult(requestCode, resultCode, data);
        } else if (requestCode == REQUEST_CODE_SELECT2) {
            photoAdapter2.onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * 重写按键监听，点击返回键不退出应用，而是跳转到桌面
     *
     * @param keyCode 每个按键的标记
     * @param event   触碰手势对象
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (progressDialog != null)
                progressDialog.dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }
}
