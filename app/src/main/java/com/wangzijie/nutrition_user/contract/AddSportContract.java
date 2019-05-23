package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.StopData;

public class AddSportContract {

    public interface View extends BaseView{

        /**
         * 成功
         */
        void Suss();

        /**
         * 健康运动档案
         *成功
         * @param stopData
         */
        void stopSucess(StopData stopData);


        /**
         * 失败
         * @param msg
         */
        void stopErr(String msg);

        /**
         * 失败
         */
        void Err(String err);
    }



    public interface Pre {
        /**
         * 上传 睡眠。运动
         * @param type 睡眠sleep,运动sport
         * @param sumNum    睡觉总时间咦分钟记，运动总数
         * @param time
         */
        void putSleepAndSportData(String type, String sumNum, String time);

        /**
         * Persenter
         */
        void stopGetData();
    }
}
