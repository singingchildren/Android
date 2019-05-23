package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class DieticianDetailsData extends BaseBean{

    /**
     * data : {"cases":[null,null,null],"certificates":[null,null,null,null],"introduce":{"field":"","service":"缓解通风","content":""},"label":[{"tag":"xxx"},{"tag":"yyy"}],"userinfo":{"descr":"","dcId":"5","service":null,"price":"500","nickname":"","location":"北京市","id":"33","avatar":"http://localhost:8081/api/defaultavatarlogo.png","hxAccount":"xcvxHHpdaa","realname":"王泽全"}}
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
         * cases : [null,null,null]
         * certificates : [null,null,null,null]
         * introduce : {"field":"","service":"缓解通风","content":""}
         * label : [{"tag":"xxx"},{"tag":"yyy"}]
         * userinfo : {"descr":"","dcId":"5","service":null,"price":"500","nickname":"","location":"北京市","id":"33","avatar":"http://localhost:8081/api/defaultavatarlogo.png","hxAccount":"xcvxHHpdaa","realname":"王泽全"}
         */

        private IntroduceBean introduce;
        private UserinfoBean userinfo;
        private List<String> cases;
        private List<String> certificates;
        private List<LabelBean> label;

        public IntroduceBean getIntroduce() {
            return introduce;
        }

        public void setIntroduce(IntroduceBean introduce) {
            this.introduce = introduce;
        }

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public List<String> getCases() {
            return cases;
        }

        public void setCases(List<String> cases) {
            this.cases = cases;
        }

        public List<String> getCertificates() {
            return certificates;
        }

        public void setCertificates(List<String> certificates) {
            this.certificates = certificates;
        }

        public List<LabelBean> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBean> label) {
            this.label = label;
        }

        public static class IntroduceBean {
            /**
             * field :
             * service : 缓解通风
             * content :
             */

            private String field;
            private String service;
            private String content;

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getService() {
                return service;
            }

            public void setService(String service) {
                this.service = service;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class UserinfoBean {
            /**
             * descr :
             * dcId : 5
             * service : null
             * price : 500
             * nickname :
             * location : 北京市
             * id : 33
             * avatar : http://localhost:8081/api/defaultavatarlogo.png
             * hxAccount : xcvxHHpdaa
             * realname : 王泽全
             */

            private String descr;
            private String dcId;
            private String service;
            private String price;
            private String nickname;
            private String location;
            private String id;
            private String avatar;
            private String loginId;
            private String hxAccount;
            private String realname;
            public String content;

            public String getDescr() {
                return descr;
            }



            public void setDescr(String descr) {
                this.descr = descr;
            }

            public String getLoginId() {
                return loginId;
            }

            public void setLoginId(String loginId) {
                this.loginId = loginId;
            }

            public String getDcId() {
                return dcId;
            }

            public void setDcId(String dcId) {
                this.dcId = dcId;
            }

            public String getService() {
                return service;
            }

            public void setService(String service) {
                this.service = service;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getHxAccount() {
                return hxAccount;
            }

            public void setHxAccount(String hxAccount) {
                this.hxAccount = hxAccount;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }
        }

        public static class LabelBean {
            /**
             * tag : xxx
             */

            private String tag;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }
    }
}
