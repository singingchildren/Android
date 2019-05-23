package com.wangzijie.nutrition_user.model.bean;

public class ReportBean extends BaseBean{

    /**
     * data : {"psychology":0,"diet":0,"sleep":0,"sport":0,"rate":3}
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
         * psychology : 0
         * diet : 0
         * sleep : 0
         * sport : 0
         * rate : 3
         */

        private String psychology;
        private String diet;
        private String sleep;
        private String sport;
        private int rate;

        public String getPsychology() {
            return psychology;
        }

        public void setPsychology(String psychology) {
            this.psychology = psychology;
        }

        public String getDiet() {
            return diet;
        }

        public void setDiet(String diet) {
            this.diet = diet;
        }

        public String getSleep() {
            return sleep;
        }

        public void setSleep(String sleep) {
            this.sleep = sleep;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }
    }
}
