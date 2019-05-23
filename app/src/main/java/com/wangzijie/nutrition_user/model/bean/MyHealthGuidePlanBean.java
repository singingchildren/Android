package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * 健康指导方案
 */
public class MyHealthGuidePlanBean {

    /**
     * data : {"errorCode":0,"masg":"Success","data":{"diet":[{"id":1,"timeStr":"2019.3.12-2019.3.21","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":2,"timeStr":"2019.3.1-2019.3.11","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":3,"timeStr":"2019.2.12-2019.2.28","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69}],"nextPage":true}}
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
         * data : {"diet":[{"id":1,"timeStr":"2019.3.12-2019.3.21","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":2,"timeStr":"2019.3.1-2019.3.11","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":3,"timeStr":"2019.2.12-2019.2.28","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69}],"nextPage":true}
         */

        private int errorCode;
        private String masg;
        private DataBean data;

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

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * diet : [{"id":1,"timeStr":"2019.3.12-2019.3.21","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":2,"timeStr":"2019.3.1-2019.3.11","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69},{"id":3,"timeStr":"2019.2.12-2019.2.28","type1":1233,"type2":456,"type3":2,"type4":49,"type5":0,"type6":2019,"type7":33,"type8":55,"type9":0,"type10":69}]
             * nextPage : true
             */

            private boolean nextPage;
            private List<DietBean> diet;

            public boolean isNextPage() {
                return nextPage;
            }

            public void setNextPage(boolean nextPage) {
                this.nextPage = nextPage;
            }

            public List<DietBean> getDiet() {
                return diet;
            }

            public void setDiet(List<DietBean> diet) {
                this.diet = diet;
            }

            public static class DietBean {
                /**
                 * id : 1
                 * timeStr : 2019.3.12-2019.3.21
                 * type1 : 1233
                 * type2 : 456
                 * type3 : 2
                 * type4 : 49
                 * type5 : 0
                 * type6 : 2019
                 * type7 : 33
                 * type8 : 55
                 * type9 : 0
                 * type10 : 69
                 */

                private int id;
                private String timeStr;
                private int type1;
                private int type2;
                private int type3;
                private int type4;
                private int type5;
                private int type6;
                private int type7;
                private int type8;
                private int type9;
                private int type10;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTimeStr() {
                    return timeStr;
                }

                public void setTimeStr(String timeStr) {
                    this.timeStr = timeStr;
                }

                public int getType1() {
                    return type1;
                }

                public void setType1(int type1) {
                    this.type1 = type1;
                }

                public int getType2() {
                    return type2;
                }

                public void setType2(int type2) {
                    this.type2 = type2;
                }

                public int getType3() {
                    return type3;
                }

                public void setType3(int type3) {
                    this.type3 = type3;
                }

                public int getType4() {
                    return type4;
                }

                public void setType4(int type4) {
                    this.type4 = type4;
                }

                public int getType5() {
                    return type5;
                }

                public void setType5(int type5) {
                    this.type5 = type5;
                }

                public int getType6() {
                    return type6;
                }

                public void setType6(int type6) {
                    this.type6 = type6;
                }

                public int getType7() {
                    return type7;
                }

                public void setType7(int type7) {
                    this.type7 = type7;
                }

                public int getType8() {
                    return type8;
                }

                public void setType8(int type8) {
                    this.type8 = type8;
                }

                public int getType9() {
                    return type9;
                }

                public void setType9(int type9) {
                    this.type9 = type9;
                }

                public int getType10() {
                    return type10;
                }

                public void setType10(int type10) {
                    this.type10 = type10;
                }
            }
        }
    }
}
