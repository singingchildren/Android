package com.wangzijie.nutrition_user.ui.mine;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.healthguidance.SleepAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.presenter.HealthGuidePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scheme_SleepFragment extends BaseFragment<HealthGuidePresenter> implements HealthGuidePresenter.HealthGuideView {


    @BindView(R.id.shemesleep_Recycle)
    RecyclerView shemesleep_Recycle;
    private SleepAdapter sleepAdapter;

    public Scheme_SleepFragment() {
        // Required empty public constructor
    }


    @Override
    protected HealthGuidePresenter createPresenter() {
        return new HealthGuidePresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_scheme__sleep;
    }

    @Override
    protected void initData() {
        sleepAdapter = new SleepAdapter(activity);
        shemesleep_Recycle.setLayoutManager(new LinearLayoutManager(activity));
        shemesleep_Recycle.setAdapter(sleepAdapter);
        mPresenter.getMyHealthGuidePlan(1,100,"sleep");
    }

    @Override
    public void onUpdateMyHealthGuidePlan2(List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list) {
        if (null==list||list.isEmpty()){

        }else {
            sleepAdapter.setList(list);
        }
    }

    @Override
    public void onUpdateMyHealthGuidePlan(List<HealthPlanBean> list) {
    }


    @Override
    public void err(String message) {

    }
}
