package com.wangzijie.nutrition_user.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.RegisterContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.RegisterData;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.Verification;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class RegisterPresenter extends BasePresenter<RegisterContract.registerView> implements RegisterContract.registerPresenter {


    @Override
    public void RegisterUser(Context context, String code, String phone, String password, String role) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("code", code)
                .add("phone", phone)
                .add("password", password)
                .add("role", role)
                .add("platform", MyApplication.globalData.getPlatform())
                .add("platform_uid", MyApplication.globalData.getPlatform_udi())
                .add("accessToken", MyApplication.globalData.getAccessToken())
                .build();
        ApiStore.getService()
                .register(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterData registerData) {
                        Log.d("RegisterPresenter", registerData.toString());
                        if (registerData.getData()!=null) {
                            view.registerOk(registerData);
                        } else {
                            Log.e("RegisterPresenter", "registerData" + registerData.getMessage());
                            view.RegisterErr(registerData.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RegisterPresenter", "e:" + e);
                        view.RegisterErr(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

//    private void automaticLogin(String phone, String password, String mixed, String account) {
//        RequestBody body = RequestBodyBuilder.RequestObjBodyBuilder()
//                .add("password", password)
//                .add("phone", phone)
//                .add("mixed", mixed)
//                .add("account", account).build();
//        ApiStore.getService()
//                .postLogin(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginData>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(LoginData loginData) {
//                        if (loginData.isSuccess()) {
//                            view.registerOk(loginData);
//                        } else {
//                            view.RegisterErr("自动登录失败" + loginData.getMessage());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("RegisterPresenter", "e:" + e);
//                        view.RegisterErr(e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    @Override
    public void selectData(EditText etPhone, EditText etCode, EditText etPassword) {
        if (PwdCheckUtil.selectViewData(etPhone)) {
            view.getDataErr("请输入手机号码！");
            return;
        }
        if (!PwdCheckUtil.isMobile(etPhone)) {
            view.getDataErr("请输入正确手机号码！");
            return;
        }
        if (PwdCheckUtil.selectViewData(etCode)) {
            view.getDataErr("请输入验证码！");
            return;
        }

        if (PwdCheckUtil.selectViewData(etPassword)) {
            view.getDataErr("请输入密码！");
            return;
        }

        if (!PwdCheckUtil.isLetterDigit(PwdCheckUtil.getViewData(etPassword))) {
            view.getDataErr("请设置高强度密码,至少6位包含字母和数字！");
            return;
        }
        view.getDataOk(PwdCheckUtil.getViewData(etPhone), PwdCheckUtil.getViewData(etCode), PwdCheckUtil.getViewData(etPassword));
    }


    @Override
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
                        if (verification.isSuccess()) {
                            view.getVerificationSucceed();
                        } else {
                            view.getVerificationErr("获取失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("RegisterPresenter", "e:" + e);
                        view.getVerificationErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
}
