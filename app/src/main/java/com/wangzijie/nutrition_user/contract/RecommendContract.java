package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.RecommendData;

public class RecommendContract {

    public interface View extends BaseView {

        /**
         * 发现推荐
         *成功
         * @param recommendData
         */
        void recommendSucess(RecommendData recommendData);


        /**
         * 失败方法
         * @param mag
         */
        void recommendErr(String mag);
    }

    public interface RecommendPer {
        /**
         * Persenter
         */
        void recommendGetData(int page);

    }
}
