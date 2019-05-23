package com.wangzijie.nutrition_user.ui.find.findContent;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.FindContent;
import com.wangzijie.nutrition_user.model.bean.NewsData;

public class FindContentContract {

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



        /**
         * 正文主页
         * 成功
         * @param findContent
         */
        void FindContentSucess(FindContent findContent);


        /**
         * 失败
         */
        void FindContentErr(String msg);

    }


    public interface FindContentPre {

        /**
         * Persenter
         */

        void findComtentGetData(int id);

        /**
         * Persenter
         */
        void commentGetData(int blogId, int limit, int page);
    }

}
