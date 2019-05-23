package com.wangzijie.nutrition_user.ui.mine;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.HealthAssessmentBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.MyLineChart;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_PSYCHOLOGY;

/**
 * @describe 心理评估Fragment
 */
public class Ass_MentalityFragment extends BaseFragment {


    private final int CHART_Y_UNIT = 1000;
    @BindView(R.id.tv_test_result_mentality_assess_fragment)
    TextView tvStatement;
    @BindView(R.id.tv_date_mentality_assess_fragment)
    TextView tvDate;
    @BindView(R.id.chart_mentality_assess_fragment)
    MyLineChart myLineChart;
    @BindView(R.id.cl_user_mentality_assess_fragment)
    ConstraintLayout clUserMentalityAssessFragment;
    private Bundle bundle;
    private Calendar calendar = Calendar.getInstance();
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private String month = calendar.get(Calendar.MONTH) + 1 + "";
    private Dialog waitingDialog;


    public Ass_MentalityFragment() {
        // Required empty public constructor
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.mentality_assess_fragment;
    }

    @Override
    protected void initData() {
        waitingDialog = DisplayUtils.showWaitingDialog(getActivity(), "获取数据中");
        String time = DisplayUtils.getTextViewDate(tvDate);
        getData(time, "psychology");//diet/sleep/sport/psychology
    }

    private void getData(String string, String type) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("time",string)
                .add("type",type)
                .build();
        ApiStore.getService()
                .getHealthAssessment(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HealthAssessmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HealthAssessmentBean bean) {
                        if (bean.isSuccess()) {
                            DataSuss(bean);
                        }else {
                            DataErr(bean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        DataErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick({R.id.tv_date_mentality_assess_fragment, R.id.iv1_add_mentality_assess_fragment, R.id.iv2_add_mentality_assess_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_date_mentality_assess_fragment:
                DisplayUtils.showAgoCalendarDialog(getContext(), tvDate, myLineChart, (month,day) -> {
                    this.month = month;
                    this.day=day;
                    initData();
                });
                break;
            case R.id.iv1_add_mentality_assess_fragment:
                bundle = new Bundle();
                bundle.putString("name", "焦虑测试");
                JumpUtil.startForResult(getActivity(), MentalityTestActivity.class,REQUEST_CODE_PSYCHOLOGY, bundle);
                break;
            case R.id.iv2_add_mentality_assess_fragment:
                bundle = new Bundle();
                bundle.putString("name", "焦压测试");
                JumpUtil.startForResult(getActivity(), MentalityTestActivity.class,REQUEST_CODE_PSYCHOLOGY, bundle);
                break;
        }
    }

    @Override
    protected void initUI() {
        if (MyApplication.globalData.isNutritionist()) {
            tvDate.setTextColor(Color.BLACK);
            DisplayUtils.invisibleView(clUserMentalityAssessFragment);
            DisplayUtils.visibleView(myLineChart);
        } else {
            tvDate.setTextColor(Color.WHITE);
            DisplayUtils.visibleView(clUserMentalityAssessFragment);
            DisplayUtils.invisibleView(myLineChart);
        }
    }

    public void DataSuss(HealthAssessmentBean bean) {
        waitingDialog.dismiss();
        int num=4;
        num = bean.getData().getFirstNum();
        switch (num) {
            case 0:
                tvStatement.setText("正常");
                break;
            case 1:
                tvStatement.setText("焦虑");
                break;
            case 2:
                tvStatement.setText("高压");
                break;
            case 3:
                tvStatement.setText("焦虑+高压");
                break;
            case 4:
                tvStatement.setText("请先做测试");
                break;
            default:
                tvStatement.setText("请先做测试");
                break;
        }
    }

    public void DataErr(String err) {
        Toast.makeText(activity, "获取数据失败" + err, Toast.LENGTH_SHORT).show();
        waitingDialog.dismiss();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initData();
    }
}
