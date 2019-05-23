package com.wangzijie.nutrition_user.model.bean;

public class LoginData extends BaseBean {


    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzMyIsInBhc3N3b3JkIjoiZTQxYjA1OWI1OGVlOGFlNGRjODljNzMwZTgxZDAxMGUiLCJhcHBpZCI6IjAwMDAwMDAwLTdjZTQtYTlkMC1mZmZmLWZmZmZlZjA1YWM0YSIsImxvZ2lkIjozMywiaWQiOjMzLCJleHAiOjE1ODA0NzkxODgsImlhdCI6MTU1NzU4MzE4OCwianRpIjoiMmViOWE1ZGUtNTJkNS00MmQzLTgyZTQtYmNlZDhkODZmZDJlIiwidXNlcm5hbWUiOiLnjovms73lhagifQ.icZMTePEGzm9wt-HwyriVMbFrmVu02yojJKcae2NPPw","type":"dietician","areaId":"110100","areaName":"北京市","hxLogId":"xcvxHHpdaa","hxPwd":"9a2ed6fd50d494ca14c58eff5a7b0db1"}
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
         * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzMyIsInBhc3N3b3JkIjoiZTQxYjA1OWI1OGVlOGFlNGRjODljNzMwZTgxZDAxMGUiLCJhcHBpZCI6IjAwMDAwMDAwLTdjZTQtYTlkMC1mZmZmLWZmZmZlZjA1YWM0YSIsImxvZ2lkIjozMywiaWQiOjMzLCJleHAiOjE1ODA0NzkxODgsImlhdCI6MTU1NzU4MzE4OCwianRpIjoiMmViOWE1ZGUtNTJkNS00MmQzLTgyZTQtYmNlZDhkODZmZDJlIiwidXNlcm5hbWUiOiLnjovms73lhagifQ.icZMTePEGzm9wt-HwyriVMbFrmVu02yojJKcae2NPPw
         * type : dietician
         * areaId : 110100
         * areaName : 北京市
         * hxLogId : xcvxHHpdaa
         * hxPwd : 9a2ed6fd50d494ca14c58eff5a7b0db1
         */

        private String token;
        private String type;
        private String areaId;
        private String areaName;
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
