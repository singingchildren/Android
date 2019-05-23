package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;

public class StudioContract {

    public interface View extends BaseView {
        /**
         * 营养师工作室
         * 成功
         * @param studioBean
         */
        void studioSucess(StudioListBean studioBean);

        /**
         * 失败
         * @param msg
         */
        void studioErr(String msg);
    }

    public interface workPer {
        void getStudioData(int page);
    }


}
