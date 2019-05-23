package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.HealthyTextBean;

/**
 * 健康乐园正文管理
 */
public class HeathyTextContract {

    public interface View extends BaseView {
        /**
         * 获取成功
         * @param bean
         */
        void DataSuss(HealthyTextBean bean);

        /**
         * 失败
         * @param err
         */
        void DataErr(String err);
    }


    public interface Pre {
        /**
         * 获取数据
         * @param contentId
         */
        void getData(int contentId);
    }
}
