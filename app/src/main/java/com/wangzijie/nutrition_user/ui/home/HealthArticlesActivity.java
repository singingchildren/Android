package com.wangzijie.nutrition_user.ui.home;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.wangzijie.nutrition_user.HealthArticlesAdapter;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.HealthArticlesContract;
import com.wangzijie.nutrition_user.model.bean.DzhServiceBean;
import com.wangzijie.nutrition_user.model.bean.HealthArticlesBean;
import com.wangzijie.nutrition_user.presenter.HealthArticlesPresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 更多文章
 */
public class HealthArticlesActivity extends BaseActivity<HealthArticlesPresenter> implements HealthArticlesContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.header_mero_video)
    MaterialHeader headerMeroVideo;
    @BindView(R.id.rcv_mero_video)
    RecyclerView rcvMeroVideo;
    @BindView(R.id.footer_mero_video)
    ClassicsFooter footerMeroVideo;
    @BindView(R.id.smart_mero_video)
    SmartRefreshLayout smartMeroVideo;


    private ArrayList<HealthArticlesBean.DataBean.InfoListBean> moreVideolist = new ArrayList<>();
    private HealthArticlesAdapter healthArticlesAdapter;

    private double price;
    private List<DzhServiceBean> beanList = new ArrayList<>();
    private int page=1;
    private boolean nextPage=true;
    private  boolean isRefresh;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more_video;
    }

    @Override
    protected void initView() {
        title.setText("营养健康文章");

        //创建健康视频适配器
        healthArticlesAdapter = new HealthArticlesAdapter(R.layout.item_health_advisory, moreVideolist, this);
        rcvMeroVideo.setLayoutManager(new LinearLayoutManager(this));
        rcvMeroVideo.setAdapter(healthArticlesAdapter);
        healthArticlesAdapter.replaceData(moreVideolist);


        //设置条目点击事件
        healthArticlesAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            HealthArticlesBean.DataBean.InfoListBean infoListBean = moreVideolist.get(i);
//            JumpUtil.jumpLocalVideo(getActivity(),recommendBean.getCTIF_URL());
            JumpUtil.jumpSimpleWebActivity(this, infoListBean.getUrl(), infoListBean.getTitle(), infoListBean.getId());
        });

        //刷新
        smartMeroVideo.setOnRefreshListener(refreshLayout -> {
            page = 1;
            isRefresh=true;
            moreVideolist.clear();
            mPresenter.onLoadMore(page);
        });

        //加载
        smartMeroVideo.setOnLoadMoreListener(refreshLayout -> {
            isRefresh=false;
            if (nextPage) {
                mPresenter.onLoadMore(page);
            } else {
                Toast.makeText(HealthArticlesActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initData() {
        isRefresh=false;
        mPresenter.onLoadMore(page);
    }

    @Override
    protected HealthArticlesPresenter createPresenter() {
        return new HealthArticlesPresenter();
    }


    @Override
    public void moreSucess(HealthArticlesBean bean) {
        page++;
        if (!bean.getData().isNextPage()) {
            nextPage=false;
            smartMeroVideo.setEnableLoadMore(false);
            moreVideolist.addAll(bean.getData().getInfoList());
            healthArticlesAdapter.replaceData(moreVideolist);
        } else {
            nextPage=true;
            if (isRefresh) {
                moreVideolist.clear();
                moreVideolist.addAll(bean.getData().getInfoList());
                healthArticlesAdapter.replaceData(moreVideolist);
            } else {
                moreVideolist.addAll(bean.getData().getInfoList());
                healthArticlesAdapter.addData(bean.getData().getInfoList());
            }
        }
        if (smartMeroVideo!=null) {
            smartMeroVideo.finishRefresh(1000);
            smartMeroVideo.finishLoadMore(1000);
        }
        if (bean.getData().getInfoList().size() == 0) {
            ToastUtil.show(myApplication, "没有更多数据了～");
            smartMeroVideo.setEnableLoadMore(false);
        }
    }

    @Override
    public void moreErr(String msg) {
        ToastUtil.show(myApplication,msg);
    }


    @OnClick({R.id.iv_back, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
