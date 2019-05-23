package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class News {
    public boolean has_image;
    public List image_list;
    public int gallary_image_count;
    private String title;
    private String source;
    private String comment_count;
    private int behot_time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public List getImage_list() {
        return image_list;
    }

    public void setImage_list(List image_list) {
        this.image_list = image_list;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;


    }

    public void setMiddle_image(ImageEntity imageEntity) {
    }
}
