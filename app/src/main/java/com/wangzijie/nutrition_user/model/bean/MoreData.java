package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;
import java.util.List;

public class MoreData extends BaseBean implements Serializable {

    /**
     * data : {"errorCode":0,"masg":"Success","data":[{"id":1,"nickname":"张小红","descr":"天气真好","avatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg","serverList":[{"id":1,"projects":"痛风","price":100,"days":30},{"id":2,"projects":"高血压","price":150,"days":90},{"id":3,"projects":"肥胖","price":1500,"days":365}]},{"id":2,"nickname":"张小红","descr":"天气真好","avatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg","serverList":[{"id":1,"projects":"痛风","price":100,"days":30},{"id":2,"projects":"高血压","price":150,"days":90},{"id":3,"projects":"肥胖","price":1500,"days":365}]}],"nextPage":true}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX implements Serializable{
        /**
         * errorCode : 0
         * masg : Success
         * data : [{"id":1,"nickname":"张小红","descr":"天气真好","avatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg","serverList":[{"id":1,"projects":"痛风","price":100,"days":30},{"id":2,"projects":"高血压","price":150,"days":90},{"id":3,"projects":"肥胖","price":1500,"days":365}]},{"id":2,"nickname":"张小红","descr":"天气真好","avatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg","serverList":[{"id":1,"projects":"痛风","price":100,"days":30},{"id":2,"projects":"高血压","price":150,"days":90},{"id":3,"projects":"肥胖","price":1500,"days":365}]}]
         * nextPage : true
         */

        private int errorCode;
        private String masg;
        private boolean nextPage;
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

        public boolean isNextPage() {
            return nextPage;
        }

        public void setNextPage(boolean nextPage) {
            this.nextPage = nextPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable{
            /**
             * id : 1
             * nickname : 张小红
             * descr : 天气真好
             * avatar : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg
             * serverList : [{"id":1,"projects":"痛风","price":100,"days":30},{"id":2,"projects":"高血压","price":150,"days":90},{"id":3,"projects":"肥胖","price":1500,"days":365}]
             */

            private int id;
            private String nickname;
            private String descr;
            private String avatar;
            private List<ServerListBean> serverList;

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

            public String getDescr() {
                return descr;
            }

            public void setDescr(String descr) {
                this.descr = descr;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public List<ServerListBean> getServerList() {
                return serverList;
            }

            public void setServerList(List<ServerListBean> serverList) {
                this.serverList = serverList;
            }

            public static class ServerListBean {
                /**
                 * id : 1
                 * projects : 痛风
                 * price : 100
                 * days : 30
                 */

                private int id;
                private String projects;
                private int price;
                private int days;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProjects() {
                    return projects;
                }

                public void setProjects(String projects) {
                    this.projects = projects;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public int getDays() {
                    return days;
                }

                public void setDays(int days) {
                    this.days = days;
                }
            }



        }
    }
}
