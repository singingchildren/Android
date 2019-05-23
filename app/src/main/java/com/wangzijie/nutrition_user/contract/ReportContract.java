package com.wangzijie.nutrition_user.contract;


import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.ReportBean;

/**
 * 我的报告管理类
 */
public class ReportContract {

    public interface View extends BaseView {

        /**
         *
         * @param reportBean
         */
        void Suss(ReportBean reportBean);

        /**
         *
         * @param err
         */
        void Err(String err);

    }


    public interface Pre {

        /**
         *
         * @param token
         */
        void getData(String token);
    }
}
