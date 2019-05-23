package com.wangzijie.nutrition_user.model.bean;

public class ExperData {
    private String matter;
    private String collectnumber;
    private String transmitnumber;
    private int foodimage;

    public ExperData(String matter, String collectnumber, String transmitnumber, int foodimage) {
        this.matter = matter;
        this.collectnumber = collectnumber;
        this.transmitnumber = transmitnumber;
        this.foodimage = foodimage;
    }

    public ExperData() {
        super();
    }

    @Override
    public String toString() {
        return "ExperData{" +
                "matter='" + matter + '\'' +
                ", collectnumber=" + collectnumber +
                ", transmitnumber=" + transmitnumber +
                ", foodimage=" + foodimage +
                '}';
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getCollectnumber() {
        return collectnumber;
    }

    public void setCollectnumber(String collectnumber) {
        this.collectnumber = collectnumber;
    }

    public String getTransmitnumber() {
        return transmitnumber;
    }

    public void setTransmitnumber(String transmitnumber) {
        this.transmitnumber = transmitnumber;
    }

    public int getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }
}
