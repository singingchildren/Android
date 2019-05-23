package com.wangzijie.nutrition_user.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.LoginContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.LoginData;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Per {


    @Override
    public void loginUser(String username, String password) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("password", password)
                .add("phone", username)
                .add("mixed", "")
                .add("account", username).build();
        ApiStore.getService()
                .postLogin(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginData loginData) {
                        if (loginData.getData() != null && loginData.getData() != null) {
                            loginIm(loginData.getData().getHxLogId(),loginData.getData().getHxPwd());
                            view.loginOk(loginData);
                        } else {
                            view.loginErr(loginData.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.loginErr(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    @Override
    public void selectData(EditText etPhone, EditText etPassword) {
        if (PwdCheckUtil.selectViewData(etPhone)) {
            view.loginErr("请输入手机号码！");
            return;
        }
        if (!PwdCheckUtil.isMobile(etPhone)) {
            view.loginErr("请输入正确手机号码！");
            return;
        }
        if (PwdCheckUtil.selectViewData(etPassword)) {
            view.loginErr("请输入密码！");
            return;
        }
        view.getDataOk(PwdCheckUtil.getViewData(etPhone), PwdCheckUtil.getViewData(etPassword));
    }

    @Override
    public void loginIm(String phone, String password) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            return;
        }
        EMClient.getInstance().login(phone, password, new EMCallBack() {
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                view.loginImOk();
            }

            @Override
            public void onError(int i, String s) {
                Log.e("LoginPresenter,ljq",  "i:"+i+" ,s:"+s);
                view.loginImErr(s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });


    }


}
