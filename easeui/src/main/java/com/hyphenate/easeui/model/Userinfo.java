package com.hyphenate.easeui.model;

/**
 * @author fanjiangpeng
 */
public class Userinfo {
    private String userId;
    private boolean isSelect = false;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
