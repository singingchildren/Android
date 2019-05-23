package com.wangzijie.nutrition_user.ui.find;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.find.NewsListAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.RecommendData;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;
import com.wangzijie.nutrition_user.contract.RecommendContract;
import com.wangzijie.nutrition_user.presenter.RecommendPersenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 发现——推荐
 *
 * @author fanjiangpeng
 */
public class Fragment_Recommend extends BaseFragment<RecommendPersenter> implements RecommendContract.View {


    @BindView(R.id.rcv)
    RecyclerView rv;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    @BindView(R.id.header)
    MaterialHeader header;
    @BindView(R.id.footer)
    ClassicsFooter footer;

    private NewsListAdapter newsListAdapter;
    private ArrayList<NewsListBean> beanList;


    private int page = 1;

    public static Fragment_Recommend getInstance() {
        return new Fragment_Recommend();
    }

    @Override
    protected RecommendPersenter createPresenter() {
        return new RecommendPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {
        beanList = new ArrayList();
        beanList.add(new NewsListBean(1));
        beanList.add(new NewsListBean(2));
        beanList.add(new NewsListBean(3));
        newsListAdapter =new NewsListAdapter(beanList);
        rv.setAdapter(newsListAdapter);
        mPresenter.recommendGetData(1);
    }

    @Override
    protected void initUI() {
        super.initUI();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsListAdapter =new NewsListAdapter(beanList);
        rv.setAdapter(newsListAdapter);
        smart.setOnRefreshListener(refreshLayout -> {
            mPresenter.recommendGetData(1);
            mPresenter.recommendGetData(++page);
            refreshLayout.finishRefresh();
        });
        smart.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.recommendGetData(++page);
            refreshLayout.finishLoadMore();
        });

        newsListAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            int id = beanList.get(i).getNewsId();
            Bundle bundle = new Bundle();
            bundle.putInt("Id", id);
            JumpUtil.overlay(getActivity(), Act_Recommend_Details.class, bundle);
        });
    }


    @Override
    public void recommendSucess(RecommendData recommendData) {
        if (!recommendData.getData().isNextPage()) {
            smart.setEnableLoadMore(false);
        } else {
            page++;
        }
//       list = recommendData.getData().getData().getBlogList();
//        beanList.addAll(list);
        newsListAdapter.notifyDataSetChanged();

    }

    @Override
    public void recommendErr(String mag) {

    }

}
