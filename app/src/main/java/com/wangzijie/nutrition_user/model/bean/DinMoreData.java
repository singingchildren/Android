package com.wangzijie.nutrition_user.model.bean;

public class DinMoreData {

    private String name;
    private String Avatar;
    private String Descr;
    private int id;

    public DinMoreData() {
        super();
    }

    @Override
    public String toString() {
        return "DinMoreData{" +
                "name='" + name + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", Descr='" + Descr + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DinMoreData(String name, String avatar, String descr, int id) {
        this.name = name;
        Avatar = avatar;
        Descr = descr;
        this.id = id;
    }
}
