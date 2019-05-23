package com.wangzijie.nutrition_user.model.bean;

/**
 * @author fanjiangpeng
 * 营养师信息
 */
public class DietitianBean {
    /**
     * id : 1
     * nickname : 张小红
     * avatar : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551952012909&di=e963aadb95ad1033e51921b8521afe4a&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F17%2F12%2F16pic_1712108_b.jpg
     */

    private int id;
    private String nickname;
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
