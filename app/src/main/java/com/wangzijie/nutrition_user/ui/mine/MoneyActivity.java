package com.wangzijie.nutrition_user.ui.mine;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipay.sdk.app.PayTask;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wangzijie.nutrition_user.AuthResult;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.PayResult;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.MoneyDataAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.MoenyContract;
import com.wangzijie.nutrition_user.model.bean.MoenyData;
import com.wangzijie.nutrition_user.model.bean.MoneyDingData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;
import com.wangzijie.nutrition_user.presenter.MoneyPersenter;
import com.wangzijie.nutrition_user.utils.MessageEvent;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 支付Activity
 */
public class MoneyActivity extends BaseActivity<MoneyPersenter> implements MoenyContract.View{

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    /**
     * 获取权限使用的 RequestCode
     */
    private static final int PERMISSIONS_REQUEST_CODE = 1002;
    @BindView(R.id.money_image)
    ImageView moneyImage;
    @BindView(R.id.money_btn)
    Button moneyBtn;
    @BindView(R.id.money_content)
    TextView moneyContent;
    @BindView(R.id.ding_recycle)
    RecyclerView dingRecycle;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.tv_orderId)
    TextView tvOrderId;
    @BindView(R.id.textView98)
    TextView Tvprice;
    @BindView(R.id.content_line)
    View contentLine;
    private ArrayList<String> list = new ArrayList<>();
    private MoneyDataAdapter adapter;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        showAlert(MoneyActivity.this, getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(MoneyActivity.this, getString(R.string.auth_failed) + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };
    private String id;
    private String btn;

    /**
     * 判断使用哪个第三方支付
     * 1 微信
     * 2 支付宝
     */
    private String Tag = "";
    private OrderBean orderBean;
    private IWXAPI iwxapi; //微信支付api
    private String payType;//支付方式
    private String mOrderId;
    private Thread payThread;
    private boolean istoWXPay;

    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton(R.string.confirm, null)
                .setOnDismissListener(onDismiss)
                .show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_money;
    }


    @Override
    protected void initView() {
        orderBean = (OrderBean) getIntent().getSerializableExtra("bean");
        if (orderBean==null) {
            Toast.makeText(activity, "订单不可用", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(orderBean.getPayPrice()))
            Tvprice.setText("总金额：" + orderBean.getPrice() + "元");
        else
            Tvprice.setText("总金额：" + orderBean.getPayPrice() + "元");
        tvOrderId.setText(orderBean.getOrderNum());
        mOrderId = orderBean.getId();

        if (null == orderBean.getTypeArr()) {//普通年费
            moneyContent.setText(orderBean.getType());
            dingRecycle.setVisibility(View.GONE);
            contentLine.setVisibility(View.VISIBLE);
        } else {// 定制化
            moneyContent.setVisibility(View.GONE);
            dingRecycle.setVisibility(View.VISIBLE);
            contentLine.setVisibility(View.GONE);
            for (int i = 0; i < orderBean.getTypeArr().length; i++) {
                list.add(orderBean.getTypeArr()[i]);
            }
            adapter = new MoneyDataAdapter(R.layout.item_moneyding, list);
            GridLayoutManager manager = new GridLayoutManager(this, 4);
            dingRecycle.setAdapter(adapter);
            dingRecycle.setLayoutManager(manager);
            adapter.notifyDataSetChanged();
        }


        radiogroup.setOnCheckedChangeListener((group, checkedId) -> {
            int id = group.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(id);
            Tag = radioButton.getTag().toString();
            switch (checkedId) {
                case R.id.radioButton3:
                    payType = MoenyContract.TYPE_WX;
                    break;
                case R.id.radioButton4:
                    payType = MoenyContract.TYPE_ALIPAY;
                    break;
            }
        });
        radiogroup.check(R.id.radioButton3);


        //RecycleView
        MoneyDingData data = new MoneyDingData();


    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        showNormal();
    }

    @Override
    protected MoneyPersenter createPresenter() {
        return new MoneyPersenter();
    }

    @OnClick({R.id.money_image, R.id.money_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.money_image:
                initPopwindow();
                break;
            case R.id.money_btn:
                if (TextUtils.isEmpty(payType)) {
                    ToastUtil.show(this, "请选择支付方式！");
                } else {
                    mPresenter.Pay(payType, mOrderId);
                }
                break;
        }
    }

    private void initPopwindow() {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_moneypopw, null);
        //给popwindow加上动画效果
        ConstraintLayout layout_pop = (ConstraintLayout) view.findViewById(R.id.moneypopw);
        Button nobtn = layout_pop.findViewById(R.id.nobtn);
        Button yesbtn = layout_pop.findViewById(R.id.yesbtn);
        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);

        // 使其聚集
        nobtn.setOnClickListener(v -> {
            popupWindow.dismiss();
            finish();
        });
        // 使其聚集
        yesbtn.setOnClickListener(v -> popupWindow.dismiss());
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //弹出的位置
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        popupWindow.showAtLocation(radiogroup, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    @Override
    public void moneySucess(MoenyData moenyData) {

    }

    @Override
    public void moneyErr(String msg) {

    }


    /**
     * 两个支付的方法
     *
     * @param bean
     * @param payType 支付类型
     */
    @Override
    public void pay(PayResultBean bean, String payType) {
        if (MoenyContract.TYPE_WX.equals(payType)) {
            toWXPay(bean);
        } else if (MoenyContract.TYPE_ALIPAY.equals(payType)) {
            AliPay(bean.getAlipayResult());
        }
    }


    public void AliPay(String message) {

        final Runnable payRunnable = () -> {
            PayTask payTask = new PayTask(MoneyActivity.this);
            payTask.pay("11111", true);
            Map<String, String> result = payTask.payV2(message, true);
            Message message1 = new Message();
            message1.what = SDK_PAY_FLAG;
            message1.obj = result;
            mHandler.sendMessage(message1);
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    /**
     * 调起微信方法
     **/
    private void toWXPay(PayResultBean bean) {
        iwxapi = WXAPIFactory.createWXAPI(this, null); //初始化微信api
        iwxapi.registerApp(bean.getAppId()); //注册appid  appid可以在开发平台获取
        istoWXPay=true;
        //这里注意要放在子线程
        Runnable payRunnable = () -> {
            PayReq request = new PayReq(); //调起微信APP的对象
            //下面是设置必要的参数，也就是前面说的参数,这几个参数从何而来请看上面说明
            request.appId = bean.getAppId();
            request.partnerId = bean.getPartnerId();
            request.prepayId = bean.getPrepayId();
            request.packageValue = bean.getPackageStr();
            request.nonceStr = bean.getNonceStr();
            request.timeStamp = bean.getTimeStamp();
            request.sign = bean.getSign();
            iwxapi.sendReq(request);//发送调起微信的请求
        };
        payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * @param keyCode 每个按键的标记
     * @param event   触碰手势对象
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            initPopwindow();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        switch (messageEvent.getMessage()) {
            case Constant.PAY_SUCCESS:
                Toast.makeText(getApplicationContext(), "支付成功", Toast.LENGTH_SHORT).show();
                setResult(Constant.RESULT_CODE_PAY);
                finish();
                break;
            case Constant.PAY_FAILED:
                Toast.makeText(getApplicationContext(), "取消支付", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onDestroy() {
        if (istoWXPay) {
            iwxapi.unregisterApp();
            iwxapi.detach();
            iwxapi=null;
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
