package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.MyDingAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;
import com.wangzijie.nutrition_user.presenter.OrderPersenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  我的订单Activity
 */
public class MyDingActivity extends BaseActivity<OrderPersenter> implements OrderPersenter.OrderView {


    @BindView(R.id.ding_recycle)
    RecyclerView dingRecycle;
    @BindView(R.id.my_titleimage)
    TextView myTitleimage;
    private MyDingAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_ding;
    }

    @Override
    protected void initView() {

//        for (int i = 0; i <2 ; i++) {
//            myDingData = new MyDingData();
//            myDingData.setLabels(new String[]{"孕期","慢病","11"});
//            myDingData.setNumber("19032621230021");
//            list.add(myDingData);
//        }
//        for (int i = 0; i <2 ; i++) {
//            myDingData = new MyDingData();
//            myDingData.setContent("张三营养师一年服务");
//            myDingData.setNumber("19032621230022");
//            list.add(myDingData);
//        }
//        for (int i = 0; i <2 ; i++) {
//            myDingData = new MyDingData();
//            myDingData.setLabels(new String[]{"痛风","慢病"});
//            myDingData.setNumber("19032621230023");
//            list.add(myDingData);
//        }
//        Gson gson=new Gson();
//
//        String toJson = gson.toJson(list);
//        if (BuildConfig.DEBUG) Log.e("MyDingActivity", toJson);
        adapter=new MyDingAdapter(R.layout.layout);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        dingRecycle.setAdapter(adapter);
        dingRecycle.setLayoutManager(manager);
        adapter.notifyDataSetChanged();
        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            switch (view.getId()) {
                case R.id.ding_no:
                    mPresenter.delOrders(adapter.getItem(i));
                    break;
                case R.id.ding_go:
                    JumpUtil.jumpMoney(this,adapter.getItem(i));
                    break;
            }

        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.orders(1,100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected OrderPersenter createPresenter() {
        return new OrderPersenter();
    }

    @OnClick(R.id.my_titleimage)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.my_titleimage:
                finish();
                break;
        }
    }

    @Override
    public void orderData(List<OrderBean> list) {
        if (null!=list&&!list.isEmpty())
            adapter.replaceData(list);
    }

    @Override
    public void delOrders(boolean isSuccess,OrderBean orderBean) {
        if (isSuccess&&null!=orderBean){
            adapter.getData().remove(orderBean);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void pay(PayResultBean bean, String payType) {

    }

    @Override
    public void err(String message) {

    }
}
