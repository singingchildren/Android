package com.wangzijie.nutrition_user.model.bean;

/**
 * @author fanjiangpeng
 * 工作室数据
 */

public class HomeStudioBean {
    /**
     * id : 1
     * name : 昆明营养师工作室
     * logo : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553001912918&di=755cbdaec78b5de4288e5a463302a322&imgtype=0&src=http%3A%2F%2Fpic1.nipic.com%2F2008-08-14%2F2008814183939909_2.jpg
     * agree_count : 30
     */

    private int id;
    private String name;
    private String logo;
    private int agree_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getAgree_count() {
        return agree_count;
    }

    public void setAgree_count(int agree_count) {
        this.agree_count = agree_count;
    }
}
