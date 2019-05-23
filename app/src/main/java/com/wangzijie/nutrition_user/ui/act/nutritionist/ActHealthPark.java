package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.nutritionist.HealthParkAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.HealthyParkContract;
import com.wangzijie.nutrition_user.model.bean.HealthParkBean;
import com.wangzijie.nutrition_user.presenter.HealthyParkPresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 健康乐园
 */
public class ActHealthPark extends BaseActivity<HealthyParkPresenter> implements HealthyParkContract.View {
    @BindView(R.id.home_experience_recycle)
    RecyclerView homeExperienceRecycle;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.smart)
    SmartRefreshLayout refreshLayout;
    int page = 1;
    private boolean nextPage;

    private HealthParkAdapter adapter;
    private List<HealthParkBean.DataBean.MenuListBean> dataBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.act_health_park;
    }

    @Override
    protected void initView() {
        title.setText("健康乐园");
    }

    @Override
    protected void initData() {
        homeExperienceRecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HealthParkAdapter(dataBeans);
        homeExperienceRecycle.setAdapter(adapter);
        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            HealthParkBean.DataBean.MenuListBean bean = (HealthParkBean.DataBean.MenuListBean) baseQuickAdapter.getData().get(i);
            JumpUtil.jumpSimpleWebActivity(this,bean.getImg_url(),bean.getTitle(),bean.getId());
        });
        //刷新
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            page = 1;
            dataBeans.clear();
            mPresenter.getHealthPark(page);
        });

        //加载
        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (nextPage) {
                mPresenter.getHealthPark(page);
            } else {
                Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                refreshLayout.finishLoadMore(1000);
            }
        });
        mPresenter.getHealthPark(page);
    }

    @Override
    protected HealthyParkPresenter createPresenter() {
        return new HealthyParkPresenter();
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void dataSuss(HealthParkBean healthParkBean) {
        Toast.makeText(this, "刷新成功", Toast.LENGTH_SHORT).show();
        refreshLayout.finishRefresh();
        page++;
        nextPage=healthParkBean.getData().isNextPage();
        dataBeans.addAll(healthParkBean.getData().getMenuList());
        adapter.notifyDataSetChanged();
        showNormal();
    }

    @Override
    public void dataErr(String err) {

    }



}
