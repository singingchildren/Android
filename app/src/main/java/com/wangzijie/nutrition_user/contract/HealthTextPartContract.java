package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.BookMainData;

public class HealthTextPartContract {
    public interface View extends BaseView {

        /**
         * 文章正文
         * 成功方法
         * @param bookMainData
         */
        void BookmainSucess(BookMainData bookMainData);


        /**
         * 失败方法
         * @param msg
         */
        void BookmainErr(String msg);

    }


    public interface BookMainPre {

        /**
         * Persenter
         */
        void BookMainGetData();

    }
}
