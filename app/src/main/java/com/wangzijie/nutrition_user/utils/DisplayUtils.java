package com.wangzijie.nutrition_user.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.wangzijie.nutrition_user.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.wangzijie.nutrition_user.Constant.CHART_MOVE_DIFFERENCE_VALUE;
import static com.wangzijie.nutrition_user.ui.mine.MyAssessActivity.ntpTime;

/**
 * @author WangZequan
 * @time 2019/5/6  1:21
 * @describe 页面显示工具类  其中一些方法用到了三方库
 */
public class DisplayUtils {

    private static int LatsMonth;
    private static int LatsDay;

    /**
     * 根据手机分辨率将bip转换成像素
     *
     * @param context  上下文
     * @param dipValue dp值
     * @return px值
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将所有参数传入的view设置成View.GONE
     *
     * @param view 需要修改的view
     */
    public static void goneView(View... view) {
        for (View v : view) {
            v.setVisibility(View.GONE);
        }
    }

    /**
     * 将所有参数传入的view设置成View.VISIBLE
     *
     * @param view 需要修改的view
     */
    public static void visibleView(View... view) {
        for (View v : view) {
            v.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 将所有参数传入的view设置成View.INVISIBLE
     *
     * @param view 需要修改的view
     */
    public static void invisibleView(View... view) {
        for (View v : view) {
            v.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * implementation 'com.github.chaychan:MultipleItemRvAdapter:1.0.4'
     * 将所有参数传入id的view设置成View.VISIBLE
     *
     * @param baseViewHolder
     * @param viewIds
     */
    public static void showHolderView(BaseViewHolder baseViewHolder, @IdRes int... viewIds) {
        for (int viewId : viewIds) {
            baseViewHolder.setVisible(viewId, true);
        }
    }

    /**
     * implementation 'com.github.chaychan:MultipleItemRvAdapter:1.0.4'
     * 将所有参数传入id的view设置成View.GONE
     *
     * @param baseViewHolder MultipleItemRvAdapter中的baseViewHolder
     * @param viewIds        baseViewHolder中view的id
     */
    public static void goneHolderView(BaseViewHolder baseViewHolder, @IdRes int... viewIds) {
        for (int viewId : viewIds) {
            baseViewHolder.setVisible(viewId, false);
        }
    }

    /**
     * 设置activity的透明度
     *
     * @param alpha    应用于整个窗口的alpha值。alpha值为1.0表示完全不透明，0.0表示完全透明
     * @param activity 需要改变的界面
     */
    public static void bgAlpha(float alpha, Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alpha;// 0.0-1.0
        activity.getWindow().setAttributes(lp);
    }

    public static void initUploadPicturesPopWindow(View parent, Activity activity
            , int selectLimit, int requestCode) {

        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.healthy_pop, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop = view.findViewById(R.id.constraintLayout);
        TextView photograph = layout_pop.findViewById(R.id.photograph);
        TextView album = layout_pop.findViewById(R.id.album);
        TextView cancel = layout_pop.findViewById(R.id.cancel);
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);

        //隐藏监听
        popupWindow.setOnDismissListener(() -> {
            DisplayUtils.bgAlpha(1f, activity);
        });
        //取消
        cancel.setOnClickListener(v -> {
            popupWindow.dismiss();
        });
        // 拍照
        photograph.setOnClickListener(v -> {
            popupWindow.dismiss();
            setPhotograph(activity, requestCode);
        });
        // 相册
        album.setOnClickListener(v -> {
            popupWindow.dismiss();
            setAlbum(activity, selectLimit, requestCode);
        });


        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        DisplayUtils.bgAlpha(0.5f, activity);
    }

    /**
     * 选择相册
     */
    public static void setAlbum(Activity activity, int selectLimit, int requestCode) {
        ImagePicker.getInstance().setSelectLimit(selectLimit);
        Intent intent = new Intent(activity, ImageGridActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 选择照相
     */
    public static void setPhotograph(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
        activity.startActivityForResult(intent, requestCode);
    }


    /**
     * @param myLineChart
     */
    public static void chartMap(MyLineChart myLineChart, List<Entry> entries, int yMinValue, int yUnit, String yUnitName, String month, int day) {

        //1.设置x轴和y轴的点
        myLineChart.setScaleEnabled(false);//进制手势缩放
        myLineChart.setNoDataText("没有数据");
        myLineChart.setNoDataTextColor(Color.BLACK);
        myLineChart.setMaxVisibleValueCount(31);


        //显示x轴描述
        Description description = new Description();
        description.setEnabled(false);
        myLineChart.setDescription(description);

        //设置滑动
//        BarLineChartTouchListener barLineChartTouchListener = (BarLineChartTouchListener) myLineChart.getOnTouchListener();
//        barLineChartTouchListener.stopDeceleration();
        myLineChart.fitScreen();//重置所有缩放和拖动
        myLineChart.zoomToCenter(3.8f, 1f);//设置图标固定大小

        //透明化图例
        Legend legend = myLineChart.getLegend();
        legend.setForm(Legend.LegendForm.NONE);
        legend.setTextColor(Color.WHITE);
//        legend.setYOffset(-2);
        if (entries.size() == 0) {
            myLineChart.invalidate();
            return;
        }
        //把数据赋值到你的线条
        LineDataSet dataSet = new LineDataSet(entries
                , ""); // add entries to dataset
        dataSet.setDrawCircles(true);//是否画圆点
        dataSet.setCircleRadius(3f);
        int color = Color.rgb(0X48, 0XA8, 0X6E);
        dataSet.setHighlightLineWidth(2f);
        dataSet.setHighLightColor(Color.rgb(0XFE, 0XA3, 0X3A));//高光演示
        dataSet.setColor(color);//线条颜色
        dataSet.setCircleColor(color);//圆点颜色
        dataSet.setLineWidth(1f);//线条宽度

        //设置y轴样式
        //设置图表右边的y轴禁用
        YAxis rightAxis = myLineChart.getAxisRight();
        rightAxis.setEnabled(false);
        //设置图表左边的y轴
        YAxis leftAxis = myLineChart.getAxisLeft();
        //是否启用绘制零线:设置为true后才有后面的操作
        leftAxis.setDrawZeroLine(true);
        //设置绘制零线宽度
        leftAxis.setZeroLineWidth(5f);
        leftAxis.setEnabled(true);
        leftAxis.setTextSize(11f);
        leftAxis.setAxisMaximum(dataSet.getYMax() + yUnit);
        leftAxis.setInverted(false);//Y轴数据是否倒转
        leftAxis.setLabelCount(9);
        leftAxis.setAxisMinimum(yMinValue);
        leftAxis.setAxisMaximum(8f * yUnit + yMinValue);
        //创建Y文字格式集合
        List<String> yFormatter = new ArrayList<>();
        for (int i = 1; i <= leftAxis.getLabelCount(); i++) {
            if (i == leftAxis.getLabelCount()) {
                Log.e("DisplayUtils", "Y轴添加单位字符");
                yFormatter.add(yUnitName);
            } else {
                yFormatter.add(i * yUnit + yMinValue - yUnit + "");
            }
        }
        final int[] index = {-1};
        //设置Y的文字格式
        //直接从第一位取到最后一位,反正它是按顺序来的
        leftAxis.setValueFormatter((value, axis) -> {
//            int i=((int) value) / yUnit - yMinValue/yUnit;//当Y轴单位是1时,value值不准确无法正确计算
            if (index[0] >= yFormatter.size() - 1) {
                index[0] = -1;
            }
            index[0]++;
//            return yFormatter.get(i);
            return yFormatter.get(index[0]);
        });

        //设置x轴
        setLineChartXText(myLineChart, month);

        //3.chart设置数据
        LineData lineData = new LineData(dataSet);
        //是否绘制线条上的文字
        lineData.setDrawValues(true);
        lineData.setValueTextSize(12f);
        myLineChart.setData(lineData);

        myLineChart.notifyDataSetChanged(); // refresh
        chartMapCheckedCircle(day, myLineChart);
    }


    /**
     * 设置X的文字格式
     *
     * @param myLineChart
     * @param month
     */
    public static void setLineChartXText(MyLineChart myLineChart, String month) {
        XAxis xAxis = myLineChart.getXAxis();
        xAxis.setTextColor(Color.parseColor("#333333"));
        xAxis.setTextSize(15f);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(32);
        xAxis.setLabelCount(32);
        xAxis.setDrawAxisLine(true);//是否绘制轴线
        xAxis.setDrawGridLines(false);//设置x轴上每个点对应的线
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setGranularity(1f);//禁止放大x轴标签重绘
        //创建X文字格式集合
        List<String> xFormatter = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                xFormatter.add(month);
            } else {
                xFormatter.add(String.valueOf(i));
            }
        }
        //设置X的文字格式
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xFormatter));
    }

    /**
     * 选中折线图的某个点
     *
     * @param X           X坐标
     * @param myLineChart 折线图
     */
    public static void chartMapCheckedCircle(int X, MyLineChart myLineChart) {
        if (myLineChart != null && myLineChart.getData() != null) {
            myLineChart.moveViewToX(X - CHART_MOVE_DIFFERENCE_VALUE);
            myLineChart.highlightValue(X, 0);
        }
    }


    public static void showFutureCalendarDialog(Context context, TextView timeTextView, DateChangeListener listener) {
        StringBuffer dateTime = new StringBuffer();
        Calendar calendar;
        DatePickerDialog dialog;
        //管理时间类
        calendar = Calendar.getInstance();
        //弹出一个对话框（）DiaLog
        //获取年月日
        dialog = new DatePickerDialog(
                context, (dateView, year, month, dayOfMonth) -> {

            //设置x轴
            String sMonth;
            String sDayOfMonth;
            if (!(month / 10 > 0)) {
                sMonth = "-0" + (month + 1);
            } else {
                sMonth = "-" + (month + 1);
            }
            if (!(dayOfMonth / 10 > 0)) {
                sDayOfMonth = "-0" + dayOfMonth;
            } else {
                sDayOfMonth = "-" + dayOfMonth;
            }
            dateTime.delete(0, dateTime.length());
            dateTime.append(year);
            dateTime.append(sMonth);
            dateTime.append(sDayOfMonth);
            if (DateTimeUtils.getTime(dateTime.toString())
                    - DateTimeUtils.getTime(ntpTime) >= 0) {
                timeTextView.setText(dateTime.toString());
            } else {
                Toast.makeText(context, "不能选择过去的日期", Toast.LENGTH_SHORT).show();
                return;
            }
            if (dateTime.toString().equals(DateTimeUtils.getTime(new Date()))) {
                dateTime.delete(0, dateTime.length());
                dateTime.append("今日");
                timeTextView.setText(dateTime.toString());
            }
            if (month != LatsMonth || LatsDay != dayOfMonth) {
                if (listener != null) {
                    listener.dateChange(month + 1 + "", dayOfMonth);
                }
                Log.e("日期改变", dateTime.toString());
            }
            LatsMonth = month;
            LatsDay = dayOfMonth;
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
        //自动弹出键盘问题解决
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }


    /**
     * 获取系统日历(和折线图联动)
     *
     * @param context
     * @param timeTextView
     * @param myLineChart
     * @param listener
     */
    public static void showAgoCalendarDialog(Context context, TextView timeTextView, MyLineChart myLineChart, DateChangeListener listener) {
        StringBuffer dateTime = new StringBuffer();
        Calendar calendar;
        DatePickerDialog dialog;
        //管理时间类
        calendar = Calendar.getInstance();
        //弹出一个对话框（）DiaLog
        //获取年月日
        dialog = new DatePickerDialog(
                context, (dateView, year, month, dayOfMonth) -> {

            //设置x轴
            String sMonth;
            String sDayOfMonth;
            if (!(month / 10 > 0)) {
                sMonth = "-0" + (month + 1);
            } else {
                sMonth = "-" + (month + 1);
            }
            if (!(dayOfMonth / 10 > 0)) {
                sDayOfMonth = "-0" + dayOfMonth;
            } else {
                sDayOfMonth = "-" + dayOfMonth;
            }
            dateTime.delete(0, dateTime.length());
            dateTime.append(year);
            dateTime.append(sMonth);
            dateTime.append(sDayOfMonth);
            if (DateTimeUtils.getTime(dateTime.toString())
                    - DateTimeUtils.getTime(ntpTime) <= 0) {
                timeTextView.setText(dateTime.toString());
            } else {
                Toast.makeText(context, "不能选择未来的日期", Toast.LENGTH_SHORT).show();
                return;
            }
            DisplayUtils.chartMapCheckedCircle(dayOfMonth, myLineChart);
            if (dateTime.toString().equals(DateTimeUtils.getTime(new Date()))) {
                dateTime.delete(0, dateTime.length());
                dateTime.append("今日");
                timeTextView.setText(dateTime.toString());
            }
            if (month != LatsMonth || LatsDay != dayOfMonth) {
                listener.dateChange(month + 1 + "", dayOfMonth);
                Log.e("日期改变", dateTime.toString());
            }
            LatsMonth = month;
            LatsDay = dayOfMonth;
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
        //自动弹出键盘问题解决
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    /**
     * @param tvDate
     * @return
     */
    public static String getTextViewDate(TextView tvDate) {
        String string = tvDate.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("今日")) {
                string = DateTimeUtils.getTime(new Date());
            }
        }
        return string;
    }

    /**
     * 隐藏键盘
     */
    public static void hideKeyBoard(Activity activity) {
        ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken()
                        , InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static ProgressDialog showWaitingDialog(Context context, String title) {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
         */
        ProgressDialog waitingDialog =
                new ProgressDialog(context);
        waitingDialog.setTitle(title);
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
        return waitingDialog;
    }

    public static void showNormalDialog(Context context,String title,String message, DialogInterface.OnClickListener listener) {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(context);
        normalDialog.setTitle(title);
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("确定", listener);
        normalDialog.setNegativeButton("关闭",null);
        // 显示
        normalDialog.show();
    }


    public interface DateChangeListener {
        void dateChange(String month, int day);
    }

}
