package com.wangzijie.nutrition_user.ui.act;

import android.content.Intent;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.LoginContract;
import com.wangzijie.nutrition_user.model.bean.LoginData;
import com.wangzijie.nutrition_user.presenter.LoginPresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.Log.AppLogMessageUtil;
import com.wangzijie.nutrition_user.utils.SharedPreferenceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面——登陆碎片
 */
public class Fragment_login extends BaseFragment<LoginPresenter> implements LoginContract.View, UMAuthListener {

    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_password)
    ImageView ivPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_pass)
    TextView tvPass;
    @BindView(R.id.iv_look)
    ImageView ivLook;
    @BindView(R.id.iv_weixin)
    ImageView ivWeixin;
    @BindView(R.id.iv_qq)
    ImageView ivQq;
    @BindView(R.id.iv_weibo)
    ImageView ivWeibo;
    @BindView(R.id.che_automatic)
    CheckBox che_automatic;
    @BindView(R.id.tv_login_fragment)
    TextView tvLogin;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (ToastUtil.getString(R.id.et_phone).length() > 0) {
                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.calls));
            } else {
                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (ToastUtil.getString(R.id.et_password).length() > 0) {
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.locks));
            } else {
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    /**
     * 密码默认不可见
     */
    private boolean isShow = false;
    private String token;

    public static Fragment_login getInstance() {
        return new Fragment_login();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_login;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initUI() {
        super.initUI();

        etPhone.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher2);

    }

    @OnClick({R.id.iv_weixin, R.id.iv_qq, R.id.iv_weibo, R.id.tv_login_fragment, R.id.iv_look, R.id.tv_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_weixin:
                umLogin(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.iv_qq:
                umLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.iv_weibo:
                umLogin(SHARE_MEDIA.SINA);
                break;
            case R.id.tv_login_fragment:

                etPassword.clearFocus();
                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
//                mPresenter.selectData(etPhone,etPassword);
//                mPresenter.loginUser("+86"+PwdCheckUtil.getViewData(etPhone),PwdCheckUtil.getViewData(etPassword));
                mPresenter.selectData(etPhone, etPassword);
//                mPresenter.loginUser(PwdCheckUtil.getViewData(etPhone),PwdCheckUtil.getViewData(etPassword),token);

                break;
            case R.id.iv_look:
                etPassword.setFocusable(true);
                etPassword.requestFocus();
                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
                if (isShow) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isShow = false;
                    AppLogMessageUtil.e("不可见");
                    ivLook.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.eyes));
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivLook.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.eyess));
                    isShow = true;
                    AppLogMessageUtil.e("可见");
                }
                break;
//            case R.id.status_layout:
//                etPassword.clearFocus();
//                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
//                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
//                break;
            case R.id.tv_pass:
                JumpUtil.overlay(getActivity(), Act_Retrieve_Password.class);
                break;
            default:
                break;
        }
    }


    public void umLogin(SHARE_MEDIA name) {
        if (name.equals(SHARE_MEDIA.QQ)) {
            UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, this);
        }
        if (name.equals(SHARE_MEDIA.WEIXIN)) {
            UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.WEIXIN, this);
        }
        if (name.equals(SHARE_MEDIA.SINA)) {
            UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.SINA, this);
        }
    }


    @Override
    public void loginOk(LoginData loginData) {
        if (che_automatic==null) {
            return;
        }
        if (che_automatic.isChecked()) {
            SharedPreferenceUtil.put(activity, "phone", etPhone.getText().toString());
            SharedPreferenceUtil.put(activity, "pwd", etPassword.getText().toString());
        } else {
            SharedPreferenceUtil.put(activity, "phone", "");
            SharedPreferenceUtil.put(activity, "pwd", "");
        }
        JumpUtil.jumpMain(getActivity(), loginData);
    }

    @Override
    public void loginErr(String err) {
        ToastUtil.show(getActivity(), err);
    }

    @Override
    public void getDataOk(String phone, String password) {
        mPresenter.loginUser(phone, password);

    }

    @Override
    public void getDataErr(String err) {
        ToastUtil.show(getActivity(), err);
    }

    @Override
    public void loginImOk() {
        Looper.prepare();
        Toast.makeText(myApplication, "聊天服务器连接成功", Toast.LENGTH_LONG).show();
        Looper.loop();
    }

    @Override
    public void loginImErr(String err) {
        Looper.prepare();
        Toast.makeText(myApplication, "聊天服务器连接失败:"+err, Toast.LENGTH_LONG).show();
        Looper.loop();
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        Log.d("回调成功拉！！！", i + map.toString());


    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        Toast.makeText(activity, "onError：" + throwable.toString(), Toast.LENGTH_LONG).show();
        Log.d("回调方法！！", "回调失败拉！！！");
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        Toast.makeText(activity, "取消", Toast.LENGTH_LONG).show();
        Log.d("回调方法！！", "回调取消拉！！！");
    }


}
