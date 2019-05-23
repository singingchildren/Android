package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;

import java.util.ArrayList;

/**
 * @author fanjiangpeng
 */
public class

UpdatadescrContract {
    public interface View extends BaseView{

        void onSuccess(SuccessBean successBean);
        void onFreali(String msg);

    }

    public interface Per{

        void getDietitianStudioGetData(String studioId, String descr, ArrayList<String> urlList);
    }
}
