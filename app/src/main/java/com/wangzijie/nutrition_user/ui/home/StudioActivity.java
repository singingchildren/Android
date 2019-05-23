package com.wangzijie.nutrition_user.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.StudioAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.StudioContract;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;
import com.wangzijie.nutrition_user.presenter.StudioPresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页 更多工作室
 */
public class StudioActivity extends BaseActivity<StudioPresenter> implements StudioContract.View,BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.studio_titleimage)
    ImageView studioTitleimage;
    @BindView(R.id.studiorecycle)
    RecyclerView studiorecycle;
    @BindView(R.id.smart)
    SmartRefreshLayout refreshLayout;

    private ArrayList<StudioListBean.DataBean.StudioBean> studiolist = new ArrayList<>();
    private StudioListBean.DataBean data;
    private StudioAdapter adapter;

    int page = 1;
    private boolean nextPage;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_studio;
    }

    @Override
    protected void initView() {

        adapter = new StudioAdapter(R.layout.home_studio, studiolist, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        studiorecycle.setLayoutManager(manager);
        studiorecycle.setHasFixedSize(true);
        studiorecycle.setNestedScrollingEnabled(false);
        studiorecycle.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
        //刷新
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            page = 1;
            studiolist.clear();
            mPresenter.getStudioData(page);

        });

        //加载
        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (nextPage) {
                mPresenter.getStudioData(page);
            } else {
                Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                refreshLayout.finishLoadMore(1000);
            }
        });
        adapter.notifyDataSetChanged();

    }


    @Override
    protected StudioPresenter createPresenter() {
        return new StudioPresenter();
    }
    @Override
    protected void initData() {
        mPresenter.getStudioData(1);
    }

    @OnClick(R.id.studio_titleimage)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.studio_titleimage:
                finish();
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        StudioListBean.DataBean.StudioBean data = studiolist.get(i);
        String title = data.getSP_NAME();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putString("id", data.getId());
        JumpUtil.overlay(this,ShopActivity.class,bundle);
    }

    @Override
    public void studioSucess(StudioListBean studioBean) {
        Toast.makeText(this, "刷新成功", Toast.LENGTH_SHORT).show();
        refreshLayout.finishRefresh();
        page++;
        nextPage=studioBean.getData().isNextPage();
        studiolist.addAll(studioBean.getData().getStudio());
        adapter.notifyDataSetChanged();
        showNormal();
    }

    @Override
    public void studioErr(String msg) {

    }
}
