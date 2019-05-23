package com.wangzijie.nutrition_user.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author fanjiangpeng
 * 健康咨询
 */
public class RecommendBean {
    /**
     * id : 1
     * img_url :
     * abstract : 健康资讯1
     * pageviews : 234
     * private_count : 123
     * content_id : 1
     */

    private int id;
    private String img_url;
    @SerializedName("abstract")
    private String abstractX;
    private int pageviews;
    private int private_count;
    private int content_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }

    public int getPrivate_count() {
        return private_count;
    }

    public void setPrivate_count(int private_count) {
        this.private_count = private_count;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }
}
