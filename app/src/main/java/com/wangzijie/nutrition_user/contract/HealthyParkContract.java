package com.wangzijie.nutrition_user.contract;


import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.HealthParkBean;

public class HealthyParkContract {

    public interface View extends BaseView {

        /**
         * 请求成功
         * @param healthParkBean
         */
        void dataSuss(HealthParkBean healthParkBean);

        /**
         * 请求失败
         * @param err
         */
        void dataErr(String err);
    }


    public interface  Pre {

        /**
         *
         *健康乐园菜单e
         */
        void getHealthPark(int page);
    }
}
