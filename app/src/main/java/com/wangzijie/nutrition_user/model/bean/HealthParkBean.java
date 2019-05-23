package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class HealthParkBean extends BaseBean{


    /**
     * data : {"menuList":[{"CT_TITLE":"三高防范","pageviews":"0","img_url":"","CT_IMGURL":"","private_count":"0","CT_PRIVATECOUNT":"0","id":"1","title":"三高防范","PAGINATION_NUMBER":"1","CT_ID":"1","CT_PAGEVIEWS":"0","CT_CREATETIME":"20190508003119"}],"nextPage":false}
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
         * menuList : [{"CT_TITLE":"三高防范","pageviews":"0","img_url":"","CT_IMGURL":"","private_count":"0","CT_PRIVATECOUNT":"0","id":"1","title":"三高防范","PAGINATION_NUMBER":"1","CT_ID":"1","CT_PAGEVIEWS":"0","CT_CREATETIME":"20190508003119"}]
         * nextPage : false
         */

        private boolean nextPage;
        private List<MenuListBean> menuList;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<MenuListBean> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<MenuListBean> menuList) {
            this.menuList = menuList;
        }

        public static class MenuListBean {
            /**
             * CT_TITLE : 三高防范
             * pageviews : 0
             * img_url :
             * CT_IMGURL :
             * private_count : 0
             * CT_PRIVATECOUNT : 0
             * id : 1
             * title : 三高防范
             * PAGINATION_NUMBER : 1
             * CT_ID : 1
             * CT_PAGEVIEWS : 0
             * CT_CREATETIME : 20190508003119
             */

            private String CT_TITLE;
            private String pageviews;
            private String img_url;
            private String CT_IMGURL;
            private String private_count;
            private String CT_PRIVATECOUNT;
            private String id;
            private String title;
            private String PAGINATION_NUMBER;
            private String CT_ID;
            private String CT_PAGEVIEWS;
            private String CT_CREATETIME;

            public String getCT_TITLE() {
                return CT_TITLE;
            }

            public void setCT_TITLE(String CT_TITLE) {
                this.CT_TITLE = CT_TITLE;
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

            public String getCT_IMGURL() {
                return CT_IMGURL;
            }

            public void setCT_IMGURL(String CT_IMGURL) {
                this.CT_IMGURL = CT_IMGURL;
            }

            public String getPrivate_count() {
                return private_count;
            }

            public void setPrivate_count(String private_count) {
                this.private_count = private_count;
            }

            public String getCT_PRIVATECOUNT() {
                return CT_PRIVATECOUNT;
            }

            public void setCT_PRIVATECOUNT(String CT_PRIVATECOUNT) {
                this.CT_PRIVATECOUNT = CT_PRIVATECOUNT;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getCT_ID() {
                return CT_ID;
            }

            public void setCT_ID(String CT_ID) {
                this.CT_ID = CT_ID;
            }

            public String getCT_PAGEVIEWS() {
                return CT_PAGEVIEWS;
            }

            public void setCT_PAGEVIEWS(String CT_PAGEVIEWS) {
                this.CT_PAGEVIEWS = CT_PAGEVIEWS;
            }

            public String getCT_CREATETIME() {
                return CT_CREATETIME;
            }

            public void setCT_CREATETIME(String CT_CREATETIME) {
                this.CT_CREATETIME = CT_CREATETIME;
            }
        }
    }
}
