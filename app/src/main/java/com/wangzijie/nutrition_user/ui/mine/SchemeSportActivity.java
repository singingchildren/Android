package com.wangzijie.nutrition_user.ui.mine;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.StopAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.AddSportContract;
import com.wangzijie.nutrition_user.model.bean.StopData;
import com.wangzijie.nutrition_user.presenter.AddSportPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加运动
 */
public class SchemeSportActivity extends BaseActivity<AddSportPresenter> implements BaseQuickAdapter.OnItemChildClickListener, AddSportContract.View {

    @BindView(R.id.stop_titleimage)
    ImageView stopTitleimage;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.stop_recycle)
    RecyclerView stopRecycle;
    @BindView(R.id.connect)
    ConstraintLayout connect;


    private ArrayList<StopData.DataBean> recyclelist = new ArrayList<>();
    private ArrayList<StopData.DataBean> addSportList = new ArrayList<>();
    private StopAdapter adapter;
    private LinearLayoutManager manager;

    private int number;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scheme_sport;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        adapter = new StopAdapter(recyclelist);
        manager = new LinearLayoutManager(this);
        adapter.setOnItemChildClickListener(this);
        stopRecycle.setLayoutManager(manager);
        stopRecycle.setAdapter(adapter);
        mPresenter.stopGetData();


    }

    @Override
    protected AddSportPresenter createPresenter() {
        return new AddSportPresenter();
    }


    @OnClick({R.id.stop_titleimage, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stop_titleimage:
                finish();
                break;
            case R.id.button4:
                number=0;
                for (StopData.DataBean dataBean : addSportList) {
                    number+=dataBean.getSumNum();
                }
                mPresenter.putSleepAndSportData("sport", number + "", getIntent().getStringExtra("time"));
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        StopData.DataBean dataBean = (StopData.DataBean) baseQuickAdapter.getData().get(i);
        initPopwindow(dataBean);
    }

    private void initPopwindow(StopData.DataBean dataBean) {
        String titles = dataBean.getTitle();//运动名称
        int constant = dataBean.getEnergyNum();//每小时千卡数
        Button stoppopwBtnone;//取消
        Button stoppopwBtntwo;//确定
        int constant2 = constant / 60;//每分钟千卡数
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_stop_popw, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop = view.findViewById(R.id.stop_popw);
        TextView title = layout_pop.findViewById(R.id.textView80);
        TextView tvConstant = layout_pop.findViewById(R.id.tv_constant_unit_add_sports_pop);
        TextView tvVariable = layout_pop.findViewById(R.id.tv_variable_unit_add_sports_pop);
        tvVariable.setText(constant + "千卡");
        title.setText(titles);
        tvConstant.setText(constant + "千卡/60分钟");
        EditText stoppopwHour = layout_pop.findViewById(R.id.stoppopw_hour);
        String string = Integer.parseInt(stoppopwHour.getText().toString()) * constant2 + "千卡";
        tvVariable.setText(string);
        stoppopwHour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.length() > 0) {
                    Log.d("SchemeSportActivity", "Integer.parseInt(stoppopwHour.getText().toString()):" + Integer.parseInt(stoppopwHour.getText().toString()));
                    Log.d("SchemeSportActivity", "变量:" + Integer.parseInt(stoppopwHour.getText().toString()) * constant2);
                    tvVariable.setText(Integer.parseInt(stoppopwHour.getText().toString()) * constant2 + "千卡");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        stoppopwBtnone = layout_pop.findViewById(R.id.stoppopw_btnone);
        stoppopwBtntwo = layout_pop.findViewById(R.id.stoppopw_btntwo);
        view.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);

        // 使其聚集
        stoppopwBtnone.setOnClickListener(v -> popupWindow.dismiss());

        stoppopwBtntwo.setOnClickListener(v -> {
            popupWindow.dismiss();
            dataBean.setSumNum(Integer.parseInt(stoppopwHour.getText().toString()) * constant2);
            addSportList.add(dataBean);
            adapter.notifyDataSetChanged();
        });

        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //弹出的位置
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        popupWindow.showAtLocation(connect, Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    @Override
    public void stopSucess(StopData stopData) {
        showNormal();
        Log.d("more数据", stopData.getData().get(0).getTitle());
        recyclelist.addAll(stopData.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void stopErr(String msg) {
        Toast.makeText(myApplication, "获取运动列表失败" + msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void Suss() {
        this.finish();
    }

    @Override
    public void Err(String err) {
        Toast.makeText(myApplication, "提交失败" + err, Toast.LENGTH_SHORT).show();
    }
}
