package com.wangzijie.nutrition_user.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseConstant;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.MoreAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.chatui.ui.ChatActivity;
import com.wangzijie.nutrition_user.contract.MoreContract;
import com.wangzijie.nutrition_user.model.bean.DzhServiceBean;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.presenter.MorePersenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 更多营养师列表
 */
public class MoreActivity extends BaseActivity<MorePersenter> implements BaseQuickAdapter.OnItemChildClickListener, MoreContract.View {

    @BindView(R.id.more_image)
    ImageView moreImage;
//    @BindView(R.id.suaixuan)
//    TextView suaixuan;
    @BindView(R.id.rcv_dietitian_more)
    RecyclerView normalView;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private List<MoreNutritionBean.DietListBean> morelist = new ArrayList<>();
    private MoreAdapter adapter;

    private double price;
    private List<DzhServiceBean> beanList = new ArrayList<>();
    private boolean isCustomizedService;
    private String hxAccount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    protected void initView() {
        isCustomizedService=getIntent().getBooleanExtra("isCustomizedService",false);
        Log.d("MoreActivity", "isCustomizedService:" + isCustomizedService);
//        mPresenter.moreGetData(1, Constant.LIMIT);

        adapter = new MoreAdapter(R.layout.item_goodnutrition);
        normalView.setLayoutManager(new LinearLayoutManager(this));
        normalView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);

        //刷新
        smart.setOnRefreshListener(refreshLayout -> {
            mPresenter.onRefresh();
        });

        //加载
        smart.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.onLoadMore();
        });
    }



    @Override
    protected void initData() {
        mPresenter.moreGetData(1, Constant.LIMIT);
    }

    @Override
    protected MorePersenter createPresenter() {
        return new MorePersenter();
    }

    ;

    //, R.id.suaixuan
    @OnClick({R.id.more_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_image:
                finish();
                break;

//            case R.id.suaixuan:
//                initPop();
//                break;
            default:
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
       MoreNutritionBean.DietListBean dataBean = morelist.get(i);
        switch (view.getId()) {
            case R.id.more_item:
                Bundle bundle=new Bundle();
                bundle.putString("id", dataBean.getDC_ID());
                bundle.putString("dietitianName", dataBean.getNickname());
                JumpUtil.overlay(this,More_DetailsActivity.class,bundle);
                break;
            case R.id.btn_consult_dietician_item:
                startActivity(new Intent(activity, ChatActivity.class)
                        .putExtra(EaseConstant.EXTRA_USER_ID, dataBean.getHxAccount()));
                break;
            case R.id.morebtn:
                if (isCustomizedService) {
//                    List<MoreNutritionBean.DietListBean> data = dataBean.getServerList();
//                    if (data.size() > 0) {
//                        for (int j = 0; j < data.size(); j++) {
//                            DzhServiceBean bean = new DzhServiceBean();
//                            bean.setId(data.get(j).getId());
//                            bean.setProjects(data.get(j).getProjects());
//                            bean.setPrice(data.get(j).getPrice());
//                            bean.setDays(data.get(j).getDays());
//                            bean.setSelect(false);
//                            beanList.add(bean);
//                        }
//                    }
//                    initPop2(dataBean, beanList);
                } else {
                    hxAccount = dataBean.getHxAccount();
                    mPresenter.generateOrder(dataBean.getId(), dataBean.getPrice(), "annualfee");
                }
                break;
            default:
                break;

        }
    }

    private void initPop() {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pop_dietitian, null);
        //给popwindow加上动画效果
        LinearLayout layout_pop = (LinearLayout) view.findViewById(R.id.pop);
        TextView dititan = view.findViewById(R.id.textView136);
        TextView dzhservice = view.findViewById(R.id.textView);
        setColor(dititan, dzhservice);
        view.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.fade_out));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);

        dititan.setOnClickListener(v -> {
            isCustomizedService=false;
            setColor(dititan, dzhservice);
            mPresenter.moreGetData(1, Constant.LIMIT);
            popupWindow.dismiss();
        });

        dzhservice.setOnClickListener(v -> {
            isCustomizedService=true;
            setColor(dititan, dzhservice);
            mPresenter.recommendData(1, Constant.LIMIT);
            popupWindow.dismiss();
        });

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //弹出的位置
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
//        popupWindow.showAsDropDown(suaixuan);
    }

    private double getPrice(List<DzhServiceBean> list) {
        price = 0;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isSelect()) {
                    price += list.get(i).getPrice();
                }
            }
        } else {
            price = 0;
        }
        return price;
    }


