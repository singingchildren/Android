package com.wangzijie.nutrition_user.model.bean;

public class SchemeData {
    private String name;
    private String content;

    @Override
    public String toString() {
        return "SchemeData{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public SchemeData() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SchemeData(String name) {
        this.name = name;
    }
}
