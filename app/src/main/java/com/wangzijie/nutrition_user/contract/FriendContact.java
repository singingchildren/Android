package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.FriendBean;

/**
 * @author fanjiangpeng
 * 通讯录管理类
 */
public class FriendContact {

    public interface View extends BaseView {

        /**
         * 获取成功
         * @param dataBean
         */
        void DataSuss(FriendBean dataBean);

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
        void getData(int userId);
    }
}
