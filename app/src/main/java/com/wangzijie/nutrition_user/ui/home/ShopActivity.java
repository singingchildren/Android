package com.wangzijie.nutrition_user.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.DietitianStudioAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.DietitianStudioContract;
import com.wangzijie.nutrition_user.model.bean.DietitianStudioBean;
import com.wangzijie.nutrition_user.presenter.DietitianStudioPersenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopActivity extends BaseActivity<DietitianStudioPersenter> implements DietitianStudioContract.View, DietitianStudioAdapter.getUiserIdCallback {


    @BindView(R.id.shop_titleimage)
    ImageView shopTitleimage;
    @BindView(R.id.rv)
    RecyclerView rv;

    @BindView(R.id.studio_detailstb)
    TextView studioDetailstb;

    @BindView(R.id.textView55)
    TextView textView55;

    private Bundle bundle;

    private String id;
    private DietitianStudioAdapter dietitianStudioAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    protected void initView() {
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        id = bundle.getString("id");
        ToastUtil.show(this, title);

        studioDetailstb.setText(title);

        this.bundle = new Bundle();

    }

    @Override
    protected void initData() {

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dietitianStudioAdapter = new DietitianStudioAdapter(ShopActivity.this);
        dietitianStudioAdapter.setCallback(this);
        rv.setAdapter(dietitianStudioAdapter);
        mPresenter.getDietitianStudioGetData(id);
    }

    @Override
    protected DietitianStudioPersenter createPresenter() {
        return new DietitianStudioPersenter();
    }

    @Override
    public void onDietitianStudioSucess(DietitianStudioBean dietitianStudioBean) {
          /*
        id工作室ID
        name工作室名称，
        phone营养师电话，
        location工作室地址，
        descr工作室介绍，
        dietList:[{id，dcId, nickname, avatar}   营养师列表
        */
        textView55.setText(dietitianStudioBean.getData().getDescr());
        dietitianStudioAdapter.setList(dietitianStudioBean.getData().getDietList());

    }

    @Override
    public void onDietitianStudioErr(String msg) {
        Toast.makeText(ShopActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getUserId(String userid) {
        bundle.putString("id", userid);
        JumpUtil.overlay(this, More_DetailsActivity.class, bundle);
    }


    @OnClick({R.id.shop_titleimage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shop_titleimage:
                finish();
                break;
        }
    }

}


