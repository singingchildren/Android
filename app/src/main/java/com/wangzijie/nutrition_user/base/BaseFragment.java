package com.wangzijie.nutrition_user.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.utils.devik.AppDavikActivityUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.bakumon.statuslayoutmanager.library.StatusLayoutManager;


/**
 * @author WangZequan
 * @time 2019/5/1  23:19
 * @describe Fragment基类
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T mPresenter;
    protected Activity activity;
    protected MyApplication myApplication;
//    private ViewGroup statusLayoutView;
    private StatusLayoutManager statusLayoutManager;
    private Unbinder bind;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResID(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        myApplication = MyApplication.getInstance();
        bind = ButterKnife.bind(this, view);
        setupStatusLayoutManager(view);
        //初始化控制类
        mPresenter = createPresenter();
        //控制类和视图绑定
        if (mPresenter != null) {
            Log.e("BaseFragment", this.getClass().getName() + ".attachView()");
            mPresenter.attachView(this);
        }
        initUI();
        initData();
    }

    protected abstract T createPresenter();

    private void setupStatusLayoutManager(View view) {
//        statusLayoutView = view.findViewById(R.id.status_layout);
//        if (statusLayoutView != null) {
//            statusLayoutManager = new StatusLayoutManager.Builder(statusLayoutView)

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
//                    .setOnStatusChildClickListener(new OnStatusChildClickListener() {
//                        @Override
//                        public void onEmptyChildClick(View view) {
//                            statusLayoutManager.showLoadingLayout();
//                            initData();
//                        }
//
//                        @Override
//                        public void onErrorChildClick(View view) {
//                            statusLayoutManager.showLoadingLayout();
//                            initData();
//                        }
//
//                        @Override
//                        public void onCustomerChildClick(View view) {
//
//                        }
//                    })
//                    .build();
//        }
    }

    @Override
    public void onDestroy() {
        bind.unbind();
        super.onDestroy();
        //控制层调用解绑视图层方法，防止内存泄漏
        if (mPresenter != null)
            mPresenter.detachView();
    }

    /**
     * 获取 布局信息
     *
     * @return
     */
    public abstract int getLayoutResID();


    /**
     * 初始化 ui 布局
     */
    protected void initUI() {
        showLoading();
    }

    /**
     * 数据初始化
     */
    protected abstract void initData();



    /**
     * 栈中销毁并移除所有Act对象
     */
    public void jumpLogin() {
        AppDavikActivityUtil.getScreenManager().jumpLogin(activity);
    }

    @Override
    public void showNormal() {
//        if (statusLayoutView != null)
//            statusLayoutManager.showSuccessLayout();
    }

    @Override
    public void showEmpty() {
//        if (statusLayoutView != null)
//            statusLayoutManager.showEmptyLayout();
    }

    @Override
    public void showError(String err) {
        if (!err.isEmpty())
            Log.e("BaseView", err);
//        if (statusLayoutView != null)
//            statusLayoutManager.showErrorLayout();
    }

    @Override
    public void showLoading() {
//        if (statusLayoutView != null)
//            statusLayoutManager.showLoadingLayout();
    }


}
