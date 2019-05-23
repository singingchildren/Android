package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.RecommendData;

/**
 * 收藏管理类
 */
public class CollectionsContract {

    public interface View extends BaseView{
        /**
         * 成功
         * @param data
         */
        void DataSuss(RecommendData data);

        /**
         * 失败
         * @param err
         */
        void DataErr(String err);
    }

    public interface Pre{

        /**
         * 获取数据
         * @param page
         * @param limit
         * @param type
         */
        void getData( int page, int limit, String type);

    }
}
