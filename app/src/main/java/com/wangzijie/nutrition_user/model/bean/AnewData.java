package com.wangzijie.nutrition_user.model.bean;

public class AnewData {

    /**
     * data : {"errorCode":0,"masg":"Success","data":"15831361620"}
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
         * data : 15831361620
         */

        private int errorCode;
        private String masg;
        private String data;

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

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
