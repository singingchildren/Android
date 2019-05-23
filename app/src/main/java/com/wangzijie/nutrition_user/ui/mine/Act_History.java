package com.wangzijie.nutrition_user.ui.mine;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.mine.HistoryAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.CaseContract;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.presenter.HisdePersenter;
import com.wangzijie.nutrition_user.utils.DateTimeUtils;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 病例和档案历史记录
 *
 * @author fanjiangpeng
 */
public class Act_History extends BaseActivity<HisdePersenter> implements CaseContract.View  {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.tv_upload)
    TextView tvUpload;
    @BindView(R.id.header_list_history)
    StickyListHeadersListView headListHistory;

    private ArrayList<HistoryEntity.DataBean.CasesBean> historyEntities;
    private HistoryAdapter historyAdapter;

    //item  histroy_item
    @Override
    protected int getLayoutId() {
        return R.layout.act_histroy;
    }

    @Override
    protected void initView() {
        if (MyApplication.globalData.isNutritionist()) {
            DisplayUtils.goneView(tvUpload);
        }else {
            DisplayUtils.visibleView(tvUpload);
        }
    }

    @Override
    protected HisdePersenter createPresenter() {
        return new HisdePersenter();
    }

    @Override
    protected void initData() {
        mPresenter.HidesGetData(1,100, DateTimeUtils.getTime(new Date()));
    }

    @OnClick({R.id.back, R.id.tv_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.tv_upload://跳到上传病例
                JumpUtil.overlay(this, Act_Upload_Report.class);
                break;
        }
    }



    @Override
    public void HidesSucess(HistoryEntity historyEntity) {
        historyEntities = new ArrayList<>();
        historyEntities.addAll(historyEntity.getData().getCases());
        historyAdapter = new HistoryAdapter(historyEntities,this);
        headListHistory.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }

    @Override
    public void HisdeErr(String msg) {
        Toast.makeText(myApplication, "获取历史病例失败"+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initData();
    }
}
