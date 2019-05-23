package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class StopData extends BaseBean{
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * logoImg : https://jzjsclub.oss-cn-beijing.aliyuncs.com/SportAssessMenu/run.jpg
         * id : 1
         * title : 慢跑
         * energyNum : 300
         */

        private String logoImg;
        private String id;
        private String title;
        private int energyNum;

        public String getLogoImg() {
            return logoImg;
        }

        public void setLogoImg(String logoImg) {
            this.logoImg = logoImg;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getEnergyNum() {
            return energyNum;
        }

        public void setEnergyNum(int energyNum) {
            this.energyNum = energyNum;
        }

        private int sumNum;

        public int getSumNum() {
            return sumNum;
        }

        public void setSumNum(int sumNum) {
            this.sumNum = sumNum;
        }
    }


//    /**
//     * data : [{"logoImg":"https://jzjsclub.oss-cn-beijing.aliyuncs.com/SportAssessMenu/run.jpg","id":"1","title":"慢跑","energyNum":300},{"logoImg":"https://jzjsclub.oss-cn-beijing.aliyuncs.com/SportAssessMenu/jump.jpg","id":"2","title":"跳绳","energyNum":400}]
//     * success : true
//     */
//
//    private boolean success;
//    private List<DataBean> data;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * logoImg : https://jzjsclub.oss-cn-beijing.aliyuncs.com/SportAssessMenu/run.jpg
//         * id : 1
//         * title : 慢跑
//         * energyNum : 300
//         */
//
//        private String logoImg;
//        private String id;
//        private String title;
//        private int energyNum;
//        private int sumNum;
//
//        public int getSumNum() {
//            return sumNum;
//        }
//
//        public void setSumNum(int sumNum) {
//            this.sumNum = sumNum;
//        }
//
//        public String getLogoImg() {
//            return logoImg;
//        }
//
//        public void setLogoImg(String logoImg) {
//            this.logoImg = logoImg;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public int getEnergyNum() {
//            return energyNum;
//        }
//
//        public void setEnergyNum(int energyNum) {
//            this.energyNum = energyNum;
//        }
//    }
}

