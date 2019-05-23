package com.wangzijie.nutrition_user.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseConstant;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.DetailsgoodAdapter;
import com.wangzijie.nutrition_user.adapter.DetalisAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.chatui.ui.ChatActivity;
import com.wangzijie.nutrition_user.contract.DetailContract;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.DieticianDetailsData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.presenter.DetailPresenter;
import com.wangzijie.nutrition_user.utils.DetailsData;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 营养师详情
 */
public class More_DetailsActivity extends BaseActivity<DetailPresenter> implements DetailContract.View {

    @BindView(R.id.details_recycle)
    RecyclerView detailsRecycle;
    @BindView(R.id.more_image)
    ImageView moreImage;
    @BindView(R.id.details_imagehead)
    ImageView detailsImagehead;
    @BindView(R.id.winRecycle)
    RecyclerView winRecycle;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_username)
    TextView detailsUsername;
    @BindView(R.id.detalis_id)
    TextView detalisId;
    @BindView(R.id.details_region)
    TextView detailsRegion;
    @BindView(R.id.details_content)
    TextView detailsContent;
    @BindView(R.id.details_skill)
    TextView detailsSkill;
    @BindView(R.id.btn_buy)
    Button btnBuy;
    @BindView(R.id.btn_enquire_dietitian_details_act)
    Button btnEnquire;
    @BindView(R.id.constraintLayout9)
    ConstraintLayout constraintLayout9;

    @BindView(R.id.constraintLayout12)
    ConstraintLayout constraintLayout12;


    private ArrayList<DetailsData> detaillist = new ArrayList<>();
    private DetailsData data;
    private DetalisAdapter adapter;
    private DetailsgoodAdapter goodadapter;
    private String id;
    private String sellerId;
    private String price;
    private String hxAccount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more__details;
    }

    @Override
    protected void initView() {

        boolean isMyNutritionist = getIntent().getBooleanExtra("isMyNutritionist", false);
        if (isMyNutritionist) {
            btnBuy.setText("续费");
        }
        if (MyApplication.globalData.isNutritionist()) {
            btnBuy.setVisibility(View.GONE);
            btnEnquire.setVisibility(View.GONE);
        }
        String name = getIntent().getExtras().getString("dietitianName");
        id = getIntent().getExtras().getString("id");
        detailsName.setText(name);
      /*  data = new DetailsData();
        for (int i = 0; i < 10; i++) {
            data.setImage(R.drawable.book);
            data.setDetailasOne(1);
            detaillist.add(data);
        }*/
        adapter = new DetalisAdapter(R.layout.details_content, detaillist, this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(OrientationHelper.HORIZONTAL);
        detailsRecycle.setLayoutManager(manager);
        detailsRecycle.setHasFixedSize(true);
        detailsRecycle.setNestedScrollingEnabled(false);
        detailsRecycle.setAdapter(adapter);



        goodadapter = new DetailsgoodAdapter(R.layout.details_content, detaillist, this);
        LinearLayoutManager winmanger = new LinearLayoutManager(this);
        winmanger.setOrientation(OrientationHelper.HORIZONTAL);
        winRecycle.setLayoutManager(winmanger);
        winRecycle.setHasFixedSize(true);
        winRecycle.setNestedScrollingEnabled(false);
        winRecycle.setAdapter(goodadapter);
        goodadapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        mPresenter.detailGetData(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter();
    }

    @OnClick({R.id.more_image, R.id.btn_buy, R.id.btn_enquire_dietitian_details_act})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_image:
                finish();
                break;
            case R.id.btn_enquire_dietitian_details_act:
                startActivity(new Intent(this, ChatActivity.class)
                        .putExtra(EaseConstant.EXTRA_USER_ID,hxAccount));
                break;
            case R.id.btn_buy:
                mPresenter.generateOrder(sellerId,price, "annualfee");
                break;
        }
    }


    @Override
    public void DetailSucess(DieticianDetailsData.DataBean detailsData) {
        Glide.with(this)
                .asBitmap()
                .load(detailsData.getUserinfo().getAvatar())
                .error(R.drawable.my3)
                .into(new MyGlideHeaderLoader(detailsImagehead, this));
        if ("".equals(detailsData.getUserinfo().getNickname())){
            detailsUsername.setText("昵称");
        }else{
            detailsUsername.setText(detailsData.getUserinfo().getNickname());
        }
      //  detalisId.setText(detailsData.getUserinfo().getLoginId());
        detalisId.setText("***********");
        detailsRegion.setText(detailsData.getUserinfo().getLocation());
        detailsContent.setText(detailsData.getUserinfo().content);
        detailsSkill.setText(detailsData.getUserinfo().getService());
        price = detailsData.getUserinfo().getPrice();
        hxAccount = detailsData.getUserinfo().getHxAccount();
        sellerId=detailsData.getUserinfo().getId();



      /*  if (detailsData.getCases().size()<1){
            constraintLayout9.setVisibility(View.GONE);
        }
        if (detailsData.getCertificates().size()<1){
            constraintLayout12.setVisibility(View.GONE);
        }*/

    }

    @Override
    public void DetailErr(String msg) {
        Toast.makeText(activity,"获取营养师信息失败"+ msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OrderSucess(DataBean<OrderBean> dataBean) {
        JumpUtil.jumpMoney(this, dataBean.getData());
    }

    @Override
    public void OrderErr(String message) {
        Toast.makeText(activity,"生成订单失败"+ message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode== Constant.REQUEST_CODE_PAY
        &&resultCode==Constant.RESULT_CODE_PAY){
            new Thread(() -> {
                try {
                    //demo use a hardcode reason here, you need let user to input if you like
                    Log.e("MoreActivity,hxljq", "添加好友:"+hxAccount);
                    //demo use a hardcode reason here, you need let user to input if you like
                    String s = getResources().getString(R.string.Add_a_friend);
                    EMClient.getInstance().contactManager().addContact(hxAccount, s);
                    runOnUiThread(() -> {
                        String s1 = getResources().getString(R.string.send_successful);
                        Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_LONG).show();
                    });
                } catch (final Exception e) {
                    runOnUiThread(() -> {
                        String s2 = getResources().getString(R.string.Request_add_buddy_failure);
                        Toast.makeText(getApplicationContext(), s2 + e.getMessage(), Toast.LENGTH_LONG).show();
                    });
                }
            }).start();
        }
    }
}
