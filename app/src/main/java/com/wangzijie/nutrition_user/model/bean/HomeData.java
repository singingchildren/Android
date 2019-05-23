package com.wangzijie.nutrition_user.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeData {


    /**
     * data : {"studio":[{"agree_count":null,"SP_NAME":"STD-02","name":"STD-02","logo":"","SP_ID":"2","SP_LOGOURL":"","id":"2","PAGINATION_NUMBER":"1"}],"banner":[],"recommend":[{"content_id":null,"abstract":"运动健康视频","CTIF_URL":"http://smsapi.328ym.com/smsapi/video/play/6440fe9709204908be736ccf69cb54cf/21825691598305083.mp4","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=5","CTIF_PAGEVIEWS":"0","CTIF_ID":"5","CTIF_TITLE":"运动健康视频","pageviews":"0","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_PRIVATECOUNT":"0","id":"5","PAGINATION_NUMBER":"1"},{"content_id":null,"abstract":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","CTIF_URL":"","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=4","CTIF_PAGEVIEWS":"0","CTIF_ID":"4","CTIF_TITLE":"猪蹄真的防衰老吗？快来看看真正防衰老的4种食物吧！","pageviews":"0","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_PRIVATECOUNT":"0","id":"4","PAGINATION_NUMBER":"2"},{"content_id":null,"abstract":"23岁，癌症晚期：请对自己好一点！","CTIF_URL":"","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=3","CTIF_PAGEVIEWS":"0","CTIF_ID":"3","CTIF_TITLE":"23岁，癌症晚期：请对自己好一点！","pageviews":"0","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_PRIVATECOUNT":"0","id":"3","PAGINATION_NUMBER":"3"},{"content_id":null,"abstract":"在你心里怎样的一顿饭意味着营养丰富？","CTIF_URL":"","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=2","CTIF_PAGEVIEWS":"0","CTIF_ID":"2","CTIF_TITLE":"在你心里怎样的一顿饭意味着营养丰富？","pageviews":"0","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_PRIVATECOUNT":"0","id":"2","PAGINATION_NUMBER":"4"},{"content_id":null,"abstract":"健康生活指南","CTIF_URL":"","url":"http://101.201.209.158/jzjclub/jzjclubinfo.html?id=1","CTIF_PAGEVIEWS":"0","CTIF_ID":"1","CTIF_TITLE":"健康生活指南","pageviews":"0","img_url":"","private_count":"0","CTIF_IMGURL":"","CTIF_PRIVATECOUNT":"0","id":"1","PAGINATION_NUMBER":"5"}],"dietitian":[{"DC_ID":"12","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"45","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"45","PAGINATION_NUMBER":"1"},{"DC_ID":"11","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"44","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"44","PAGINATION_NUMBER":"2"},{"DC_ID":"10","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"43","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"43","PAGINATION_NUMBER":"3"},{"DC_ID":"9","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"42","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"42","PAGINATION_NUMBER":"4"},{"DC_ID":"8","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"36","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"36","PAGINATION_NUMBER":"5"},{"DC_ID":"7","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"35","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"35","PAGINATION_NUMBER":"6"},{"DC_ID":"6","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"34","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"34","PAGINATION_NUMBER":"7"},{"DC_ID":"5","price":150,"nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","DC_ADDRESSID":"","id":"33","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"33","PAGINATION_NUMBER":"8"}]}
     * success : true
     */

    private DataBean data;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        private List<StudioBean> studio;
        private List<BannerBean> banner;
        private List<RecommendBean> recommend;
        private List<DietitianBean> dietitian;

        public List<StudioBean> getStudio() {
            return studio;
        }

        public void setStudio(List<StudioBean> studio) {
            this.studio = studio;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<DietitianBean> getDietitian() {
            return dietitian;
        }

        public void setDietitian(List<DietitianBean> dietitian) {
            this.dietitian = dietitian;
        }

        public static class BannerBean {
            /**
             * imgUrl : http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/IMG_0330.JPG
             * AD_ID : 3
             * AD_URL : http://www.google.com
             * AD_IMGURL : demo/IMG_0330.JPG
             * id : 3
             * PAGINATION_NUMBER : 1
             * AD_TITLE : 麦丽素
             * url : http://jzjsclub.oss-cn-beijing.aliyuncs.com/http://www.google.com
             */

            private String imgUrl;
            private String AD_ID;
            private String AD_URL;
            private String AD_IMGURL;
            private String id;
            private String PAGINATION_NUMBER;
            private String AD_TITLE;
            private String url;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getAD_ID() {
                return AD_ID;
            }

            public void setAD_ID(String AD_ID) {
                this.AD_ID = AD_ID;
            }

            public String getAD_URL() {
                return AD_URL;
            }

            public void setAD_URL(String AD_URL) {
                this.AD_URL = AD_URL;
            }

            public String getAD_IMGURL() {
                return AD_IMGURL;
            }

            public void setAD_IMGURL(String AD_IMGURL) {
                this.AD_IMGURL = AD_IMGURL;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getAD_TITLE() {
                return AD_TITLE;
            }

            public void setAD_TITLE(String AD_TITLE) {
                this.AD_TITLE = AD_TITLE;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class StudioBean {
            /**
             * agree_count : null
             * SP_NAME : STD-02
             * name : STD-02
             * logo :
             * SP_ID : 2
             * SP_LOGOURL :
             * id : 2
             * PAGINATION_NUMBER : 1
             */

            private String agree_count;
            private String SP_NAME;
            private String name;
            private String logo;
            private String SP_ID;
            private String SP_LOGOURL;
            private String id;
            private String PAGINATION_NUMBER;

            public String getAgree_count() {
                return agree_count;
            }

            public void setAgree_count(String agree_count) {
                this.agree_count = agree_count;
            }

            public String getSP_NAME() {
                return SP_NAME;
            }

            public void setSP_NAME(String SP_NAME) {
                this.SP_NAME = SP_NAME;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getSP_ID() {
                return SP_ID;
            }

            public void setSP_ID(String SP_ID) {
                this.SP_ID = SP_ID;
            }

            public String getSP_LOGOURL() {
                return SP_LOGOURL;
            }

            public void setSP_LOGOURL(String SP_LOGOURL) {
                this.SP_LOGOURL = SP_LOGOURL;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }
        }

        public static class RecommendBean {
            /**
             * content_id : null
             * abstract : 运动健康视频
             * CTIF_URL : http://smsapi.328ym.com/smsapi/video/play/6440fe9709204908be736ccf69cb54cf/21825691598305083.mp4
             * url : http://101.201.209.158/jzjclub/jzjclubinfo.html?id=5
             * CTIF_PAGEVIEWS : 0
             * CTIF_ID : 5
             * CTIF_TITLE : 运动健康视频
             * pageviews : 0
             * img_url :
             * private_count : 0
             * CTIF_IMGURL :
             * CTIF_PRIVATECOUNT : 0
             * id : 5
             * PAGINATION_NUMBER : 1
             */

            private Object content_id;
            @SerializedName("abstract")
            private String abstractX;
            private String CTIF_URL;
            private String url;
            private String CTIF_PAGEVIEWS;
            private String CTIF_ID;
            private String CTIF_TITLE;
            private String pageviews;
            private String img_url;
            private String private_count;
            private String CTIF_IMGURL;
            private String CTIF_PRIVATECOUNT;
            private String id;
            private String PAGINATION_NUMBER;
            private String read_count;

            public String getRead_count() {
                return read_count;
            }

            public void setRead_count(String read_count) {
                this.read_count = read_count;
            }

            public Object getContent_id() {
                return content_id;
            }

            public void setContent_id(Object content_id) {
                this.content_id = content_id;
            }

            public String getAbstractX() {
                return abstractX;
            }

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
            }

            public String getCTIF_URL() {
                return CTIF_URL;
            }

            public void setCTIF_URL(String CTIF_URL) {
                this.CTIF_URL = CTIF_URL;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCTIF_PAGEVIEWS() {
                return CTIF_PAGEVIEWS;
            }

            public void setCTIF_PAGEVIEWS(String CTIF_PAGEVIEWS) {
                this.CTIF_PAGEVIEWS = CTIF_PAGEVIEWS;
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

            public String getPageviews() {
                return pageviews;
            }

            public void setPageviews(String pageviews) {
                this.pageviews = pageviews;
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

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }
        }

        public static class DietitianBean {
            /**
             * DC_ID : 12
             * price : 150
             * nickname :
             * U_AVATAR : http://localhost:8081/api/defaultavatarlogo.png
             * DC_ADDRESSID :
             * id : 45
             * avatar : http://localhost:8081/api/defaultavatarlogo.png
             * U_NICKNAME :
             * U_ID : 45
             * PAGINATION_NUMBER : 1
             */

            private String DC_ID;
            private int price;
            private String nickname;
            private String U_AVATAR;
            private String DC_ADDRESSID;
            private String id;
            private String avatar;
            private String U_NICKNAME;
            private String U_ID;
            private String PAGINATION_NUMBER;

            public String getDC_ID() {
                return DC_ID;
            }

            public void setDC_ID(String DC_ID) {
                this.DC_ID = DC_ID;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getU_AVATAR() {
                return U_AVATAR;
            }

            public void setU_AVATAR(String U_AVATAR) {
                this.U_AVATAR = U_AVATAR;
            }

            public String getDC_ADDRESSID() {
                return DC_ADDRESSID;
            }

            public void setDC_ADDRESSID(String DC_ADDRESSID) {
                this.DC_ADDRESSID = DC_ADDRESSID;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getU_NICKNAME() {
                return U_NICKNAME;
            }

            public void setU_NICKNAME(String U_NICKNAME) {
                this.U_NICKNAME = U_NICKNAME;
            }

            public String getU_ID() {
                return U_ID;
            }

            public void setU_ID(String U_ID) {
                this.U_ID = U_ID;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }
        }
    }
}


