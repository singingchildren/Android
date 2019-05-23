package com.wangzijie.nutrition_user.ui.find.commentpersenter;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.NewsData;

public class CommentContract {
    public interface View extends BaseView {

        /**
         * 评论页面
         *成功
         * @param newsData
         */
        void CommentSucess(NewsData newsData);

        /**
         * 失败
         * @param msg
         */
        void CommentErr(String msg);
    }

    public interface CommentPre{

        /**
         * Persenter
         */
        void commentGetData(int blogId, int limit, int page);
    }
}
