package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class ServiceNeedBean extends BaseBean{


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 糖尿病
         * id : disease_chronic_01
         * DCLA_ID : 0
         * DI_NAME : 糖尿病
         * selected : false
         * DI_KEY : disease_chronic_01
         */

        private String name;
        private String id;
        private String DCLA_ID;
        private String DI_NAME;
        private boolean selected;
        private String DI_KEY;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDCLA_ID() {
            return DCLA_ID;
        }

        public void setDCLA_ID(String DCLA_ID) {
            this.DCLA_ID = DCLA_ID;
        }

        public String getDI_NAME() {
            return DI_NAME;
        }

        public void setDI_NAME(String DI_NAME) {
            this.DI_NAME = DI_NAME;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getDI_KEY() {
            return DI_KEY;
        }

        public void setDI_KEY(String DI_KEY) {
            this.DI_KEY = DI_KEY;
        }
    }
}
