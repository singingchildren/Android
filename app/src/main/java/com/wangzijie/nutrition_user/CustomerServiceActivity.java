package com.wangzijie.nutrition_user;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.hyphenate.easeui.EaseConstant;
import com.wangzijie.nutrition_user.adapter.CustomerServiceAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.chatui.ui.ChatActivity;
import com.wangzijie.nutrition_user.model.bean.CustomerServiceBean;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class CustomerServiceActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.tv_phone_customer_service)
    TextView tvPhoneCustomerService;
    @BindView(R.id.lv_customer_service)
    ListView lvCustomerService;
    private ArrayList<CustomerServiceBean> serviceList = new ArrayList();
    private CustomerServiceAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_service;
    }

    @Override
    protected void initView() {
        adapter = new CustomerServiceAdapter(this, serviceList);
        lvCustomerService.setAdapter(adapter);
        lvCustomerService.setOnItemClickListener((parent, view, position, id) -> {
            startActivity(new Intent(this, ChatActivity.class)
                    .putExtra(EaseConstant.EXTRA_USER_ID, serviceList.get(position).getAccount()));
        });
    }

    @Override
    protected void initData() {
        CustomerServiceBean serviceBean=new CustomerServiceBean();
        serviceBean.setAccount("18210889928");
        serviceBean.setName("李杰");
        serviceList.add(serviceBean);
        CustomerServiceBean serviceBean2=new CustomerServiceBean();
        serviceBean2.setAccount("15501259685");
        serviceBean2.setName("王泽全");
        serviceList.add(serviceBean2);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.iv_back, R.id.back, R.id.tv_phone_customer_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
            case R.id.back:
                finish();
                break;
            case R.id.tv_phone_customer_service:
                String string = tvPhoneCustomerService.getText().toString();
                if (!TextUtils.isEmpty(string)){
                    if (string.contains(";")) {
                        String phone= string.split(";")[1];
                        callPhone(phone);
                    }
                }
                break;
        }
    }


    /**
     * 拨打电话
     * @param phone     电话号码
     */
    public void callPhone(String phone) {
        if (!TextUtils.isEmpty(phone))
            callPhone(this, phone,true);
        else
            ToastUtil.show(this,"电话号码不正确");
    }

    /**
     * 调用系统破号
     * @param context       上下文
     * @param phoneNumber  电话号
     * @param isCall        是否直接拨打电话
     */
    public static void callPhone(Context context, String phoneNumber, boolean isCall) {

        Intent dialIntent = new Intent();//直接拨打电话
        if (isCall) {
            dialIntent.setAction(Intent.ACTION_CALL);
        }else {
            dialIntent.setAction(Intent.ACTION_DIAL);
        }
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            context.startActivity(dialIntent);
        } else {
            context.startActivity(dialIntent);
            Log.d("CustomerServiceActivity", "没有权限");
        }
    }
}
