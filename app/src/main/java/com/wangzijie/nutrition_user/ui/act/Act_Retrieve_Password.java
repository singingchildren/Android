package com.wangzijie.nutrition_user.ui.act;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.utils.CountDownTimerUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.Verification;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 找回密码
 *
 * @author fanjiangpeng
 */
public class Act_Retrieve_Password extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_ver)
    EditText etVer;
    @BindView(R.id.confirm)
    TextView confirm;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_ver)
    TextView tvVer;
    @BindView(R.id.et_passwords)
    EditText etPasswords;
    @BindView(R.id.textView2)
    TextView textView2;

    private CountDownTimerUtils countDownTimerUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.act_retrieve_password;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.confirm, R.id.tv_ver,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.confirm:
                if (selectViewData()){
                    RequestBody body= RequestBodyBuilder.objBuilder()
                            .add("newPassword", etPassword.getText().toString())
                            .add("phone", etPhone.getText().toString())
                            .add("code", etVer.getText().toString())
                            .build();
                    ApiStore.getService()
                            .resetPwd(body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer(){
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(Object o) {

                                }


                                @Override
                                public void onError(Throwable e) {
                                    showError(e.getMessage());
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
                break;
            case R.id.tv_ver:
                countDownTimerUtils = new CountDownTimerUtils(tvVer,60000,1000);
                countDownTimerUtils.start();
                verification(etPhone.getText().toString());
                break;
            case R.id.back:
                this.finish();
                break;
                default:
                    break;
        }
    }

    private boolean selectViewData(){
        if (!PwdCheckUtil.isMobile(etPhone)){
            ToastUtil.show(this,"请输入正确手机号码！");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etVer)){
            ToastUtil.show(this,"请输入验证码！");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etPassword)){
            ToastUtil.show(this,"请输入密码！");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etPasswords)){
            ToastUtil.show(this,"请再次输入密码！");
            return false;
        }

        if (!PwdCheckUtil.isLetterDigit(PwdCheckUtil.getViewData(etPassword))){
            ToastUtil.show(this,"请设置高强度密码,至少6位包含字母和数字！");
            return false;
        }
        if (!PwdCheckUtil.getViewData(etPassword).equals(PwdCheckUtil.getViewData(etPasswords))){
            ToastUtil.show(this,"请保证密码一致！");
            return false;
        }

            return true;

    }

    public void verification(String phone) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("phone", phone)
                .build();
        ApiStore.getService()
                .postVerification(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Verification>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Verification verification) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        showError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
}
