package com.wangzijie.nutrition_user.ui.mine;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.github.mikephil.charting.data.Entry;
import com.wangzijie.nutrition_user.Constant;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


/**
 * @author WangZequan
 * @time 2019/5/10  22:18
 * @describe 运动评估Fragment
 */
public class Ass_SportsFragment extends BaseFragment {


    private final int CHART_Y_UNIT = 200;
    @BindView(R.id.stop_day)
    TextView stopDay;
    @BindView(R.id.tv1_num_sports)
    TextView tv1NumSports;
    @BindView(R.id.tv2_num_sports)
    TextView tv2NumSports;
    @BindView(R.id.tv3_num_sports)
    TextView tv3NumSports;
    @BindView(R.id.chart_sports_assess_fragment)
    MyLineChart myLineChart;
    @BindView(R.id.cl_user_sports_assess_fragment)
    ConstraintLayout clUserSportsAssessFragment;
    private Calendar calendar = Calendar.getInstance();
    private String month = calendar.get(Calendar.MONTH) + 1 + "";
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private ProgressDialog waitingDialog;
    List<Entry> entries = new ArrayList<>();

    public Ass_SportsFragment() {
        // Required empty public constructor
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.sports_assess_fragment;
    }

    @Override
    protected void initUI() {
        if (MyApplication.globalData.isNutritionist()) {
            stopDay.setTextColor(Color.BLACK);
            DisplayUtils.invisibleView(clUserSportsAssessFragment);
        } else {
            stopDay.setTextColor(Color.WHITE);
            DisplayUtils.visibleView(clUserSportsAssessFragment);
        }
    }

    @Override
    protected void initData() {
        waitingDialog = DisplayUtils.showWaitingDialog(getActivity(), "获取数据中");
        String time = DisplayUtils.getTextViewDate(stopDay);
        getData(time, "sport");//diet/sleep/sport/psychology

//        for (int i = 1; i <= day; i++) {
//            entries.add(new Entry(i, (int) (Math.random() * 7 * CHART_Y_UNIT) + CHART_Y_UNIT));
//        }
        DisplayUtils.chartMap(myLineChart, entries, CHART_Y_UNIT, CHART_Y_UNIT, "/千卡", month+"月/", day);
    }

    private void getData(String time, String type) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("time", time)
                .add("type", type)
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
                        } else {
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

    public void DataSuss(HealthAssessmentBean bean) {
        waitingDialog.dismiss();
        if (bean.getData() == null) {
            return;
        }
        tv1NumSports.setText(bean.getData().getFirstNum() + "");
        tv2NumSports.setText(bean.getData().getSecondNum() + "");
        tv3NumSports.setText(bean.getData().getThirdNum() + "");
    }

    public void DataErr(String err) {
        Toast.makeText(activity, "获取数据失败" + err, Toast.LENGTH_SHORT).show();
        waitingDialog.dismiss();
    }

    @OnClick({R.id.stop_day, R.id.iv_add_sports_assess_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stop_day:
                DisplayUtils.showAgoCalendarDialog(getContext(), stopDay, myLineChart, (month, day) -> {
                    this.month = month;
                    this.day = day;
                    initData();
                });
                break;
            case R.id.iv_add_sports_assess_fragment:
                Bundle bundle = new Bundle();
                String time = DisplayUtils.getTextViewDate(stopDay);
                bundle.putString("time",time);
                JumpUtil.startForResult(getActivity(), SchemeSportActivity.class, Constant.REQUEST_CODE_SPORT,bundle);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initData();
    }
}
