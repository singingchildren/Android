package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class HealthAssessmentBean extends BaseBean{


    /**
     * data : {"result":[{"num":"0","days":"0","id":"1"},{"num":"1380","days":"12","id":"2"},{"num":"660","days":"11","id":"3"},{"num":"300","days":"4","id":"4"}],"unit":200,"unitName":"/千卡","month":"5月/","secondNum":360,"thirdNum":-1980,"initValue":200,"firstNum":2340}
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
         * result : [{"num":"0","days":"0","id":"1"},{"num":"1380","days":"12","id":"2"},{"num":"660","days":"11","id":"3"},{"num":"300","days":"4","id":"4"}]
         * unit : 200
         * unitName : /千卡
         * month : 5月/
         * secondNum : 360
         * thirdNum : -1980
         * initValue : 200
         * firstNum : 2340
         */

        private int unit;
        private String unitName;
        private String month;
        private int secondNum;
        private int thirdNum;
        private int initValue;
        private int firstNum;
        private List<ResultBean> result;

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public int getSecondNum() {
            return secondNum;
        }

        public void setSecondNum(int secondNum) {
            this.secondNum = secondNum;
        }

        public int getThirdNum() {
            return thirdNum;
        }

        public void setThirdNum(int thirdNum) {
            this.thirdNum = thirdNum;
        }

        public int getInitValue() {
            return initValue;
        }

        public void setInitValue(int initValue) {
            this.initValue = initValue;
        }

        public int getFirstNum() {
            return firstNum;
        }

        public void setFirstNum(int firstNum) {
            this.firstNum = firstNum;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * num : 0
             * days : 0
             * id : 1
             */

            private int num;
            private int days;
            private String id;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getDays() {
                return days;
            }

            public void setDays(int days) {
                this.days = days;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
