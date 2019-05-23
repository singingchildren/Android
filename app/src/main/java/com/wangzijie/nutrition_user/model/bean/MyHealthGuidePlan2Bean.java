package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class MyHealthGuidePlan2Bean {

    /**
     * data : {"nextPage":false,"planList":[{"CMSLREP_ID":"3","CMSLREP_CONTENT":"Sleep Is OK","CMSLREP_CREATETIME":"20190508123029","CMSLREP_DCID":"5","timeStr":"2019.3.12-2019.3.21","id":"3","CMSLREP_PEROID":"2019.3.12-2019.3.21","PAGINATION_NUMBER":"1","content":"Sleep Is OK","CMSLREP_CMID":"29"}]}
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
        /**
         * nextPage : false
         * planList : [{"CMSLREP_ID":"3","CMSLREP_CONTENT":"Sleep Is OK","CMSLREP_CREATETIME":"20190508123029","CMSLREP_DCID":"5","timeStr":"2019.3.12-2019.3.21","id":"3","CMSLREP_PEROID":"2019.3.12-2019.3.21","PAGINATION_NUMBER":"1","content":"Sleep Is OK","CMSLREP_CMID":"29"}]
         */

        private boolean nextPage;
        private List<PlanListBean> planList;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<PlanListBean> getPlanList() {
            return planList;
        }

        public void setPlanList(List<PlanListBean> planList) {
            this.planList = planList;
        }

        public static class PlanListBean {
            /**
             * CMSLREP_ID : 3
             * CMSLREP_CONTENT : Sleep Is OK
             * CMSLREP_CREATETIME : 20190508123029
             * CMSLREP_DCID : 5
             * timeStr : 2019.3.12-2019.3.21
             * id : 3
             * CMSLREP_PEROID : 2019.3.12-2019.3.21
             * PAGINATION_NUMBER : 1
             * content : Sleep Is OK
             * CMSLREP_CMID : 29
             */

            private String CMSLREP_ID;
            private String CMSLREP_CONTENT;
            private String CMSLREP_CREATETIME;
            private String CMSLREP_DCID;
            private String timeStr;
            private String id;
            private String CMSLREP_PEROID;
            private String PAGINATION_NUMBER;
            private String content;
            private String CMSLREP_CMID;

            public String getCMSLREP_ID() {
                return CMSLREP_ID;
            }

            public void setCMSLREP_ID(String CMSLREP_ID) {
                this.CMSLREP_ID = CMSLREP_ID;
            }

            public String getCMSLREP_CONTENT() {
                return CMSLREP_CONTENT;
            }

            public void setCMSLREP_CONTENT(String CMSLREP_CONTENT) {
                this.CMSLREP_CONTENT = CMSLREP_CONTENT;
            }

            public String getCMSLREP_CREATETIME() {
                return CMSLREP_CREATETIME;
            }

            public void setCMSLREP_CREATETIME(String CMSLREP_CREATETIME) {
                this.CMSLREP_CREATETIME = CMSLREP_CREATETIME;
            }

            public String getCMSLREP_DCID() {
                return CMSLREP_DCID;
            }

            public void setCMSLREP_DCID(String CMSLREP_DCID) {
                this.CMSLREP_DCID = CMSLREP_DCID;
            }

            public String getTimeStr() {
                return timeStr;
            }

            public void setTimeStr(String timeStr) {
                this.timeStr = timeStr;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCMSLREP_PEROID() {
                return CMSLREP_PEROID;
            }

            public void setCMSLREP_PEROID(String CMSLREP_PEROID) {
                this.CMSLREP_PEROID = CMSLREP_PEROID;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCMSLREP_CMID() {
                return CMSLREP_CMID;
            }

            public void setCMSLREP_CMID(String CMSLREP_CMID) {
                this.CMSLREP_CMID = CMSLREP_CMID;
            }
        }
    }
}
