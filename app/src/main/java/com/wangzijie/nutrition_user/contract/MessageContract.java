package com.wangzijie.nutrition_user.contract;

import com.hyphenate.easeui.domain.EaseUser;
import com.wangzijie.nutrition_user.base.contract.BaseView;

import java.util.Map;

public class MessageContract {

    public interface MessageView extends BaseView {

        /**
         * 获取成功
         * @param map
         */
        void getOk(Map<String, EaseUser> map);

        /**
         * 获取失败
         * @param errMessage
         */
        void getErr(String errMessage);
    }


    public interface MessagePre{

        void getContact();

    }
}
