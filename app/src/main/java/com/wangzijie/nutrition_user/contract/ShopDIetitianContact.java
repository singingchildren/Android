package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.ShopHeadData;

/**
 * 营养师工作室的营养师
 * @author fanjiangpeng
 */
public class ShopDIetitianContact {

    public interface View extends BaseView {
        /**
         * 成功
         */
        void DataSuss(ShopHeadData shopHeadData);

        /**
         * 失败
         * @param err
         */
        void DataErr(String err);
    }



    public interface Pre{

        /**
         * 获取数据
         * @param id
         */
        void getShopDietitianList(String id);
    }



}
