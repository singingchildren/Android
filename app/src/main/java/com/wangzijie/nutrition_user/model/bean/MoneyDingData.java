package com.wangzijie.nutrition_user.model.bean;

public class MoneyDingData {
    private String name;

    @Override
    public String toString() {
        return "MoneyDingData{" +
                "name='" + name + '\'' +
                '}';
    }

    public MoneyDingData() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoneyDingData(String name) {
        this.name = name;
    }
}
