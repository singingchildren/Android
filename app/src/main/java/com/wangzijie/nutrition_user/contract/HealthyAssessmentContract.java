package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.HealthAssessmentBean;

/**
 * 健康评估管理
 */
public class HealthyAssessmentContract {


    public interface View extends BaseView{

        /**
         *
         * @param bean
         */
        void DataSuss(HealthAssessmentBean bean);

        /**
         *
         * @param err
         */
        void DataErr(String err);
    }


    public interface Pre {

        /**
         *
         * @param time
         * @param type
         */
        void getData(String time, String type);
    }
}
