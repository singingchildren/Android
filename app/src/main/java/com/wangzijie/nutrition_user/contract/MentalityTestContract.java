package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.BaseBean;

/**
 * @author WangZequan
 * @time 2019/5/6 13:00
 * @describe
 */
public class MentalityTestContract {

    public interface View extends BaseView {
        void getDataOk(BaseBean bean);
        void getDataEerror(String error);
    }

    public interface Presenter {
        void getData();
    }
}
