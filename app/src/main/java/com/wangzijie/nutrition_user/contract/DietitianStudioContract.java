package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.BookMainData;
import com.wangzijie.nutrition_user.model.bean.DietitianStudioBean;

public class DietitianStudioContract {
    public interface View extends BaseView {

        void onDietitianStudioSucess(DietitianStudioBean dietitianStudioBean);

        void onDietitianStudioErr(String msg);

    }

    public interface DietitianStudioPre {

        void getDietitianStudioGetData(String userId);

    }
}
