package com.wangzijie.nutrition_user.model.bean;

public class DingData {

    private String name;
    private String money;

    public DingData() {
        super();
    }

    @Override
    public String
    toString() {
        return "DingData{" +
                "name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public DingData(String name, String money) {
        this.name = name;
        this.money = money;
    }
}
