package com.wangzijie.nutrition_user.model.bean;

public class RegisterData extends  BaseBean{


    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxNCIsInBhc3N3b3JkIjoiNjk3MmNhYmZhMzA5ZTQ5ZWI1NDdjODFmYjg2YjkxY2EiLCJhcHBpZCI6IiIsImxvZ2lkIjoxNCwiaWQiOjE0LCJleHAiOjE1Nzk4ODA2NTEsImlhdCI6MTU1Njk4NDY1MSwianRpIjoiNGM0N2QyOTQtM2ZiNC00NmQwLWI0MDUtODY3ZDE2MzBkNWUxIiwidXNlcm5hbWUiOm51bGx9.YQxZkDOh-8Vb1DsdzdrdYz7wZ1gU1GAB6IehrhYtYlc","type":"customer","hxLogId":"umLlGRkobU","hxPwd":"7897bd88ecc9b7b4f7f531eb9617b290"}
     * success : true
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
         * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxNCIsInBhc3N3b3JkIjoiNjk3MmNhYmZhMzA5ZTQ5ZWI1NDdjODFmYjg2YjkxY2EiLCJhcHBpZCI6IiIsImxvZ2lkIjoxNCwiaWQiOjE0LCJleHAiOjE1Nzk4ODA2NTEsImlhdCI6MTU1Njk4NDY1MSwianRpIjoiNGM0N2QyOTQtM2ZiNC00NmQwLWI0MDUtODY3ZDE2MzBkNWUxIiwidXNlcm5hbWUiOm51bGx9.YQxZkDOh-8Vb1DsdzdrdYz7wZ1gU1GAB6IehrhYtYlc
         * type : customer
         * hxLogId : umLlGRkobU
         * hxPwd : 7897bd88ecc9b7b4f7f531eb9617b290
         */

        private String token;
        private String type;
        private String hxLogId;
        private String hxPwd;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHxLogId() {
            return hxLogId;
        }

        public void setHxLogId(String hxLogId) {
            this.hxLogId = hxLogId;
        }

        public String getHxPwd() {
            return hxPwd;
        }

        public void setHxPwd(String hxPwd) {
            this.hxPwd = hxPwd;
        }
    }
}
