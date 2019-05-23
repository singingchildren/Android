package com.wangzijie.nutrition_user.ui.act;

import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.HistoryAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.contract.CaseContract;
import com.wangzijie.nutrition_user.presenter.HisdePersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 病例和体检
 *
 * @author fanjiangpeng
 */
public class ActPhysicalExamination extends BaseActivity<HisdePersenter> implements CaseContract.View {
    @BindView(R.id.home_healthtext)
    TextView title;
    @BindView(R.id.header_list_history)
    StickyListHeadersListView headerListHistory;
    private List<HistoryEntity.DataBean.CasesBean> historyEntities;
    private HistoryAdapter historyAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_histroy;
    }

    @Override
    protected void initView() {
//        mPresenter.HidesGetData();
    }

    @Override
    protected void initData() {
        setData();
    }

    @Override
    protected HisdePersenter createPresenter() {
        return new HisdePersenter();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }

    private void setData() {
        title.setText("历史记录");
        historyEntities = new ArrayList();
        historyAdapter = new HistoryAdapter(historyEntities,this);
        headerListHistory.setAdapter(historyAdapter);
    }

    @Override
    public void HidesSucess(HistoryEntity historyEntity) {
        historyEntities.addAll(historyEntity.getData().getCases());
        historyAdapter.notifyDataSetChanged();
    }

    @Override
    public void HisdeErr(String msg) {

    }

}
