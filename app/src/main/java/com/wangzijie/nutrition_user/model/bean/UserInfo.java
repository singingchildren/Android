package com.wangzijie.nutrition_user.model.bean;

public class UserInfo extends BaseBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        //vip到期时间
        private String yearCertTime;//年费会员到期时间
        private String cusCertTime;//定制化会员到期时间
        private String dcAuthCertTime;//营养师认证过期时间
        private String dcAuthPrice;//营养师认证价格
        private String dcAuthStatus;//认证标记
        private String loginId;//账号
        private String age;//年龄
        private String avatar;//头像
        private String blog_count;//博客数
        private String descr;//个签
        private String fans_count;//粉丝数
        private String follow_count;//收藏数
        private String gender;//性别
        private String height;//身高
        private String weight;//体重
        private String nickname;//昵称
        private String realname;//实名

        private String code = "获取失败";//我的邀请码

        private int certified;//是否认证



        public DataBean() {

        }


        public String getDcAuthStatus() {
            return dcAuthStatus;
        }

        public void setDcAuthStatus(String dcAuthStatus) {
            this.dcAuthStatus = dcAuthStatus;
        }

        public String getYearCertTime() {
            return yearCertTime;
        }

        public void setYearCertTime(String yearCertTime) {
            this.yearCertTime = yearCertTime;
        }

        public String getCusCertTime() {
            return cusCertTime;
        }

        public void setCusCertTime(String cusCertTime) {
            this.cusCertTime = cusCertTime;
        }

        public String getDcAuthCertTime() {
            return dcAuthCertTime;
        }

        public void setDcAuthCertTime(String dcAuthCertTime) {
            this.dcAuthCertTime = dcAuthCertTime;
        }

        public String getDcAuthPrice() {
            return dcAuthPrice;
        }

        public void setDcAuthPrice(String dcAuthPrice) {
            this.dcAuthPrice = dcAuthPrice;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDescr() {
            return descr;
        }

        public void setDescr(String descr) {
            this.descr = descr;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }



        public int getCertified() {
            return certified;
        }

        public void setCertified(int certified) {
            this.certified = certified;
        }




        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBlog_count() {
            return blog_count;
        }

        public void setBlog_count(String blog_count) {
            this.blog_count = blog_count;
        }

        public String getFans_count() {
            return fans_count;
        }

        public void setFans_count(String fans_count) {
            this.fans_count = fans_count;
        }

        public String getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(String follow_count) {
            this.follow_count = follow_count;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

}
