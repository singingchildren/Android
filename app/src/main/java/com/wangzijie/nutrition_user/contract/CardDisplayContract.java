package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;

import org.json.JSONArray;

import java.util.List;

/**
 * @author WangZequan
 * @time 2019/5/15 20:34
 * @describe
 */
public interface CardDisplayContract {

    interface View extends BaseView {

        void getServiceOK(ServiceNeedBean serviceNeedBean);

        void err(String s);

        void saveMyCardOK();
    }

    interface Presenter {

        void getLabel();

        void saveCard(String realname, String content, String service, JSONArray jsonArray, List urlList1, List urlList2);
    }
}
