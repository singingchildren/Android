package com.wangzijie.nutrition_user.base.contract;

/**
 * view 基础接口
 */
public interface BaseView {
    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError(String err);

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Show empty
     */
    void showEmpty();

}
