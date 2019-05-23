package com.wangzijie.nutrition_user.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.StartActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.utils.StatusHolder;
import com.wangzijie.nutrition_user.utils.devik.AppDavikActivityUtil;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.bakumon.statuslayoutmanager.library.StatusLayoutManager;

/**
 * @author WangZequan
 * @time 2019/5/1  23:20
 * @describe Activity基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    public AppDavikActivityUtil appDavikActivityUtil = AppDavikActivityUtil.getScreenManager();
    protected T mPresenter;
    protected MyApplication myApplication;
    protected BaseActivity activity;
    protected List<Fragment> fragmentList;
    protected int lastIndex;
    private ViewGroup statusLayoutView;
    private StatusLayoutManager statusLayoutManager;
    private Unbinder bun;


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (this instanceof StartActivity) {
            StatusHolder.getInstance().setKill(false);
        } else {
            if (StatusHolder.getInstance().isKill()) {
                Intent intent = new Intent(this, StartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Log.e("StatusHolder", "app was kill");
            } else {
                Log.d("StatusHolder", "app was normal");
            }
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bun = ButterKnife.bind(this);
        appDavikActivityUtil.addAcitivy(this);
        myApplication = MyApplication.getInstance();
        activity = this;
        initStatusColor();
        //初始化控制类
        mPresenter = createPresenter();
        //控制类和视图绑定
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        setupStatusLayoutManager();
        showLoading();
        initData();
    }

    protected abstract T createPresenter();


    @Override
    protected void onDestroy() {
        appDavikActivityUtil.removeActivity(this);
        bun.unbind();
        super.onDestroy();
        //控制层调用解绑视图层方法，防止内存泄漏
        if (mPresenter != null)
            mPresenter.detachView();
    }

    private void initStatusColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = activity.getWindow();
            //设置透明状态栏,这样才能让 ContentView 向上  6.0小米手机设置 tootlbar 会被挤上去
            //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
//            window.setStatusBarColor(getColor(R.color.title_color));
            ViewGroup mContentView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
                ViewCompat.setFitsSystemWindows(mChildView, false);
            }
        }
    }

    /**
     * 设置默认选中fragment
     *
     * @param index 碎片fragment
     */
    public void selectFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragmentList.get(index);
        Fragment lastFragment = fragmentList.get(lastIndex);
        lastIndex = index;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.frame_layout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }


    @Override
    public void showNormal() {
//        if (statusLayoutView!=null)
//        statusLayoutManager.showSuccessLayout();
    }

    @Override
    public void showEmpty() {
//        if (statusLayoutView!=null)
//            statusLayoutManager.showEmptyLayout();
    }

    @Override
    public void showError(String err) {
//        if (!err.isEmpty()) {
//            Log.e("BaseView", err);
//            Toast.makeText(activity, err, Toast.LENGTH_SHORT).show();
//        }
//        if (statusLayoutView!=null)
//            statusLayoutManager.showErrorLayout();
    }

    @Override
    public void showLoading() {
//        if (statusLayoutView!=null)
//            statusLayoutManager.showLoadingLayout();
    }

    private void setupStatusLayoutManager() {
//        statusLayoutView = findViewById(R.id.status_layout);
//        if (statusLayoutView!=null)
//        statusLayoutManager = new StatusLayoutManager.Builder(statusLayoutView)

        // 设置默认布局属性
//                .setDefaultEmptyText("空白了，哈哈哈哈")
//                .setDefaultEmptyImg(R.mipmap.ic_launcher)
//                .setDefaultEmptyClickViewText("retry")
//                .setDefaultEmptyClickViewTextColor(getResources().getColor(R.color.colorAccent))
//                .setDefaultEmptyClickViewVisible(false)
//
//                .setDefaultErrorText(R.string.app_name)
//                .setDefaultErrorImg(R.mipmap.ic_launcher)
//                .setDefaultErrorClickViewText("重试一波")
//                .setDefaultErrorClickViewTextColor(getResources().getColor(R.color.colorPrimaryDark))
//                .setDefaultErrorClickViewVisible(true)
//
//                .setDefaultLayoutsBackgroundColor(Color.WHITE)

        // 自定义布局
//                .setLoadingLayout(inflate(R.layout.layout_loading))
//                .setEmptyLayout(inflate(R.layout.layout_empty))
//                .setErrorLayout(inflate(R.layout.layout_error))
//
//                .setLoadingLayout(R.layout.layout_loading)
//                .setEmptyLayout(R.layout.layout_empty)
//                .setErrorLayout(R.layout.layout_error)
//
//                .setEmptyClickViewID(R.id.tv_empty)
//                .setErrorClickViewID(R.id.tv_error)

        // 设置重试事件监听器
//                .setOnStatusChildClickListener(new OnStatusChildClickListener() {
//                    @Override
//                    public void onEmptyChildClick(View view) {
//                        statusLayoutManager.showLoadingLayout();
//                        initData();
//                    }
//
//                    @Override
//                    public void onErrorChildClick(View view) {
//                        statusLayoutManager.showLoadingLayout();
//                        initData();
//                    }
//
//                    @Override
//                    public void onCustomerChildClick(View view) {
//
//                    }
//                })
//                .build();
    }

}
