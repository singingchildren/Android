package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.view.View;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.mine.Scheme_FoodFragment;
import com.wangzijie.nutrition_user.ui.mine.Scheme_SleepFragment;
import com.wangzijie.nutrition_user.ui.mine.Scheme_StopFragment;
import com.wangzijie.nutrition_user.ui.mine.Scheme_loveFragment;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 消息->用户档案=>健康指导方案
 */
public class ActSchemeActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_scheme2_1;
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Scheme_FoodFragment());
        fragmentList.add(new Scheme_SleepFragment());
        fragmentList.add(new Scheme_StopFragment());
        fragmentList.add(new Scheme_loveFragment());


    }

    @Override
    protected void initData() {
        selectFragment(0);
    }


    @OnClick({R.id.scheme_food, R.id.scheme_sleep, R.id.scheme_stop, R.id.scheme_love, R.id.back,R.id.release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scheme_food:
                selectFragment(0);
                break;
            case R.id.scheme_sleep:
                selectFragment(1);
                break;
            case R.id.scheme_stop:
                selectFragment(2);
                break;
            case R.id.scheme_love:
                selectFragment(3);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.release:
                JumpUtil.overlay(this,ActSchemeCompose.class);
                break;
            default:
                break;
        }
    }



}
