package com.wangzijie.nutrition_user.model.bean;

public class DieticianWriteBean {

    public String start_time;
    public String end_time;
    public FoodData diet;
    public String sleep;
    public String sport;
    public String psychology;
    public String cmId;

    public static class FoodData{
        public String type1;
        public String type2;
        public String type3;
        public String type4;
        public String type5;
        public String type6;
        public String type7;
        public String type8;
        public String type9;
        public String type10;
    }


}
