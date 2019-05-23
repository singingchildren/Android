package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.AliplayBean;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.MoenyData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.PayBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;

public class MoenyContract {
    public static final String TYPE_WX="wx";
    public static final String TYPE_ALIPAY="alipay";

    public interface View extends BaseView{
        /**
         * 支付页面
         * 成功
         * @param moenyData
         */

        void moneySucess(MoenyData moenyData);

        /**
         * 失败
         * @param msg
         */

        void moneyErr(String msg);



        /**
         * 支付
         * @param bean
         */
        void pay(PayResultBean bean,String payType);



    }

    public interface MoneyPer {




        /**
         * 去支付
         * @param payChannle
         * @param orderId
         */
        void Pay(  String payChannle,String orderId);



    }

}
