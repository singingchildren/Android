package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.HealthArticlesBean;

/**
 * @author WangZequan
 * @time 2019/5/8 11:41
 * @describe
 */
public interface HealthArticlesContract {

    interface View extends BaseView {

        void moreSucess(HealthArticlesBean bean);

        void moreErr(String msg);
    }

    interface Presenter {
        void onLoadMore(int page);
    }
}
