package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;

public class CaseContract {
    public interface View extends BaseView {

        /**
         * 病例
         *成功
         * @param historyEntity
         */
        void HidesSucess(HistoryEntity historyEntity);

        /**
         * 失败
         * @param msg
         */
        void HisdeErr(String msg);

    }

    public interface HisdePre {
        /**
         * Persenter
         */
        void HidesGetData( int page,int limit, String date);
    }
}
