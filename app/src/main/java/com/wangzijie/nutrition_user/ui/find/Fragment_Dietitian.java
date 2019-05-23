package com.wangzijie.nutrition_user.ui.find;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.MoreAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.MoreContract;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.presenter.MorePersenter;
import com.wangzijie.nutrition_user.ui.home.More_DetailsActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 发现>营养师
 *
 * @author fanjiangpeng
 */
public class Fragment_Dietitian extends BaseFragment<MorePersenter> implements MoreContract.View {

    @BindView(R.id.rcv)
    RecyclerView rv;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private List<MoreNutritionBean.DietListBean> morelist = new ArrayList<>();
    private MoreAdapter adapter;
    private int Page = 1;

    public static Fragment_Dietitian getInstance() {
        return new Fragment_Dietitian();
    }

    @Override
    protected MorePersenter createPresenter() {
        return new MorePersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {
        mPresenter.moreGetData(Page, Constant.LIMIT);
    }

    @Override
    protected void initUI() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MoreAdapter(R.layout.item_goodnutrition);
        rv.setAdapter(adapter);
        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            MoreNutritionBean.DietListBean moreData = morelist.get(i);
            String id = moreData.getDC_ID();
            Bundle bundle = new Bundle();
            bundle.putString("dietitianName", moreData.getNickname());
            bundle.putString("id", id);
            JumpUtil.overlay(getActivity(), More_DetailsActivity.class, bundle);
        });

        //刷新
        smart.setOnRefreshListener(refreshLayout -> {
            mPresenter.onRefresh();
        });

        //加载
        smart.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.onLoadMore();
        });
    }


    @Override
    public void orderData(OrderBean orderBean) {

    }

    @Override
    public void moreSucess(MoreNutritionBean moreData, boolean hasRefresh, boolean isNextPage) {
        if (isNextPage == false) {
            smart.setEnableLoadMore(false);
            morelist = moreData.getDietList();
            adapter.replaceData(moreData.getDietList());
        } else {
            if (hasRefresh) {
                morelist = moreData.getDietList();
                adapter.replaceData(morelist);
                smart.finishRefresh(500);
            } else {
                morelist.addAll(moreData.getDietList());
                adapter.addData(moreData.getDietList());
                smart.finishLoadMore(500);
            }
        }
        if (moreData.getDietList().size() == 0) {
            ToastUtil.show(activity, "没有更多数据了～");
            smart.setEnableLoadMore(false);
        }
    }

    @Override
    public void moreErr(String msg) {

    }
}
