package com.wangzijie.nutrition_user.model.bean;

public class MyDingData {
    private String number;
    private String content;
    private String[] labels;

    public MyDingData() {
        super();
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public MyDingData(String number, String content, String[] labels) {
        this.number = number;
        this.content = content;
        this.labels = labels;
    }
}
