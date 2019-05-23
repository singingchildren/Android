package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.nutritionist.ShopDietitianAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.ShopDIetitianContact;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.ShopHeadData;
import com.wangzijie.nutrition_user.presenter.ShopDIetitianPresenter;
import com.wangzijie.nutrition_user.ui.home.More_DetailsActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 我工作室的营养师
 */
public class ActShopDietitian extends BaseActivity<ShopDIetitianPresenter> implements ShopDIetitianContact.View {
    @BindView(R.id.home_find)
    EditText homeFind;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private ArrayList<ShopHeadData.DataBean> dietitianBeanList = new ArrayList<>();
    private ShopDietitianAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_shop_dietitian;
    }

    private String id;
    @Override
    protected void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            id = bundle.getString("id");
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopDietitianAdapter(dietitianBeanList);
        recycler.setAdapter(adapter);

        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            MoreNutritionBean.DietListBean dataBean = (MoreNutritionBean.DietListBean) baseQuickAdapter.getData().get(i);
            Bundle bundle1 = new Bundle();
            bundle1.putString("dietitianName",dataBean.getNickname());
            bundle1.putString("id",dataBean.getId());
            JumpUtil.overlay(this, More_DetailsActivity.class,bundle1);
        });
    }

    @Override
    protected void initData() {
        mPresenter.getShopDietitianList(id);
    }

    @Override
    protected ShopDIetitianPresenter createPresenter() {
        return new ShopDIetitianPresenter();
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void DataSuss(ShopHeadData shopHeadData) {
        dietitianBeanList.add(shopHeadData.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void DataErr(String err) {
        Toast.makeText(this, "获取营养师列表失败"+err, Toast.LENGTH_SHORT).show();
    }
}
