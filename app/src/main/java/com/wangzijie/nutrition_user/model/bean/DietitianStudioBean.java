package com.wangzijie.nutrition_user.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DietitianStudioBean {
    /**
     * data : {"SP_LICENSE":"11233","private":true,"SP_PERSON":"Tom","SP_FILEURL0":"","SP_ASTATUS":"0","SP_ID":"2","SP_STATUS":"1","SP_CODE":"9201021212","SP_ADDRESS":"Shanghai","SP_CREATETIME":"","SP_LOGOURL":"","id":"2","SP_NAME":"STD-02","SP_DESC":"My Studio 2","descr":"My Studio 2","U_PHONE":"12386868686","phone":"12386868686","dietList":[{"dcId":null,"SPDC_DCID":"28","nickname":null,"U_AVATAR":"http://101.201.209.158/api/defaultavatarlogo.png","id":null,"avatar":"http://101.201.209.158/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"66"},{"dcId":null,"SPDC_DCID":"29","nickname":null,"U_AVATAR":"http://101.201.209.158/api/defaultavatarlogo.png","id":null,"avatar":"http://101.201.209.158/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"67"}],"SP_FILEURL5":"","name":"STD-02","SP_FILEURL6":"","SP_AGREECOUNT":"0","location":"Shanghai","SP_FILEURL1":"","SP_FILEURL2":"","SP_FILEURL3":"","SP_FILEURL4":"","SP_DCID":"6"}
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
         * SP_LICENSE : 11233
         * private : true
         * SP_PERSON : Tom
         * SP_FILEURL0 :
         * SP_ASTATUS : 0
         * SP_ID : 2
         * SP_STATUS : 1
         * SP_CODE : 9201021212
         * SP_ADDRESS : Shanghai
         * SP_CREATETIME :
         * SP_LOGOURL :
         * id : 2
         * SP_NAME : STD-02
         * SP_DESC : My Studio 2
         * descr : My Studio 2
         * U_PHONE : 12386868686
         * phone : 12386868686
         * dietList : [{"dcId":null,"SPDC_DCID":"28","nickname":null,"U_AVATAR":"http://101.201.209.158/api/defaultavatarlogo.png","id":null,"avatar":"http://101.201.209.158/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"66"},{"dcId":null,"SPDC_DCID":"29","nickname":null,"U_AVATAR":"http://101.201.209.158/api/defaultavatarlogo.png","id":null,"avatar":"http://101.201.209.158/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"67"}]
         * SP_FILEURL5 :
         * name : STD-02
         * SP_FILEURL6 :
         * SP_AGREECOUNT : 0
         * location : Shanghai
         * SP_FILEURL1 :
         * SP_FILEURL2 :
         * SP_FILEURL3 :
         * SP_FILEURL4 :
         * SP_DCID : 6
         */

        private String SP_LICENSE;
        @SerializedName("private")
        private boolean privateX;
        private String SP_PERSON;
        private String SP_FILEURL0;
        private String SP_ASTATUS;
        private String SP_ID;
        private String SP_STATUS;
        private String SP_CODE;
        private String SP_ADDRESS;
        private String SP_CREATETIME;
        private String SP_LOGOURL;
        private String id;
        private String SP_NAME;
        private String SP_DESC;
        private String descr;
        private String U_PHONE;
        private String phone;
        private String SP_FILEURL5;
        private String name;
        private String SP_FILEURL6;
        private String SP_AGREECOUNT;
        private String location;
        private String SP_FILEURL1;
        private String SP_FILEURL2;
        private String SP_FILEURL3;
        private String SP_FILEURL4;
        private String SP_DCID;
        private List<DietListBean> dietList;

        public String getSP_LICENSE() {
            return SP_LICENSE;
        }

        public void setSP_LICENSE(String SP_LICENSE) {
            this.SP_LICENSE = SP_LICENSE;
        }

        public boolean isPrivateX() {
            return privateX;
        }

        public void setPrivateX(boolean privateX) {
            this.privateX = privateX;
        }

        public String getSP_PERSON() {
            return SP_PERSON;
        }

        public void setSP_PERSON(String SP_PERSON) {
            this.SP_PERSON = SP_PERSON;
        }

        public String getSP_FILEURL0() {
            return SP_FILEURL0;
        }

        public void setSP_FILEURL0(String SP_FILEURL0) {
            this.SP_FILEURL0 = SP_FILEURL0;
        }

        public String getSP_ASTATUS() {
            return SP_ASTATUS;
        }

        public void setSP_ASTATUS(String SP_ASTATUS) {
            this.SP_ASTATUS = SP_ASTATUS;
        }

        public String getSP_ID() {
            return SP_ID;
        }

        public void setSP_ID(String SP_ID) {
            this.SP_ID = SP_ID;
        }

        public String getSP_STATUS() {
            return SP_STATUS;
        }

        public void setSP_STATUS(String SP_STATUS) {
            this.SP_STATUS = SP_STATUS;
        }

        public String getSP_CODE() {
            return SP_CODE;
        }

        public void setSP_CODE(String SP_CODE) {
            this.SP_CODE = SP_CODE;
        }

        public String getSP_ADDRESS() {
            return SP_ADDRESS;
        }

        public void setSP_ADDRESS(String SP_ADDRESS) {
            this.SP_ADDRESS = SP_ADDRESS;
        }

        public String getSP_CREATETIME() {
            return SP_CREATETIME;
        }

        public void setSP_CREATETIME(String SP_CREATETIME) {
            this.SP_CREATETIME = SP_CREATETIME;
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

        public String getSP_NAME() {
            return SP_NAME;
        }

        public void setSP_NAME(String SP_NAME) {
            this.SP_NAME = SP_NAME;
        }

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

        public String getU_PHONE() {
            return U_PHONE;
        }

        public void setU_PHONE(String U_PHONE) {
            this.U_PHONE = U_PHONE;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSP_FILEURL5() {
            return SP_FILEURL5;
        }

        public void setSP_FILEURL5(String SP_FILEURL5) {
            this.SP_FILEURL5 = SP_FILEURL5;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSP_FILEURL6() {
            return SP_FILEURL6;
        }

        public void setSP_FILEURL6(String SP_FILEURL6) {
            this.SP_FILEURL6 = SP_FILEURL6;
        }

        public String getSP_AGREECOUNT() {
            return SP_AGREECOUNT;
        }

        public void setSP_AGREECOUNT(String SP_AGREECOUNT) {
            this.SP_AGREECOUNT = SP_AGREECOUNT;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSP_FILEURL1() {
            return SP_FILEURL1;
        }

        public void setSP_FILEURL1(String SP_FILEURL1) {
            this.SP_FILEURL1 = SP_FILEURL1;
        }

        public String getSP_FILEURL2() {
            return SP_FILEURL2;
        }

        public void setSP_FILEURL2(String SP_FILEURL2) {
            this.SP_FILEURL2 = SP_FILEURL2;
        }

        public String getSP_FILEURL3() {
            return SP_FILEURL3;
        }

        public void setSP_FILEURL3(String SP_FILEURL3) {
            this.SP_FILEURL3 = SP_FILEURL3;
        }

        public String getSP_FILEURL4() {
            return SP_FILEURL4;
        }

        public void setSP_FILEURL4(String SP_FILEURL4) {
            this.SP_FILEURL4 = SP_FILEURL4;
        }

        public String getSP_DCID() {
            return SP_DCID;
        }

        public void setSP_DCID(String SP_DCID) {
            this.SP_DCID = SP_DCID;
        }

        public List<DietListBean> getDietList() {
            return dietList;
        }

        public void setDietList(List<DietListBean> dietList) {
            this.dietList = dietList;
        }

        public static class DietListBean {
            /**
             * dcId : null
             * SPDC_DCID : 28
             * nickname : null
             * U_AVATAR : http://101.201.209.158/api/defaultavatarlogo.png
             * id : null
             * avatar : http://101.201.209.158/api/defaultavatarlogo.png
             * U_NICKNAME :
             * U_ID : 66
             */

            public String dcId;
            public String SPDC_DCID;
            public String nickname;
            public String U_AVATAR;
            public String id;
            public String avatar;
            public String U_NICKNAME;
            public String U_ID;


        }
    }

    /*
    id工作室ID
    name工作室名称，
    phone营养师电话，
    location工作室地址，
    descr工作室介绍，
    dietList:[{id，dcId, nickname, avatar}   营养师列表

    */





}
