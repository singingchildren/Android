package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.DocmentsBean;

/**
 * @author fanjiangpeng
 * 通讯录管理类
 */
public class DocmentsContact {

    public interface View extends BaseView {

        /**
         * 获取成功
         * @param dataBean
         */
        void DataSuss(DocmentsBean dataBean);
        void DataSussMsg(String msg);

        /**
         * 获取失败
         * @param err
         */
        void DataErr(String err);

    }

    public interface Pre {
        /**
         * 获取好友列表
         * @param userId
         */
        void getData(String userId);
    }
}
