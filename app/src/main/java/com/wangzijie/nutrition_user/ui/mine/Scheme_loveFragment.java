package com.wangzijie.nutrition_user.ui.mine;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.healthguidance.MentalityAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.presenter.HealthGuidePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 我的健康指导方案--心理
 */
public class Scheme_loveFragment extends BaseFragment<HealthGuidePresenter> implements HealthGuidePresenter.HealthGuideView,BaseQuickAdapter.OnItemChildClickListener{

    @BindView(R.id.shemelove_recycle)
    RecyclerView shemeloveRecycle;
    private MentalityAdapter mentalityAdapter;

    public Scheme_loveFragment() {
        // Required empty public constructor
    }


    @Override
    protected HealthGuidePresenter createPresenter() {
        return new HealthGuidePresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_scheme_love;
    }


    @Override
    protected void initData() {
        mentalityAdapter = new MentalityAdapter(activity);
        shemeloveRecycle.setLayoutManager(new LinearLayoutManager(activity));
        shemeloveRecycle.setAdapter(mentalityAdapter);
        mPresenter.getMyHealthGuidePlan(1,100,"psychology");
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }


    @Override
    public void onUpdateMyHealthGuidePlan(List<HealthPlanBean> list) {



    }

    @Override
    public void onUpdateMyHealthGuidePlan2(List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list) {
        if (null==list||list.isEmpty()){

        }else {
            mentalityAdapter.setList(list);
        }
    }

    @Override
    public void err(String message) {

    }
}
