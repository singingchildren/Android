package com.wangzijie.nutrition_user.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.umeng.socialize.UMShareAPI;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面
 */
public class LoginActivity extends BaseActivity{
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.iv_login)
    ImageView ivLogin;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.tv_register_fragment)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.constraintLayout2)
    ConstraintLayout constraintLayout2;
    private String[] permissions;
    private List<String> mPermissionList;




    @Override
    protected int getLayoutId() {
        return R.layout.act_user_login;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        initFragment();
        selectFragment(0);

    }


    /**
     * 初始化碎片
     */
    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(Fragment_login.getInstance());
        fragmentList.add(Fragment_register.getInstance());

    }


    @OnClick({R.id.iv_close, R.id.iv_login, R.id.tv_register_fragment, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                this.finish();
                break;
            case R.id.tv_register_fragment:
                tvLogin.setTextColor(ToastUtil.getColor(R.color.text));
                tvRegister.setTextColor(ToastUtil.getColor(R.color.text2));
                selectFragment(0);
                break;
            case R.id.tv_register:
                tvLogin.setTextColor(ToastUtil.getColor(R.color.text2));
                tvRegister.setTextColor(ToastUtil.getColor(R.color.text));
                selectFragment(1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


}
