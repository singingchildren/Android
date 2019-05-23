package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class SiteBean extends BaseBean{

    /**
     * data : {"nextPage":false,"areaList":[{"AREA_ID":"110100","areaId":"110100","areaName":"北京市","ID":"4","PAGINATION_NUMBER":"1","NAME":"北京市"}]}
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
         * areaList : [{"AREA_ID":"110100","areaId":"110100","areaName":"北京市","ID":"4","PAGINATION_NUMBER":"1","NAME":"北京市"}]
         */

        private boolean nextPage;
        private List<AreaListBean> areaList;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<AreaListBean> getAreaList() {
            return areaList;
        }

        public void setAreaList(List<AreaListBean> areaList) {
            this.areaList = areaList;
        }

        public static class AreaListBean {
            /**
             * AREA_ID : 110100
             * areaId : 110100
             * areaName : 北京市
             * ID : 4
             * PAGINATION_NUMBER : 1
             * NAME : 北京市
             */

            private String AREA_ID;
            private String areaId;
            private String areaName;
            private String ID;
            private String PAGINATION_NUMBER;
            private String NAME;

            public String getAREA_ID() {
                return AREA_ID;
            }

            public void setAREA_ID(String AREA_ID) {
                this.AREA_ID = AREA_ID;
            }

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }
        }
    }
}
