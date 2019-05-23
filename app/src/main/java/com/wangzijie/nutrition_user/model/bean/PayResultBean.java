package com.wangzijie.nutrition_user.model.bean;


/**
 * 去支付接口 返回
 */
public class PayResultBean {
    private String alipayResult;  //支付宝


    /**
     * 微信
     * appId : wx61cd0cb45a23724e
     * partnerId : 1517552341
     * nonceStr : lnsWQ1uTJpuivZBM292e
     * sign : 9ABAC8DA43E018C6BBB3686185CB7656
     * packageStr : Sign=WXPay
     * timeStamp : 1557468528
     * prepayId : wx101408483132957545a013e22852383671
     * orderNo : 2019051014070913608970
     */

    private String appId;
    private String partnerId;
    private String nonceStr;
    private String sign;
    private String packageStr;
    private String timeStamp;
    private String prepayId;
    private String orderNo;


    public String getAlipayResult() {
        return alipayResult;
    }

    public void setAlipayResult(String alipayResult) {
        this.alipayResult = alipayResult;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
