package com.wangzijie.nutrition_user.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.ReportBean;
import com.wangzijie.nutrition_user.contract.ReportContract;
import com.wangzijie.nutrition_user.presenter.ReportPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的报告
 */
public class ReportActivity extends BaseActivity<ReportPresenter>implements ReportContract.View {


    @BindView(R.id.iv_back_repoet)
    ImageView ivBackRepoet;
    @BindView(R.id.tv_rate_report_act)
    TextView tvRateReportAct;
    @BindView(R.id.tv_hint_report_act)
    TextView tvHintReportAct;
    @BindView(R.id.tv1_report_act)
    TextView tv1ReportAct;
    @BindView(R.id.tv2_report_act)
    TextView tv2ReportAct;
    @BindView(R.id.tv3_report_act)
    TextView tv3ReportAct;
    @BindView(R.id.tv4_report_act)
    TextView tv4ReportAct;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_report;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.getData(MyApplication.globalData.getToken());
    }

    @Override
    protected ReportPresenter createPresenter() {
        return new ReportPresenter();
    }

    @OnClick(R.id.iv_back_repoet)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back_repoet:
                finish();
            break;
            default:
                break;
        }
    }

    @Override
    public void Suss(ReportBean reportBean) {
        int rate=3;
        tv1ReportAct.setText(reportBean.getData().getDiet());
        tv2ReportAct.setText(reportBean.getData().getSleep());
        tv3ReportAct.setText(reportBean.getData().getSport());
        tv4ReportAct.setText(reportBean.getData().getPsychology());
        tvHintReportAct.setVisibility(View.GONE);
        rate = reportBean.getData().getRate();
        switch (rate) {
            case 0:
                tvRateReportAct.setText("优");
                break;
            case 1:
                tvRateReportAct.setText("良");
                break;
            case 2:
                tvRateReportAct.setText("差");
                break;
            case 3:
                tvHintReportAct.setVisibility(View.VISIBLE);
                tvRateReportAct.setText("数据不全");
                break;
            default:
                tvHintReportAct.setVisibility(View.VISIBLE);
                tvRateReportAct.setText("数据不全");
                break;
        }

    }

    @Override
    public void Err(String err) {

    }
}
