package com.wangzijie.nutrition_user.model.bean;

/**
 * @author WangZequan
 * @time 2019/5/9 13:51
 * @describe
 */
public class HasStudioBean extends BaseBean {

    /**
     * data : {"hasStudio":false}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private boolean hasStudio;
        private String spCode;
        private String spId;
        private String spName;

        public String getSpId() {
            return spId;
        }

        public void setSpId(String spId) {
            this.spId = spId;
        }

        public String getSpName() {
            return spName;
        }

        public void setSpName(String spName) {
            this.spName = spName;
        }

        public String getSpCode() {
            return spCode;
        }

        public void setSpCode(String spCode) {
            this.spCode = spCode;
        }

        public boolean isHasStudio() {
            return hasStudio;
        }

        public void setHasStudio(boolean hasStudio) {
            this.hasStudio = hasStudio;
        }
    }
}
