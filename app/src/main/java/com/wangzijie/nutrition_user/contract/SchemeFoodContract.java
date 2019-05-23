package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlanBean;

/**
 * @author fanjiangpeng
 * 膳食管理类
 */
public class SchemeFoodContract {

    public interface View extends BaseView{

        /**
         *
         * @param bean
         */
        void DataSuss(MyHealthGuidePlanBean bean);

        /**
         *  膳食返回数据
         * @param err
         */
        void DataErr(String err);

        /**
         * 睡眠。运动。心理
         * @param bean
         */
        void DataMentSuss(MyHealthGuidePlan2Bean bean);

    }


    public interface Pre {

        void getHealthAssessment(int page, int limit, String type);
    }

}
