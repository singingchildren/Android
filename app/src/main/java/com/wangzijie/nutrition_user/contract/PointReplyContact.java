package com.wangzijie.nutrition_user.contract;


import com.wangzijie.nutrition_user.base.contract.BaseView;

public class PointReplyContact {

    public interface View extends BaseView {

        /**
         *
         * @param isReply 是否是主文章
         * @param typeId 判断点赞/收藏/评论
         * @param tag  取消/成功
         * @param code
         */
        void Suess(boolean isReply, int typeId, int tag, String code);

        void Err(String code);

    }


    public interface Pre{

        /**
         * 点赞 评论
         * @param blogId    文章的id
         * @param userId    发评论人的id
         * @param pid   父级评论的id
         * pid=0时为文章评论，pid=xx时replyId=0时为楼中楼回复，pid=xx时replyId=xx时为楼中楼@回复
         * @param isreply 是否是主文章的评论
         * @param replyId 该评论回复的userId
         * @param content   回复的正文
         * @param agreeNum  点赞数
         * @param type  点赞=>agree，评论=>comment，收藏=>private    三种操作选一种
         */
        void putPointReply(int blogId, int userId, int pid, boolean isreply, int replyId, String content, int agreeNum, int type);


        /**
         * 点赞 评论
         * @param blogId    文章的id
         * @param userId    发评论人的id
         * @param pid   父级评论的id
         * pid=0时为文章评论，pid=xx时replyId=0时为楼中楼回复，pid=xx时replyId=xx时为楼中楼@回复
         * @param isreply 是否是主文章的评论
         * @param replyId 该评论回复的userId
         * @param content   回复的正文
         * @param agreeNum  点赞数
         * @param type  点赞=>agree，评论=>comment，收藏=>private    三种操作选一种
         */
        void putWzPointReply(int blogId, int userId, int pid, boolean isreply, int replyId, String content, int agreeNum, int type);



    }
}
