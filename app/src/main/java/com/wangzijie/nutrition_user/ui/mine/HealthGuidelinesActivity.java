package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 消息-我的营养师-健康指导方案
 */
public class HealthGuidelinesActivity extends BaseActivity {


    @BindView(R.id.scheme_food)
    RadioButton schemeFood;
    @BindView(R.id.scheme_sleep)
    RadioButton schemeSleep;
    @BindView(R.id.scheme_stop)
    RadioButton schemeStop;
    @BindView(R.id.scheme_love)
    RadioButton schemeLove;
    @BindView(R.id.scheme_titleimage)
    ImageView schemeTitleimage;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my__scheme;
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

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.scheme_food, R.id.scheme_sleep, R.id.scheme_stop, R.id.scheme_love,R.id.scheme_titleimage})
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
            case R.id.scheme_titleimage:
                finish();
                break;
        }
    }




}
