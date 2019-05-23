package com.wangzijie.nutrition_user.model.bean;

public class ShopHeadData extends BaseBean{

    /**
     * data : {"SPDC_DCID":"28","nickname":"","U_AVATAR":"http://101.201.209.158/api/defaultavatarlogo.png","id":"28","avatar":"http://101.201.209.158/api/defaultavatarlogo.png","U_NICKNAME":""}
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
         * SPDC_DCID : 28
         * nickname :
         * U_AVATAR : http://101.201.209.158/api/defaultavatarlogo.png
         * id : 28
         * avatar : http://101.201.209.158/api/defaultavatarlogo.png
         * U_NICKNAME :
         */

        private String SPDC_DCID;
        private String nickname;
        private String U_AVATAR;
        private String id;
        private String avatar;
        private String U_NICKNAME;

        public String getSPDC_DCID() {
            return SPDC_DCID;
        }

        public void setSPDC_DCID(String SPDC_DCID) {
            this.SPDC_DCID = SPDC_DCID;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getU_AVATAR() {
            return U_AVATAR;
        }

        public void setU_AVATAR(String U_AVATAR) {
            this.U_AVATAR = U_AVATAR;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getU_NICKNAME() {
            return U_NICKNAME;
        }

        public void setU_NICKNAME(String U_NICKNAME) {
            this.U_NICKNAME = U_NICKNAME;
        }
    }
}
