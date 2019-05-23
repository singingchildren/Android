package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;

public class DietAssessmentBean extends BaseBean implements Serializable {

    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * type1 : 不合理
         * type2 : 合理
         * type3 : 不合理
         * type4 : 合理
         * type5 : 合理
         * type6 : 不合理
         * type7 : 合理
         * type8 : 合理
         * type9 : 不合理
         * type10 : 合理
         */

        private String type1;
        private String type2;
        private String type3;
        private String type4;
        private String type5;
        private String type6;
        private String type7;
        private String type8;
        private String type9;
        private String type10;

        public String getType1() {
            return type1;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public String getType2() {
            return type2;
        }

        public void setType2(String type2) {
            this.type2 = type2;
        }

        public String getType3() {
            return type3;
        }

        public void setType3(String type3) {
            this.type3 = type3;
        }

        public String getType4() {
            return type4;
        }

        public void setType4(String type4) {
            this.type4 = type4;
        }

        public String getType5() {
            return type5;
        }

        public void setType5(String type5) {
            this.type5 = type5;
        }

        public String getType6() {
            return type6;
        }

        public void setType6(String type6) {
            this.type6 = type6;
        }

        public String getType7() {
            return type7;
        }

        public void setType7(String type7) {
            this.type7 = type7;
        }

        public String getType8() {
            return type8;
        }

        public void setType8(String type8) {
            this.type8 = type8;
        }

        public String getType9() {
            return type9;
        }

        public void setType9(String type9) {
            this.type9 = type9;
        }

        public String getType10() {
            return type10;
        }

        public void setType10(String type10) {
            this.type10 = type10;
        }
    }
}
