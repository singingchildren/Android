package com.wangzijie.nutrition_user.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.AddSportContract;
import com.wangzijie.nutrition_user.model.bean.StopData;
import com.wangzijie.nutrition_user.presenter.AddSportPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  添加睡眠评估
 */
public class SchemeSleepActivity extends BaseActivity<AddSportPresenter> implements AddSportContract.View {

    @BindView(R.id.sleepcon)
    ConstraintLayout sleepcon;
    @BindView(R.id.sleep_btn)
    Button sleepBtn;
    @BindView(R.id.sleeppopw)
    ConstraintLayout sleeppopw;
    @BindView(R.id.sleep_hour)
    TextView sleepHour;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.textView100)
    TextView startTime;
    @BindView(R.id.tv_date_add_sleep_assess_fragment)
    TextView tvDate;


    private int minute =8*60;
    private int hour =8;

    private String time;
    private String hour1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_scheme_sleep;
    }

    @Override
    protected void initView() {
        title.setText("睡眠计划");
        time = getIntent().getExtras().getString("time");
        if (!TextUtils.isEmpty(time)){
            tvDate.setText(time);
        }else {

        }
    }

    @Override
    protected void initData() {
        showNormal();
        setTimeText(8,0);
    }

    @Override
    protected AddSportPresenter createPresenter() {
        return new AddSportPresenter();
    }

    @OnClick({R.id.sleepcon, R.id.back, R.id.sleep_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sleepcon:
                initPopwindow();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.sleep_btn:

                mPresenter.putSleepAndSportData("sleep", hour + "",time);
                break;
            default:
                break;
        }

    }

    private void initPopwindow() {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_sleeppopw, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop =  view.findViewById(R.id.sleep_item);
        TextView notext = layout_pop.findViewById(R.id.notext);
        TextView yestext = layout_pop.findViewById(R.id.yestext);
        TimePicker hour = layout_pop.findViewById(R.id.sleep_hour);
        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);
        popupWindow.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);


        //时间选择器
        hour.setIs24HourView(true);
        hour.setCurrentHour(0);
        hour.setCurrentMinute(0);

        hour.setOnTimeChangedListener((view1, hourOfDay, minute) -> {
            setTimeText(hourOfDay,minute);
        });

        // 使其聚集
        notext.setOnClickListener(v -> {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        });
        // 使其聚集
        yestext.setOnClickListener(v -> {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //弹出的位置
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        popupWindow.showAtLocation(sleeppopw, Gravity.BOTTOM | Gravity.BOTTOM, 0, 0);

    }

    private void setTimeText(int hourOfDay,int minute) {
        this.minute = hourOfDay * 60 + minute;
        this.hour= hourOfDay + (minute>30?1:0);
        hour1 = "";
        String minuteStr = "";
        if (hourOfDay < 10) {
            hour1 = "0" + hourOfDay;
        }else {
            hour1 =  ""+hourOfDay;
        }
        if (minute < 10) {
            minuteStr = "0" + minute;
        }else {
            minuteStr = "" + minute;
        }
        sleepHour.setText(hour1 + ":" + minuteStr);
        startTime.setText(hour1 + ":" + minuteStr);
    }

    @Override
    public void Suss() {
        setResult(Constant.REQUEST_CODE_SLEEP,new Intent().putExtra("sleepTime", minute));
        this.finish();
    }

    @Override
    public void stopSucess(StopData stopData) {

    }

    @Override
    public void stopErr(String msg) {

    }

    @Override
    public void Err(String err) {
        Toast.makeText(myApplication, "提交失败:"+err, Toast.LENGTH_SHORT).show();
    }
}