//    private void initPop2(MoreNutritionBean.DietListBean dataBean) {
//        price = 0;
//        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.pop_dzhservice, null);
//        //给popwindow加上动画效果
//        ConstraintLayout layout_pop = view.findViewById(R.id.pop);
//        RecyclerView recyclerView = view.findViewById(R.id.recycler);
//        TextView Tvprice = view.findViewById(R.id.price);
//        TextView pay = view.findViewById(R.id.pay);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        DzhServiceAdapter adapter = new DzhServiceAdapter(beanList);
//        recyclerView.setAdapter(adapter);
//        PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
//        adapter.setOnItemChildClickListener((baseQuickAdapter, view1, i) -> {
//            DzhServiceBean bean = (DzhServiceBean) baseQuickAdapter.getData().get(i);
//            if (bean.isSelect()) {
//                bean.setSelect(false);
//                adapter.notifyItemChanged(i);
//            } else {
//                bean.setSelect(true);
//                adapter.notifyItemChanged(i);
//            }
//            Tvprice.setText("总金额：" + getPrice(beanList) + "元");
//        });
//        layout_pop.setOnClickListener(v -> {
//            popupWindow.dismiss();
//
//            backgroundAlpha(1f);
//        });
//        pay.setOnClickListener(v -> {
//
//            Intent intent = new Intent(MoreActivity.this,MoneyActivity.class);
//            intent.putExtra("price",price);
//            intent.putExtra("id",dataBean.getId());
//            startActivity(intent);
//            ToastUtil.show(this, "修改界面中……");
//        });
//        view.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.fade_out));
//        layout_pop.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.push_bottom_in));
//        DisplayMetrics dm = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        // 设置允许在外点击消失
//        popupWindow.setOutsideTouchable(false);
//        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        //弹出的位置
//        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
//        backgroundAlpha(0.5f);
//        popupWindow.showAsDropDown(suaixuan, 0, 30);
//    }

    private void setColor(TextView dititan, TextView dzhservice) {
        if (isCustomizedService) {
            dititan.setTextColor(getResources().getColor(R.color.black_255));
            dzhservice.setTextColor(getResources().getColor(R.color.drawbrilliant));
        } else {
            dititan.setTextColor(getResources().getColor(R.color.drawbrilliant));
            dzhservice.setTextColor(getResources().getColor(R.color.black_255));
        }
    }

    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }

    /**
     * 生成订单 请求成功
     * @param orderBean
     */
    @Override
    public void orderData(OrderBean orderBean) {
        JumpUtil.jumpMoney(this,orderBean);
    }

    @Override
    public void moreSucess(MoreNutritionBean moreData, boolean hasRefresh, boolean isNextPage) {
//        if (isNextPage == false) {
//            smart.setEnableLoadMore(false);
//            morelist = moreData.getDietList();
//            adapter.setData(morelist);
//        } else {
//            if (hasRefresh) {
//                morelist = moreData.getDietList();
//                adapter.setData(morelist);
//            } else {
//                morelist.addAll(moreData.getDietList());
//                adapter.setData(morelist);
//            }
//        }
//        if (moreData.getDietList().size() == 0) {
//            ToastUtil.show(myApplication, "没有更多数据了～");
//            smart.setEnableLoadMore(false);
//        }


        if (isNextPage == false) {
            smart.setEnableLoadMore(false);
            morelist = moreData.getDietList();
            adapter.replaceData(moreData.getDietList());
        } else {
            if (hasRefresh) {
                morelist = moreData.getDietList();
                adapter.replaceData(morelist);
                smart.finishRefresh(500);
            } else {
                morelist.addAll(moreData.getDietList());
                adapter.addData(moreData.getDietList());
                smart.finishLoadMore(500);
            }
        }
        if (moreData.getDietList().size() == 0) {
            ToastUtil.show(activity, "没有更多数据了～");
            smart.setEnableLoadMore(false);
        }
    }

    @Override
    public void moreErr(String msg) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode== Constant.REQUEST_CODE_PAY
                &&resultCode==Constant.RESULT_CODE_PAY){
            new Thread(() -> {
                try {
                    Log.e("MoreActivity,hxljq", "添加好友:"+hxAccount);
                    //demo use a hardcode reason here, you need let user to input if you like
                    String s = getResources().getString(R.string.Add_a_friend);
//                    EMClient.getInstance().contactManager().addContact("cclxphifou", s);
                    EMClient.getInstance().contactManager().addContact(hxAccount, s);
                    runOnUiThread(() -> {
                        String s1 = getResources().getString(R.string.send_successful);
                        Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_LONG).show();
                    });
                } catch (final Exception e) {
                    runOnUiThread(() -> {
                        String s2 = getResources().getString(R.string.Request_add_buddy_failure);
                        Log.e("MoreActivity,hxljq", s2+e.getMessage());
                        Toast.makeText(getApplicationContext(), s2 + e.getMessage(), Toast.LENGTH_LONG).show();
                    });
                }
            }).start();
        }
    }


}
