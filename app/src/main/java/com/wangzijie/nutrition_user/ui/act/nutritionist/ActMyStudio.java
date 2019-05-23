package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.home.Fragment_mine;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 我的工作室
 */
public class ActMyStudio extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_studio_code)
    TextView tvStudioCode;
    private String id;

    @Override
    protected int getLayoutId() {
        return R.layout.act_my_shop;
    }

    @Override
    protected void initView() {
        id = getIntent().getExtras().getString("id");
    }

    @Override
    protected void initData() {
        title.setText("我的工作室");
        if (!TextUtils.isEmpty(MyApplication.globalData.getStudioInvitationCode())){
            tvStudioCode.setText(MyApplication.globalData.getStudioInvitationCode());
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.back, R.id.introduce, R.id.dietitian, R.id.tv_Invitation_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.introduce:
                Bundle bundle1 = new Bundle();
                bundle1.putString("id", id);
                JumpUtil.overlay(this, ActShopIntroduction.class,bundle1);
                break;
            case R.id.dietitian:
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                JumpUtil.overlay(this, ActShopDietitian.class,bundle);
                break;
            case R.id.tv_Invitation_code:
                Fragment_mine.copyToClipboard(this,tvStudioCode.getText().toString());
            default:
                break;
        }
    }



}
