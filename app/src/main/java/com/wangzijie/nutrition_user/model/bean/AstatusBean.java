package com.wangzijie.nutrition_user.model.bean;

/**
 * @author WangZequan
 * @time 2019/5/9 13:54
 * @describe
 */
public class AstatusBean extends BaseBean{

    /**
     * data : {"aStatus":0}
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
         * aStatus : 0
         */

        private int aStatus;

        public int getAStatus() {
            return aStatus;
        }

        public void setAStatus(int aStatus) {
            this.aStatus = aStatus;
        }
    }
}
