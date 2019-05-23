package com.wangzijie.nutrition_user.model.bean;

import com.google.gson.annotations.SerializedName;

public class AliplayBean {

    /**
     * code : 0
     * msg : success
     * data : {"appId":"wx61cd0cb45a23724e","partnerid":"1517552341","prepayid":"wx031746369011310bbe5725b32333449132","package":"Sign=WXPay","noncestr":"k0u1frh8yl","timestamp":"1554284792","sign":"647C79BB584AB6005EF7B7493730CC4A"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appId : wx61cd0cb45a23724e
         * partnerid : 1517552341
         * prepayid : wx031746369011310bbe5725b32333449132
         * package : Sign=WXPay
         * noncestr : k0u1frh8yl
         * timestamp : 1554284792
         * sign : 647C79BB584AB6005EF7B7493730CC4A
         */

        private String appId;
        private String partnerid;
        private String prepayid;
        @SerializedName("package")
        private String packageX;
        private String noncestr;
        private String timestamp;
        private String sign;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
