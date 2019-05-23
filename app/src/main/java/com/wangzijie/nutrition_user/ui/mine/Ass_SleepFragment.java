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
  *  @author     WangZequan
  *  @time       2019/5/10  21:47
  *  @describe  睡眠评估Fragment
  */
public class Ass_SleepFragment extends BaseFragment {


    @BindView(R.id.tv_date_sleep_assess_fragment)
    TextView sleepDay;
    @BindView(R.id.chart_sleep_assess_fragment)
    MyLineChart myLineChart;
    @BindView(R.id.tv_sleep_duration_sleep_assess_fragment)
    TextView tv1NumSleep;

    private final int CHART_Y_UNIT = 1;
    private final int CHART_Y_MIN=3;
    @BindView(R.id.cl_user_sleep_assess_fragment)
    ConstraintLayout clUserSleepAssessFragment;

    private Calendar calendar = Calendar.getInstance();
    private String month =calendar.get(Calendar.MONTH)+1+"";
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private ProgressDialog waitingDialog;
    List<Entry> entries = new ArrayList<>();


    public Ass_SleepFragment() {
        // Required empty public constructor
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.sleep_assess_fragment;
    }

    @Override
    protected void initUI() {
        if (MyApplication.globalData.isNutritionist()) {
            DisplayUtils.invisibleView(clUserSleepAssessFragment);
            sleepDay.setTextColor(Color.BLACK);
        } else {
            DisplayUtils.visibleView(clUserSleepAssessFragment);
            sleepDay.setTextColor(Color.WHITE);
        }
    }

    @Override
    protected void initData() {
        waitingDialog = DisplayUtils.showWaitingDialog(getActivity(), "获取数据中");
        String string=DisplayUtils.getTextViewDate(sleepDay);
        getData(string, "sleep");//diet/sleep/sport/psychology
//        for (int i = 1; i <= day; i++) {
//            entries.add(new Entry(i,  (int) (Math.random() * 7 * CHART_Y_UNIT) + CHART_Y_UNIT * 3));
//        }
        DisplayUtils.chartMap(myLineChart, entries, CHART_Y_MIN, CHART_Y_UNIT, "/h",month+"月/",day);
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

    @OnClick({R.id.tv_date_sleep_assess_fragment,R.id.iv_add_sleep_assess_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_date_sleep_assess_fragment:
                DisplayUtils.showAgoCalendarDialog(getContext(), sleepDay, myLineChart, (month,day) -> {
                    this.month =month;
                    this.day =day;
                    initData();
                });
                break;
            case R.id.iv_add_sleep_assess_fragment:
                String time=DisplayUtils.getTextViewDate(sleepDay);
                Bundle bundle=new Bundle();
                bundle.putString("time",time);
                JumpUtil.startForResult(this,SchemeSleepActivity.class, Constant.REQUEST_CODE_SLEEP,bundle);
                break;
        }
    }

    public void DataSuss(HealthAssessmentBean bean) {
        waitingDialog.dismiss();
        tv1NumSleep.setText(bean.getData().getFirstNum()+"");
    }

    public void DataErr(String err) {
        Toast.makeText(activity, "获取数据失败" + err, Toast.LENGTH_SHORT).show();
        waitingDialog.dismiss();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initData();
//        String sleepTime = data.getStringExtra("sleepTime");
//        if (!TextUtils.isEmpty(sleepTime)){
//            tv1NumSleep.setText(sleepTime);
//        }

    }
}
