package com.wangzijie.nutrition_user.utils;

public class SchemeFood {
    private String name;
    private int image;

    @Override
    public String toString() {
        return "SchemeFood{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }

    public SchemeFood() {
        super();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public SchemeFood(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
