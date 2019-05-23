package com.wangzijie.nutrition_user;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hyphenate.chat.EMClient;
import com.umeng.socialize.UMShareAPI;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.home.Fragment_Find;
import com.wangzijie.nutrition_user.ui.home.Fragment_home;
import com.wangzijie.nutrition_user.ui.home.Fragment_mine;
import com.wangzijie.nutrition_user.ui.message.Fragment_message;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  我改了很多不规范的命名,不想再改了,还有删了一部分神仙操作,分包就这样吧,不管了--wzq
 *
 * @author fanjiangpeng
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_tab_home)
    RadioGroup bottomTabHome;
    @BindView(R.id.navigation_home)
    RadioButton navigationHome;
    @BindView(R.id.navigation_Dietitian)
    RadioButton navigationDietitian;
    @BindView(R.id.navigation_find)
    RadioButton navigationFind;
    @BindView(R.id.navigation_mimne)
    RadioButton navigationMimne;
    @BindView(R.id.ll_main_act)
    LinearLayout llMainAct;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }



    @Override
    protected void initData() {
        initFragment();
        selectFragment(0);

    }


    /**
     * 初始化碎片
     */
    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_home());
        fragmentList.add(Fragment_message.getInstance());
        fragmentList.add(Fragment_Find.getInstance());
        fragmentList.add(new Fragment_mine());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }



    @OnClick({R.id.navigation_home, R.id.navigation_Dietitian, R.id.navigation_find, R.id.navigation_mimne,R.id.frame_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navigation_home:
                selectFragment(0);
                break;
            case R.id.navigation_Dietitian:
                selectFragment(1);
                break;
            case R.id.navigation_find:
                selectFragment(2);
                break;
            case R.id.navigation_mimne:
                selectFragment(3);
                break;

        }
    }


    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

    /**
     * 重写按键监听，点击返回键不退出应用，而是跳转到桌面
     * @param keyCode   每个按键的标记
     * @param event     触碰手势对象
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        EMClient.getInstance().logout(true);
        super.onDestroy();
    }
}


