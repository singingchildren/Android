package com.wangzijie.nutrition_user.ui.mine;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.SchemeFoodAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.presenter.FoodBean;
import com.wangzijie.nutrition_user.presenter.HealthGuidePresenter;
import com.wangzijie.nutrition_user.utils.SchemeFood;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  膳食健康指导方案
 */
public class Scheme_FoodFragment extends BaseFragment<HealthGuidePresenter> implements HealthGuidePresenter.HealthGuideView {

    @BindView(R.id.recyclerView)
    RecyclerView SchemeRecycle;

    private ArrayList<FoodBean> recyclelist = new ArrayList<>();
    private SchemeFood schemeFood;
    private SchemeFoodAdapter adapter;

    public Scheme_FoodFragment() {
        // Required empty public constructor
    }


    @Override
    protected HealthGuidePresenter createPresenter() {
        return new HealthGuidePresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_scheme__food;
    }



    @Override
    protected void initData() {
        showNormal();
        adapter=new SchemeFoodAdapter(R.layout.layout_shemefood,getContext());
        SchemeFoodAdapter adapter = new SchemeFoodAdapter(R.layout.item_my_nutritionist,recyclelist,getContext());

        LinearLayoutManager manager = new LinearLayoutManager(myApplication);
        SchemeRecycle.setNestedScrollingEnabled(false);
        SchemeRecycle.setLayoutManager(manager);
        SchemeRecycle.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        mPresenter.getMyHealthGuidePlan(1,100,"diet");

    }


    @Override
    public void onUpdateMyHealthGuidePlan(List<HealthPlanBean> list) {

        if (null==list||list.isEmpty()){

        }else {
            List<FoodBean> foodBeanList=new ArrayList<>();
            String[] types=list.get(0).getTypes();
            String[] names= getResources().getStringArray(R.array.food_guide_item);
            int[] icons= getResources().getIntArray(R.array.food_guide_item_icon);
            for (int i = 0; i < types.length; i++) {
                FoodBean foodBean=new FoodBean();
                foodBean.name=names[i];
                foodBean.iconResId=icons[i];
                foodBean.value=types[i];
            }
            recyclelist.clear();
            recyclelist.addAll(foodBeanList);
        }

    }

    @Override
    public void onUpdateMyHealthGuidePlan2(List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list) {

    }

    @Override
    public void err(String message) {
        showNormal();
    }
}
