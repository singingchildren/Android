package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 关于我们
 *
 * @author fanjiangpeng
 */
public class Act_about_us extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    ;
    @BindView(R.id.more_detailstb)
    TextView moreDetailstb;
    @BindView(R.id.constraintLayout10)
    ConstraintLayout constraintLayout10;

    @Override
    protected int getLayoutId() {
        return R.layout.act_about_us;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        //点击返回关闭该界面
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }
}
