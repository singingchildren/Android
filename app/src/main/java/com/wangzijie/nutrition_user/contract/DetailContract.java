package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.DieticianDetailsData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;

public class DetailContract {

    public interface View extends BaseView {

        /**
         * 营养师详情页面
         * 成功
         * @param detailsData
         */
        void DetailSucess(DieticianDetailsData.DataBean detailsData);


        /**
         * 失败
         * @param msg
         */
        void DetailErr(String msg);

        void OrderSucess(DataBean<OrderBean> dataBean);

        void OrderErr(String message);
    }

    public interface DetailPer {
        /**
         * Persent
         * @param id
         */
        void detailGetData(String id);
    }

}
