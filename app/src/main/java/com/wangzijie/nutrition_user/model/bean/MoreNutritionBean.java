package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 营养师列表bean对象
 */
public class MoreNutritionBean extends BaseBean implements Serializable {

    /**
     * dietList : [{"DC_ID":"12","nickname":"","U_AVATAR":"http://localhost:8081/api/defaultavatarlogo.png","id":"12","avatar":"http://localhost:8081/api/defaultavatarlogo.png","U_NICKNAME":"","U_ID":"45","PAGINATION_NUMBER":"1"}]
     * nextPage : true
     */

    private boolean nextPage;
    private List<DietListBean> dietList;

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public List<DietListBean> getDietList() {
        return dietList;
    }

    public void setDietList(List<DietListBean> dietList) {
        this.dietList = dietList;
    }

    public static class DietListBean implements Serializable{
        /**
         * DC_ID : 12
         * nickname :
         * U_AVATAR : http://localhost:8081/api/defaultavatarlogo.png
         * id : 12
         * avatar : http://localhost:8081/api/defaultavatarlogo.png
         * U_NICKNAME :
         * U_ID : 45
         * PAGINATION_NUMBER : 1
         */

        private String DC_ID;
        private String nickname;
        private String U_AVATAR;
        private String hxAccount;
        private String id;
        private String avatar;
        private String U_NICKNAME;

        private String U_ID;
        private String PAGINATION_NUMBER;
        private String price;

        public String getHxAccount() {
            return hxAccount;
        }

        public void setHxAccount(String hxAccount) {
            this.hxAccount = hxAccount;
        }

        public String getDC_ID() {
            return DC_ID;
        }

        public void setDC_ID(String DC_ID) {
            this.DC_ID = DC_ID;
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

        public String getU_ID() {
            return U_ID;
        }

        public void setU_ID(String U_ID) {
            this.U_ID = U_ID;
        }

        public String getPAGINATION_NUMBER() {
            return PAGINATION_NUMBER;
        }

        public void setPAGINATION_NUMBER(String PAGINATION_NUMBER) {
            this.PAGINATION_NUMBER = PAGINATION_NUMBER;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
