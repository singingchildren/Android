package com.wangzijie.nutrition_user.ui.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.RegisterContract;
import com.wangzijie.nutrition_user.model.bean.RegisterData;
import com.wangzijie.nutrition_user.presenter.RegisterPresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActDietitianRegister;
import com.wangzijie.nutrition_user.ui.act.nutritionist.AgreementActivity;
import com.wangzijie.nutrition_user.utils.CountDownTimerUtils;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面——注册碎片
 *
 * @author fanjiangpeng
 */
public class Fragment_register extends BaseFragment<RegisterPresenter> implements RegisterContract.registerView {

    private final int time = 6 * 10000;
    private final int second = 1 * 1000;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_password)
    ImageView ivPassword;
    @BindView(R.id.et_verification)
    EditText etVerification;
    @BindView(R.id.tv_verfication)
    TextView tvVerfication;
    @BindView(R.id.imageView32)
    ImageView imageView32;
    @BindView(R.id.et_passwords)
    EditText etPasswords;
    @BindView(R.id.iv_look)
    ImageView ivLook;
    @BindView(R.id.tv_register_fragment)
    TextView tvLogin;
    @BindView(R.id.radio)
    TextView radio;
    @BindView(R.id.textView54)
    TextView textView54;
    @BindView(R.id.iv_cheak)
    ImageView cheak;

    ;
    @BindView(R.id.constraintLayout8)
    ConstraintLayout constraintLayout8;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.calls));
            ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verification));
            imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
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
            ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verifications));
            imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (ToastUtil.getString(R.id.et_password).length() > 0) {
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verifications));
            } else {
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verification));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    TextWatcher textWatcher3 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
            ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verification));
            imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.locks));
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (ToastUtil.getString(R.id.et_password).length() > 0) {
                imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.locks));
            } else {
                imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
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
    /**
     * 默认同意
     */
    private boolean isAggree = true;
    private CountDownTimerUtils countDownTimerUtils;
    private String ver;
    private TextView user;
    private TextView dietitian;
    private PopupWindow popupWindow;
    private long mExitTime;

    public static Fragment_register getInstance() {
        return new Fragment_register();
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initData() {
        textView54.setOnClickListener(v -> startActivity(new Intent(activity, AgreementActivity.class)));
    }

    @Override
    protected void initUI() {
        super.initUI();
        etPhone.addTextChangedListener(textWatcher);
        etVerification.addTextChangedListener(textWatcher2);
        etPasswords.addTextChangedListener(textWatcher3);
    }

    @OnClick({R.id.tv_verfication, R.id.tv_register_fragment, R.id.iv_look, R.id.iv_cheak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_verfication:
                if (!PwdCheckUtil.isMobile(etPhone)) {
                    getDataErr("请输入正确手机号码！");
                } else {
                    countDownTimerUtils = new CountDownTimerUtils(tvVerfication, time, second);
                    countDownTimerUtils.start();
                    mPresenter.verification(PwdCheckUtil.getViewData(etPhone));
                }
                break;
            case R.id.tv_register_fragment:
                if (isAggree) {
                    mPresenter.selectData(etPhone, etVerification, etPasswords);
                } else {
                    getDataErr("请先阅读并同意服务声明！");
                }
                break;
//            case R.id.status_layout:
//                etPasswords.clearFocus();
//                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
//                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.verification));
//                imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
//                break;
            case R.id.iv_look:
                etPasswords.setFocusable(true);
                etPasswords.requestFocus();
                imageView32.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.locks));
                ivPhone.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.call));
                ivPassword.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.lock));
                if (isShow) {
                    etPasswords.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ivLook.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.eyes));
                    isShow = false;
                } else {
                    etPasswords.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivLook.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.eyess));
                    isShow = true;
                }
                break;
            case R.id.iv_cheak:
                if (isAggree) {
                    isAggree = false;
                    cheak.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.aggrees));
                } else {
                    isAggree = true;
                    cheak.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.aggree));
                }
                break;
            default:
                break;
        }
    }


    private void initPopwindow(String phone, String code, String password) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.register_popwindow, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop = view.findViewById(R.id.regsiter_popwindow);
        user = layout_pop.findViewById(R.id.user);
        dietitian = layout_pop.findViewById(R.id.dietitian);
        view.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);

        // 点击用户
        user.setOnClickListener(v -> {
            DisplayUtils.showNormalDialog(getContext(),"选择注册用户?","注册后不可更改!",
                    (dialog, which) -> {
                        MyApplication.globalData.setNutritionist(false);
                        mPresenter.RegisterUser(myApplication, code, phone, password, Constant.CUSTOMER);
                        popupWindow.dismiss();
                    });
        });
        // 点击营养师
        dietitian.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("phone", phone);
            bundle.putString("code", code);
            bundle.putString("password", password);
            JumpUtil.overlay(getContext(), ActDietitianRegister.class, bundle);
            popupWindow.dismiss();
        });
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(null);
        //弹出的位置
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        popupWindow.showAtLocation(tvLogin, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }


    @Override
    public void registerOk(RegisterData registerData) {
        new Thread(() -> {
            try {
                EMClient.getInstance().createAccount(registerData.getData().getHxLogId(), registerData.getData().getHxPwd());
                getActivity().runOnUiThread(() -> ToastUtil.show(getContext(), "注册成功！"));
            } catch (final HyphenateException e) {
                getActivity().runOnUiThread(() -> {
                    int errorCode = e.getErrorCode();
                    Log.e("Fragment_register:ljq", e.getMessage() + "errorCode" + errorCode);
                    if (errorCode == EMError.NETWORK_ERROR) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.network_anomalies), Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.USER_ALREADY_EXIST) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.User_already_exists), Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.USER_AUTHENTICATION_FAILED) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.registration_failed_without_permission), Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.USER_ILLEGAL_ARGUMENT) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.illegal_user_name), Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.EXCEED_SERVICE_LIMIT) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.register_exceed_service_limit), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), getResources().getString(R.string.Registration_failed) + "errorCode" + errorCode, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
//        if (BuildConfig.DEBUG) Log.d("Fragment_register", loginData.getData().toString());
//        JumpUtil.jumpMain(getActivity(),loginData);
    }

    @Override
    public void RegisterErr(String err) {
        ToastUtil.show(getContext(), "注册失败：" + err);
    }

    @Override
    public void getDataOk(String phone, String code, String password) {
        initPopwindow(phone, code, password);
    }

    @Override
    public void getDataErr(String err) {
        ToastUtil.show(getActivity(), err);
    }

    @Override
    public void getVerificationSucceed() {

    }

    @Override
    public void getVerificationErr(String err) {
        ToastUtil.show(getContext(), "错误：" + err);
    }


}
