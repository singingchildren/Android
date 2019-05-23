package com.wangzijie.nutrition_user;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.LoginData;
import com.wangzijie.nutrition_user.presenter.LoginPresenter;
import com.wangzijie.nutrition_user.ui.act.LoginActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.SharedPreferenceUtil;
import com.wangzijie.nutrition_user.utils.permission.PermissionHelper;
import com.wangzijie.nutrition_user.utils.permission.PermissionInterface;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class StartActivity extends BaseActivity<LoginPresenter> implements PermissionInterface {

    //动态权限帮助类对象
    public PermissionHelper mPermissionHelper;
    @BindView(R.id.cl_bg_start)
    ConstraintLayout clBgStart;
    String[] mPermissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CHANGE_NETWORK_STATE};

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                JumpUtil.overlay(StartActivity.this, LoginActivity.class);
                finish();
            }
        }
    };
    private Unbinder bind;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        init();
    }

    @Override
    protected void initData() {

    }


    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    /**
     * 初始化并发起权限申请
     */
    public void initPermission() {
        mPermissionHelper = new PermissionHelper(this, this);
        mPermissionHelper.requestPermissions();
    }


    private void startAppSettingActivity(Activity activity) {
        Intent intent = new Intent();

        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + activity.getPackageName()));

        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        activity.startActivityForResult(intent, Constant.REQUEST_CODE_SETTINGS);
    }


    private void init() {

        handler.post(this::initPermission);
    }


    @Override
    public int getPermissionsRequestCode() {
        return 10000;
    }

    @Override
    public String[] getPermissions() {
        return mPermissionList;
    }

    @Override
    public void requestPermissionsSuccess() {
        String phone = (String) SharedPreferenceUtil.get(StartActivity.this, "phone", "");
        String pwd = (String) SharedPreferenceUtil.get(StartActivity.this, "pwd", "");
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(pwd)) {
            RequestBody body = RequestBodyBuilder.objBuilder()
                    .add("password", pwd)
                    .add("phone", phone)
                    .add("mixed", "")
                    .add("account", phone).build();
            ApiStore.getService()
                    .postLogin(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginData>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoginData loginData) {
                            if (loginData.getData() != null && loginData.getData() != null) {
                                loginIm(loginData.getData().getHxLogId(),loginData.getData().getHxPwd());
                                JumpUtil.jumpMain(StartActivity.this, loginData);
                            } else {
                                ToastUtil.show(StartActivity.this, loginData.getMessage());
                                handler.sendEmptyMessage(1);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            ToastUtil.show(StartActivity.this, e.getMessage());
                            handler.sendEmptyMessage(1);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        } else {
            handler.sendEmptyMessageDelayed(1, 2000);
        }
    }

    public void loginIm(String phone, String password) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            return;
        }
        EMClient.getInstance().login(phone, password, new EMCallBack() {
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Looper.prepare();
                Toast.makeText(StartActivity.this, "聊天服务器连接成功", Toast.LENGTH_LONG).show();
                Looper.loop();
            }

            @Override
            public void onError(int i, String s) {
                Looper.prepare();
                Log.e("StartActivity,ljq",  "i:"+i+" ,s:"+s);
                Toast.makeText(StartActivity.this, "聊天服务器连接失败:"+s, Toast.LENGTH_LONG).show();
                Looper.loop();
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });


    }

    @Override
    public void requestPermissionsFail(ArrayList<String> permissionList) {
        Toast.makeText(this, "权限申请失败，可能会导致部分功能不能使用", Toast.LENGTH_LONG).show();
        Log.d("permissionList", permissionList.toString());
    }


    /**
     * 重写Activity请求权限返回结果的回调
     *
     * @param requestCode  权限请求码
     * @param permissions  请求权限的数组
     * @param grantResults 请求的返回码数组
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
            //权限请求结果，并已经处理了该回调
//            startAppSettingActivity(this);
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
