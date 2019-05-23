package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * 我的营养师列表bean对象
 */
public class MyDietitianBean extends BaseBean{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * DC_ADDRESS : 北京市
         * avatar : http://localhost:8081/api/defaultavatarlogo.png
         * label : [{"id":"1","tag":"慢病"}]
         * DCCM_DCID : 5
         * realname : 王泽全
         * descr :
         * nickname :
         * U_AVATAR : http://localhost:8081/api/defaultavatarlogo.png
         * location : 北京市
         * id : 5
         * U_NICKNAME :
         * U_DESC :
         * U_NAME : 王泽全
         */

        private String DC_ADDRESS;
        private String avatar;
        private String DCCM_DCID;
        private String realname;
        private String descr;
        private String nickname;
        private String U_AVATAR;
        private String location;
        private String account;
        private String hxAccount;
        private String id;
        private String U_NICKNAME;
        private String U_DESC;
        private String U_NAME;

        public String getHxAccount() {
            return hxAccount;
        }

        public void setHxAccount(String hxAccount) {
            this.hxAccount = hxAccount;
        }

        private List<LabelBean> label;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getDC_ADDRESS() {
            return DC_ADDRESS;
        }

        public void setDC_ADDRESS(String DC_ADDRESS) {
            this.DC_ADDRESS = DC_ADDRESS;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDCCM_DCID() {
            return DCCM_DCID;
        }

        public void setDCCM_DCID(String DCCM_DCID) {
            this.DCCM_DCID = DCCM_DCID;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getDescr() {
            return descr;
        }

        public void setDescr(String descr) {
            this.descr = descr;
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getU_NICKNAME() {
            return U_NICKNAME;
        }

        public void setU_NICKNAME(String U_NICKNAME) {
            this.U_NICKNAME = U_NICKNAME;
        }

        public String getU_DESC() {
            return U_DESC;
        }

        public void setU_DESC(String U_DESC) {
            this.U_DESC = U_DESC;
        }

        public String getU_NAME() {
            return U_NAME;
        }

        public void setU_NAME(String U_NAME) {
            this.U_NAME = U_NAME;
        }

        public List<LabelBean> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBean> label) {
            this.label = label;
        }

        public static class LabelBean {
            /**
             * id : 1
             * tag : 慢病
             */

            private String id;
            private String tag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }
    }
}
