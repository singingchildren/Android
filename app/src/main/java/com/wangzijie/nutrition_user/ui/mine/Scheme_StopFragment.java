package com.wangzijie.nutrition_user.ui.mine;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.healthguidance.ExerciseAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.presenter.HealthGuidePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scheme_StopFragment extends BaseFragment<HealthGuidePresenter> implements HealthGuidePresenter.HealthGuideView {


    @BindView(R.id.schemestop_recycle)
    RecyclerView schemestop_recycle;
    private ExerciseAdapter exerciseAdapter;

    public Scheme_StopFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutResID() {
        return R.layout.fragment_scheme__stop;
    }

    @Override
    protected void initData() {
        exerciseAdapter = new ExerciseAdapter(activity);
        schemestop_recycle.setLayoutManager(new LinearLayoutManager(activity));
        schemestop_recycle.setAdapter(exerciseAdapter);
        mPresenter.getMyHealthGuidePlan(1,100,"sport");
    }

    @Override
    protected HealthGuidePresenter createPresenter() {
        return new HealthGuidePresenter();
    }

    @Override
    public void onUpdateMyHealthGuidePlan(List<HealthPlanBean> list) {

    }

    @Override
    public void onUpdateMyHealthGuidePlan2(List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list) {
        if (null==list||list.isEmpty()){

        }else {
            exerciseAdapter.setList(list);
        }
    }

    @Override
    public void err(String message) {

    }
}
