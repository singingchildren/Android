package com.wangzijie.nutrition_user.ui.find.reply;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.ReplyData;

public class ReplyContract {
    public interface View extends BaseView {

        /**
         * 回复页面
         * 成功
         * @param replyData
         */
        void ReplySucess(ReplyData replyData);

        /**
         * 失败
         */
        void ReplyErr(String msg);

    }

    public interface ReplyPre {
        /**
         * Persenter
         */

        void ReplyGetData(int id);
    }
}
