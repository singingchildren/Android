package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;

public class MoreContract {
    public interface View extends BaseView {



        /**
         * 订单
         * @param orderBean
         */
        void orderData(OrderBean orderBean);

        /**
         * 营养师列表
         * 成功
         * View
         * @param moreData
         * @param hasRefresh 是否刷新
         * @param isNextPage 是否有下一页
         */
        void moreSucess(MoreNutritionBean moreData, boolean hasRefresh, boolean isNextPage);

        /**
         * 失败
         * @param msg
         */
        void moreErr(String msg);

    }

    public interface MorePer {
        /**
         * 定制化服务
         * Persenter
         * @param page
         * @param limit
         */

        void moreGetData(int page, int limit);


        /**
         * 营养师列表
         * @param page
         * @param limit
         */
        void recommendData(int page, int limit);

        /**
         * 生成订单
         * @param sellerId
         * @param price
         * @param type
         */
        void generateOrder( String  sellerId, String price, String type);

        /**
         * 刷新
         */
        void onRefresh();

        /**
         * 加载
         */
        void onLoadMore();

    }
}
