package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class StudioListBean extends BaseBean {


    /**
     * data : {"studio":[{"SP_DESC":"My Studio 2","descr":"My Studio 2","agree_count":null,"SP_NAME":"STD-02","SP_ADDRESS":"Shanghai","name":"STD-02","logo":"","SP_ID":"2","SP_LOGOURL":"","id":"2","PAGINATION_NUMBER":"1"}],"nextPage":false}
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
         * studio : [{"SP_DESC":"My Studio 2","descr":"My Studio 2","agree_count":null,"SP_NAME":"STD-02","SP_ADDRESS":"Shanghai","name":"STD-02","logo":"","SP_ID":"2","SP_LOGOURL":"","id":"2","PAGINATION_NUMBER":"1"}]
         * nextPage : false
         */

        private boolean nextPage;
        private List<StudioBean> studio;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<StudioBean> getStudio() {
            return studio;
        }

        public void setStudio(List<StudioBean> studio) {
            this.studio = studio;
        }

        public static class StudioBean {
            /**
             * SP_DESC : My Studio 2
             * descr : My Studio 2
             * agree_count : null
             * SP_NAME : STD-02
             * SP_ADDRESS : Shanghai
             * name : STD-02
             * logo :
             * SP_ID : 2
             * SP_LOGOURL :
             * id : 2
             * PAGINATION_NUMBER : 1
             */

            private String SP_DESC;
            private String descr;
            private String agree_count;
            private String SP_NAME;
            private String SP_ADDRESS;
            private String name;
            private String logo;
            private String SP_ID;
            private String SP_LOGOURL;
            private String id;
            private String PAGINATION_NUMBER;

            public String getSP_DESC() {
                return SP_DESC;
            }

            public void setSP_DESC(String SP_DESC) {
                this.SP_DESC = SP_DESC;
            }

            public String getDescr() {
                return descr;
            }

            public void setDescr(String descr) {
                this.descr = descr;
            }

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

            public String getSP_ADDRESS() {
                return SP_ADDRESS;
            }

            public void setSP_ADDRESS(String SP_ADDRESS) {
                this.SP_ADDRESS = SP_ADDRESS;
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
    }
}
