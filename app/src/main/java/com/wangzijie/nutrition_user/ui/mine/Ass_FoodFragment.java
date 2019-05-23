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
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.HealthyAssessmentContract;
import com.wangzijie.nutrition_user.model.bean.HealthAssessmentBean;
import com.wangzijie.nutrition_user.presenter.HealthyAssessmentPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.MyLineChart;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_FOOD;

/**
 * @author WangZequan
 * @time 2019/5/10  21:23
 * @describe 饮食评估Fragment
 */
public class Ass_FoodFragment extends BaseFragment<HealthyAssessmentPresenter> implements HealthyAssessmentContract.View {


    private final int CHART_Y_UNIT = 1000;
    @BindView(R.id.food_day)
    TextView foodDay;
    @BindView(R.id.tv1_num_food)
    TextView tv1NumFood;
    @BindView(R.id.tv2_num_food)
    TextView tv2NumFood;
    @BindView(R.id.tv3_num_food)
    TextView tv3NumFood;
    @BindView(R.id.chart_food_assess_fragment)
    MyLineChart myLineChart;
    @BindView(R.id.cl_user_food_assess_fragment)
    ConstraintLayout clUserFoodAssessFragment;


    private Calendar calendar = Calendar.getInstance();
    private String month = calendar.get(Calendar.MONTH) + 1 +"";
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private ProgressDialog waitingDialog;
    List<Entry> entries = new ArrayList<>();

    public Ass_FoodFragment() {
        // Required empty public constructor
    }

    @Override
    protected HealthyAssessmentPresenter createPresenter() {
        return new HealthyAssessmentPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.food_assess_fragment;
    }

    @Override
    protected void initData() {
        waitingDialog = DisplayUtils.showWaitingDialog(getActivity(), "获取数据中");
        String string = DisplayUtils.getTextViewDate(foodDay);
        mPresenter.getData(string, "diet");//diet/sleep/sport/psychology
    }

    @Override
    protected void initUI() {
        if (MyApplication.globalData.isNutritionist()) {
            DisplayUtils.invisibleView(clUserFoodAssessFragment);
            foodDay.setTextColor(Color.BLACK);
        } else {
            DisplayUtils.visibleView(clUserFoodAssessFragment);
            foodDay.setTextColor(Color.WHITE);
        }
    }


    @OnClick({R.id.food_day, R.id.iv_add_food_assess_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.food_day:
                DisplayUtils.showAgoCalendarDialog(getContext(), foodDay, myLineChart, (month, day) -> {
                    this.month = month;
                    this.day = day;
                    initData();
                });
                break;
            case R.id.iv_add_food_assess_fragment:
                String time = DisplayUtils.getTextViewDate(foodDay);
                Bundle bundle = new Bundle();
                bundle.putString("time", time);
                JumpUtil.startForResult(this, AddFoodActivity.class, REQUEST_CODE_FOOD, bundle);
                break;
        }
    }


    @Override
    public void DataSuss(HealthAssessmentBean bean) {
        waitingDialog.dismiss();
        HealthAssessmentBean.DataBean data = bean.getData();
        if (data == null) {
            return;
        }
//        entries.clear();
//        for (HealthAssessmentBean.DataBean.ResultBean resultBean : bean.getData().getResult()) {
//            entries.add(new Entry(resultBean.getDays(), resultBean.getNum()));
//        }
        DisplayUtils.chartMap(myLineChart, entries, data.getInitValue(),  data.getUnit(), data.getUnitName(), data.getMonth(),day);

        tv1NumFood.setText(bean.getData().getFirstNum() + "");
        tv2NumFood.setText(bean.getData().getSecondNum() + "");
        tv3NumFood.setText(bean.getData().getThirdNum() + "");

    }

    @Override
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
