package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.MentalityTestContract;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.MentalityTestBean;
import com.wangzijie.nutrition_user.presenter.MentalityTestPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  评估,心理,焦虑\压力测试
 */
public class MentalityTestActivity extends BaseActivity<MentalityTestPresenter> implements MentalityTestContract.View {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.vp_mentality_test_act)
    ViewPager viewPager;



    private ArrayList<MentalityTestBean.DataBeanX.DataBean.AnswerBean> beanList = new ArrayList();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mentality_test;
    }

    @Override
    protected void initView() {
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        title.setText(name);
        fragmentList=new ArrayList<>();
        viewPager.setAdapter(new MentalityTestPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.getData();
        showNormal();
    }

    @Override
    protected MentalityTestPresenter createPresenter() {
        return new MentalityTestPresenter();
    }


    @OnClick(R.id.back)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.back:
                    finish();
                break;
        }
    }

    @Override
    public void getDataOk(BaseBean bean) {
        showNormal();
    }

    @Override
    public void getDataEerror(String error) {
        showError(error);
    }

    class MentalityTestPagerAdapter extends FragmentStatePagerAdapter{

        public MentalityTestPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
