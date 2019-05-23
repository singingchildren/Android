package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 心理测试Fragment
 */
public class MentalityTestFragment extends BaseFragment {


    @BindView(R.id.tv_problem_mentality_test_act)
    TextView tvProblemMentalityTestAct;
    @BindView(R.id.rb1_mentality_test_act)
    RadioButton rb1MentalityTestAct;
    @BindView(R.id.rb2_mentality_test_act)
    RadioButton rb2MentalityTestAct;
    @BindView(R.id.rb3_mentality_test_act)
    RadioButton rb3MentalityTestAct;
    @BindView(R.id.rb4_mentality_test_act)
    RadioButton rb4MentalityTestAct;
    @BindView(R.id.rg_mentality_test_act)
    RadioGroup rgMentalityTestAct;

    private ViewPager viewPager;

    public MentalityTestFragment() {
    }

    public MentalityTestFragment(ViewPager viewPager) {
        this.viewPager=viewPager;
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mentality_test;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_problem_mentality_test_act)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_problem_mentality_test_act:
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                break;
        }
    }
}
