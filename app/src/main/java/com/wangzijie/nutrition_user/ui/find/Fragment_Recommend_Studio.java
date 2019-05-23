package com.wangzijie.nutrition_user.ui.find;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.StudioAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.StudioContract;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;
import com.wangzijie.nutrition_user.presenter.StudioPresenter;
import com.wangzijie.nutrition_user.ui.home.ShopActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 推荐里的营养师工作室
 *
 * @author fanjiangpeng
 */
public class Fragment_Recommend_Studio extends BaseFragment<StudioPresenter> implements StudioContract.View {

    @BindView(R.id.rcv)
    RecyclerView rv;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;

    public static Fragment_Recommend_Studio getInstance() {
        return new Fragment_Recommend_Studio();
    }

    private ArrayList<StudioListBean.DataBean.StudioBean> studiolist = new ArrayList<>();
    private StudioListBean.DataBean data;
    private StudioAdapter adapter;

    @Override
    protected StudioPresenter createPresenter() {
        return new StudioPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {
        setData();
    }

    @Override
    protected void initUI() {
        super.initUI();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new StudioAdapter(R.layout.home_studio, studiolist, getActivity());
        rv.setAdapter(adapter);

        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            StudioListBean.DataBean.StudioBean data = studiolist.get(i);
            String title = data.getSP_NAME();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("id", data.getId());
            JumpUtil.overlay(getActivity(), ShopActivity.class, bundle);
        });

        smart.setOnRefreshListener(refreshLayout -> {
            smart.finishRefresh(300);
            smart.finishRefresh();
            studiolist.clear();
            setData();
        });

        smart.setOnLoadMoreListener(refreshLayout -> {
            smart.finishLoadMore(300);
            smart.finishLoadMore();
        });

    }

    private void setData() {

        adapter.notifyDataSetChanged();
    }


    @Override
    public void studioSucess(StudioListBean studioBean) {

    }

    @Override
    public void studioErr(String msg) {

    }
}
