package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * @author fanjiangpeng
 */
public class UserFileListBean extends BaseBean{


    /**
     * data : {"nextPage":false,"list":[{"DCCM_ID":"1","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"24","userId":"24","PAGINATION_NUMBER":"1","group":"","status":"0"},{"DCCM_ID":"2","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"25","userId":"25","PAGINATION_NUMBER":"2","group":"","status":"0"},{"DCCM_ID":"3","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"26","userId":"26","PAGINATION_NUMBER":"3","group":"","status":"0"}]}
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
         * list : [{"DCCM_ID":"1","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"24","userId":"24","PAGINATION_NUMBER":"1","group":"","status":"0"},{"DCCM_ID":"2","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"25","userId":"25","PAGINATION_NUMBER":"2","group":"","status":"0"},{"DCCM_ID":"3","DCCM_STATUS":"0","nickname":"","U_NICKNAME":"","DCCM_GROUP":"","U_ID":"26","userId":"26","PAGINATION_NUMBER":"3","group":"","status":"0"}]
         */

        private boolean nextPage;
        private List<ListBean> list;

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * DCCM_ID : 1
             * DCCM_STATUS : 0
             * nickname :
             * U_NICKNAME :
             * DCCM_GROUP :
             * U_ID : 24
             * userId : 24
             * PAGINATION_NUMBER : 1
             * group :
             * status : 0
             */

            private String DCCM_ID;
            private String DCCM_STATUS;
            private String nickname;
            private String U_NICKNAME;
            private String DCCM_GROUP;
            private String U_ID;
            private String userId;
            private String PAGINATION_NUMBER;
            private String group;
            private String status;

            public String getDCCM_ID() {
                return DCCM_ID;
            }

            public void setDCCM_ID(String DCCM_ID) {
                this.DCCM_ID = DCCM_ID;
            }

            public String getDCCM_STATUS() {
                return DCCM_STATUS;
            }

            public void setDCCM_STATUS(String DCCM_STATUS) {
                this.DCCM_STATUS = DCCM_STATUS;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getU_NICKNAME() {
                return U_NICKNAME;
            }

            public void setU_NICKNAME(String U_NICKNAME) {
                this.U_NICKNAME = U_NICKNAME;
            }

            public String getDCCM_GROUP() {
                return DCCM_GROUP;
            }

            public void setDCCM_GROUP(String DCCM_GROUP) {
                this.DCCM_GROUP = DCCM_GROUP;
            }

            public String getU_ID() {
                return U_ID;
            }

            public void setU_ID(String U_ID) {
                this.U_ID = U_ID;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getPAGINATION_NUMBER() {
                return PAGINATION_NUMBER;
            }

            public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
                this.PAGINATION_NUMBER = PAGINATION_NUMBER;
            }

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
