package com.wangzijie.nutrition_user.model.bean;

public class NewPassData {

    /**
     * data : {"errorCode":0,"masg":"Success"}
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
         * errorCode : 0
         * masg : Success
         */

        private int errorCode;
        private String masg;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMasg() {
            return masg;
        }

        public void setMasg(String masg) {
            this.masg = masg;
        }
    }
}
