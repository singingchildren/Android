package com.wangzijie.nutrition_user.ui.mine;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.UserInfo;
import com.wangzijie.nutrition_user.presenter.PersonageDetailsPresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActCardDisplay;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import butterknife.BindView;
import butterknife.OnClick;

/***
 * 编辑>个人资料
 * @author fanjiangpeng
 */
public class Act_Persion extends BaseActivity<PersonageDetailsPresenter> implements PersonageDetailsPresenter.PersonageDetailsPresenterView {

    @BindView(R.id.sex)
    LinearLayout sex;
    @BindView(R.id.ll_data_edition)
    LinearLayout llDataEdition;
    @BindView(R.id.tv_name_personal_act)
    TextView tvNamePersonalAct;
    @BindView(R.id.tv_account_personal_act)
    TextView tvAccountPersonalAct;
    @BindView(R.id.tv_descr_personal_act)
    TextView tvDescrPersonalAct;
    @BindView(R.id.tv_sex_personal_act)
    TextView tvSexPersonalAct;
    @BindView(R.id.iv_header_portrait)
    ImageView ivHeader;
    private UserInfo userInfo0;

    @Override
    protected int getLayoutId() {
        return R.layout.act_personal_data;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        if (MyApplication.globalData.isNutritionist()) {
            llDataEdition.setVisibility(View.VISIBLE);
        } else {
            llDataEdition.setVisibility(View.GONE);
        }
        getData();

    }

    private void getData() {
        mPresenter.getUserDetails();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    @Override
    protected PersonageDetailsPresenter createPresenter() {
        return new PersonageDetailsPresenter();
    }


    @OnClick({R.id.acpersonal_image, R.id.nickname, R.id.account, R.id.sex,
            R.id.asign, R.id.modify, R.id.exit, R.id.ll_data_edition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.acpersonal_image:
                this.finish();
                break;
            case R.id.nickname:
                JumpUtil.overlay(this, Act_Change_Nickname.class);
                break;
            case R.id.sex:
                initPopwindow();
                break;
            case R.id.asign:
                JumpUtil.overlay(this, Act_Asign.class);
                break;
            case R.id.modify://修改密码
                JumpUtil.overlay(this, Act_Modify.class);
                break;
            case R.id.exit:
                appDavikActivityUtil.jumpLogin(this);
                break;
            case R.id.ll_data_edition:
                JumpUtil.overlay(this, ActCardDisplay.class);
                break;
            default:
                break;
        }
    }

    private void initPopwindow() {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sex_popwindow, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop = (ConstraintLayout) view.findViewById(R.id.layout_pop);
        RadioButton radioButton = view.findViewById(R.id.radioButton);
        RadioGroup radio = view.findViewById(R.id.radioGroup);
        view.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        layout_pop.setOnClickListener(v -> {
            bgAlpha(1f);
            popupWindow.dismiss();

        });
        radio.setOnCheckedChangeListener((group, checkedId) -> {
            if (group.getCheckedRadioButtonId() == radioButton.getId()) {
                //ToastUtil.show(Act_Persion.this,"男");
                if (myApplication.globalData.isNutritionist()) {
                    mPresenter.changeDocunment("", "", "", "", "", "女");
                } else {
                    mPresenter.changeProfile("", "", "", "", "", "", "男", "");
                }

            } else {
                //ToastUtil.show(Act_Persion.this,"女");
                if (myApplication.globalData.isNutritionist()) {
                    mPresenter.changeDocunment("", "", "", "", "", "女");
                } else {
                    mPresenter.changeProfile("", "", "", "", "", "", "女", "");
                }
            }

        });

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //弹出的位置
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        popupWindow.showAtLocation(sex, Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        bgAlpha(0.5f);
    }

    private void bgAlpha(float alpha) {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = alpha;// 0.0-1.0
        this.getWindow().setAttributes(lp);
    }

    private void setData() {
        tvNamePersonalAct.setText(userInfo0.getData().getNickname());
        tvAccountPersonalAct.setText(userInfo0.getData().getLoginId());
        tvDescrPersonalAct.setText(userInfo0.getData().getDescr());
        tvSexPersonalAct.setText(userInfo0.getData().getGender());
        Glide.with(this)
                .asBitmap()
                .load(userInfo0.getData().getAvatar())
                .error(R.drawable.my3)
                .into(new MyGlideHeaderLoader(ivHeader, this));

    }

    @Override
    public void PersonageDetailsSuccess(UserInfo userInfo) {
        userInfo0 = userInfo;
        setData();
    }

    @Override
    public void PersonageDetailsSuccessMsg(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void PersonageDetailsError(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void putSuess(String msg) {
        mPresenter.getUserDetails();
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void putErr(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void DataSuss(String msg) {

    }

    @Override
    public void DataErr(String err) {

    }

}
