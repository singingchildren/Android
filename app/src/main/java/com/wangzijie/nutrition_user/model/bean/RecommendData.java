package com.wangzijie.nutrition_user.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendData extends BaseBean{

    /**
     * data : {"nextPage":false,"blogList":[{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"http://smsapi.328ym.com/smsapi/video/play/6440fe9709204908be736ccf69cb54cf/21825691598305083.mp4","CTIF_CREATETIME":"20190509112020","title":"运动健康视频","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=5","CTIF_ID":"5","CTIF_TITLE":"运动健康视频","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"5","CTIF_CTID":"0","PAGINATION_NUMBER":"1","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509105020","title":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=4","CTIF_ID":"4","CTIF_TITLE":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"4","CTIF_CTID":"0","PAGINATION_NUMBER":"2","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509103020","title":"23岁，癌症晚期：请对自己好一点！","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=3","CTIF_ID":"3","CTIF_TITLE":"23岁，癌症晚期：请对自己好一点！","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"3","CTIF_CTID":"0","PAGINATION_NUMBER":"3","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509102020","title":"在你心里怎样的一顿饭意味着营养丰富？","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=2","CTIF_ID":"2","CTIF_TITLE":"在你心里怎样的一顿饭意味着营养丰富？","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"2","CTIF_CTID":"0","PAGINATION_NUMBER":"4","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"让我们拥有健康的生活！","CTIF_URL":"","CTIF_CREATETIME":"20190509101020","title":"健康生活指南","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=1","CTIF_ID":"1","CTIF_TITLE":"健康生活指南","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"1","CTIF_CTID":"0","PAGINATION_NUMBER":"5","CTIF_PRIVATE":"0","transpond":"0"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nextPage : false
         * blogList : [{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"http://smsapi.328ym.com/smsapi/video/play/6440fe9709204908be736ccf69cb54cf/21825691598305083.mp4","CTIF_CREATETIME":"20190509112020","title":"运动健康视频","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=5","CTIF_ID":"5","CTIF_TITLE":"运动健康视频","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"5","CTIF_CTID":"0","PAGINATION_NUMBER":"1","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509105020","title":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=4","CTIF_ID":"4","CTIF_TITLE":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"4","CTIF_CTID":"0","PAGINATION_NUMBER":"2","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509103020","title":"23岁，癌症晚期：请对自己好一点！","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=3","CTIF_ID":"3","CTIF_TITLE":"23岁，癌症晚期：请对自己好一点！","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"3","CTIF_CTID":"0","PAGINATION_NUMBER":"3","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"","CTIF_URL":"","CTIF_CREATETIME":"20190509102020","title":"在你心里怎样的一顿饭意味着营养丰富？","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=2","CTIF_ID":"2","CTIF_TITLE":"在你心里怎样的一顿饭意味着营养丰富？","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"2","CTIF_CTID":"0","PAGINATION_NUMBER":"4","CTIF_PRIVATE":"0","transpond":"0"},{"private":false,"content_id":"0","CTIF_CONTENT":"让我们拥有健康的生活！","CTIF_URL":"","CTIF_CREATETIME":"20190509101020","title":"健康生活指南","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=1","CTIF_ID":"1","CTIF_TITLE":"健康生活指南","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_TRANSPOND":"0","CTIF_PRIVATECOUNT":"0","id":"1","CTIF_CTID":"0","PAGINATION_NUMBER":"5","CTIF_PRIVATE":"0","transpond":"0"}]
         */

        private boolean nextPage;
        private List<BlogListBean> blogList;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<BlogListBean> getBlogList() {
            return blogList;
        }

        public void setBlogList(List<BlogListBean> blogList) {
            this.blogList = blogList;
        }

        public static class BlogListBean {
            /**
             * private : false
             * content_id : 0
             * CTIF_CONTENT :
             * CTIF_URL : http://smsapi.328ym.com/smsapi/video/play/6440fe9709204908be736ccf69cb54cf/21825691598305083.mp4
             * CTIF_CREATETIME : 20190509112020
             * title : 运动健康视频
             * url : http://101.201.209.158/jzjclub/jzjclubinfo.html?id=5
             * CTIF_ID : 5
             * CTIF_TITLE : 运动健康视频
             * img_url :
             * private_count : 0
             * CTIF_IMGURL :
             * CTIF_TRANSPOND : 0
             * CTIF_PRIVATECOUNT : 0
             * id : 5
             * CTIF_CTID : 0
             * PAGINATION_NUMBER : 1
             * CTIF_PRIVATE : 0
             * transpond : 0
             */

            @SerializedName("private")
            private boolean privateX;
            private String content_id;
            private String CTIF_CONTENT;
            private String CTIF_URL;
            private String CTIF_CREATETIME;
            private String title;
            private String url;
            private String CTIF_ID;
            private String CTIF_TITLE;
            private String img_url;
            private String private_count;
            private String CTIF_IMGURL;
            private String CTIF_TRANSPOND;
            private String CTIF_PRIVATECOUNT;
            private String id;
            private String CTIF_CTID;
            private String PAGINATION_NUMBER;
            private String CTIF_PRIVATE;
            private String transpond;

            public boolean isPrivateX() {
                return privateX;
            }

            public void setPrivateX(boolean privateX) {
                this.privateX = privateX;
            }

            public String getContent_id() {
                return content_id;
            }

            public void setContent_id(String content_id) {
                this.content_id = content_id;
            }

            public String getCTIF_CONTENT() {
                return CTIF_CONTENT;
            }

            public void setCTIF_CONTENT(String CTIF_CONTENT) {
                this.CTIF_CONTENT = CTIF_CONTENT;
            }

            public String getCTIF_URL() {
                return CTIF_URL;
            }

            public void setCTIF_URL(String CTIF_URL) {
                this.CTIF_URL = CTIF_URL;
            }

            public String getCTIF_CREATETIME() {
                return CTIF_CREATETIME;
            }

            public void setCTIF_CREATETIME(String CTIF_CREATETIME) {
                this.CTIF_CREATETIME = CTIF_CREATETIME;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCTIF_ID() {
                return CTIF_ID;
            }

            public void setCTIF_ID(String CTIF_ID) {
                this.CTIF_ID = CTIF_ID;
            }

            public String getCTIF_TITLE() {
                return CTIF_TITLE;
            }

            public void setCTIF_TITLE(String CTIF_TITLE) {
                this.CTIF_TITLE = CTIF_TITLE;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getPrivate_count() {
                return private_count;
            }

            public void setPrivate_count(String private_count) {
                this.private_count = private_count;
            }

            public String getCTIF_IMGURL() {
                return CTIF_IMGURL;
            }

            public void setCTIF_IMGURL(String CTIF_IMGURL) {
                this.CTIF_IMGURL = CTIF_IMGURL;
            }

            public String getCTIF_TRANSPOND() {
                return CTIF_TRANSPOND;
            }

            public void setCTIF_TRANSPOND(String CTIF_TRANSPOND) {
                this.CTIF_TRANSPOND = CTIF_TRANSPOND;
            }

            public String getCTIF_PRIVATECOUNT() {
                return CTIF_PRIVATECOUNT;
            }

            public void setCTIF_PRIVATECOUNT(String CTIF_PRIVATECOUNT) {
                this.CTIF_PRIVATECOUNT = CTIF_PRIVATECOUNT;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCTIF_CTID() {
                return CTIF_CTID;
            }

            public void setCTIF_CTID(String CTIF_CTID) {
                this.CTIF_CTID = CTIF_CTID;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getCTIF_PRIVATE() {
                return CTIF_PRIVATE;
            }

            public void setCTIF_PRIVATE(String CTIF_PRIVATE) {
                this.CTIF_PRIVATE = CTIF_PRIVATE;
            }

            public String getTranspond() {
                return transpond;
            }

            public void setTranspond(String transpond) {
                this.transpond = transpond;
            }
        }
    }
}
