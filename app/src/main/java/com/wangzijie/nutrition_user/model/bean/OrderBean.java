package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;

public class OrderBean implements Serializable {


    /**
     * createdAt : 2019-05-09 14:44:40
     * price : 150.0
     * purchaser_id : 37
     * orderNum : 2019050914444012379152
     * id : 5
     * type : 年费
     * seller_id : 45
     */

    private String createdAt;
    private String price;   //显示金额
    private String payPrice;//实际支付金额
    private int purchaser_id;
    private String orderNum;
    private String id;
    private String type;
    private int seller_id;
    private String[] typeArr;
    private int state;//订单状态  -1作废，0待支付，1已支付


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public String[] getTypeArr(){
        //定制化营养师服务,如果type包含","则说明是定制化（后台这么定的）
        if (null!=typeArr&&type.indexOf(",")>-1){
            typeArr=type.split(",");
        }else if (null!=typeArr&&type.indexOf("，")>-1){
            typeArr=type.split("，");
        }
        return typeArr;

    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }
}
