package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class ShipDietitianBean {

    /**
     * data : {"errorCode":0,"masg":"Success","data":[{"id":1,"nickname":"张三","avatar":"http://pic3.nipic.com/20090527/1242397_102231006_2.jpg"},{"id":2,"nickname":"李四","avatar":"http://pic3.nipic.com/20090527/1242397_102231006_2.jpg"}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * errorCode : 0
         * masg : Success
         * data : [{"id":1,"nickname":"张三","avatar":"http://pic3.nipic.com/20090527/1242397_102231006_2.jpg"},{"id":2,"nickname":"李四","avatar":"http://pic3.nipic.com/20090527/1242397_102231006_2.jpg"}]
         */

        private int errorCode;
        private String masg;
        private List<DataBean> data;

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

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * nickname : 张三
             * avatar : http://pic3.nipic.com/20090527/1242397_102231006_2.jpg
             */

            private int id;
            private String nickname;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
