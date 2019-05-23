package com.wangzijie.nutrition_user.model.bean;

public class MoenyData {

    /**
     * code : 0
     * msg : success
     * data : https://openapi.alipay.com/gateway.do?method=alipay.trade.page.pay&app_id=2016092700606166&charset=utf-8&version=1.0&sign_type=RSA2&timestamp=2019-03-25%2018%3A40%3A00&notify_url=http%3A%2F%2Fxiyuzhiyan.ngrok.muzhifm.com%2Fpay%2Fcall&sign=wC66qgMkAepxd4%2BMMBGI6PbGLk%2B%2FlSRq0at9z%2B22iMEB%2BA4wYpg16oaJDfjMDfyZ8lld%2FcE8pTXaNEcXtCgc75xTgtserb7Bd7lcsMxUJrDSU%2B8FMEHAVDt%2FiFxVegPyLx8HqyfIuzLuaUzANsvHW5SwY9L%2FHFXJQqa%2BNxHtnhcTENcjKlJ8bZgPbElTrwNTal%2BIxxLOo6hJHwNv9tCjWM8kJrcKzhBy%2F5axQSNIyZbga6fsd9S1%2BFWhgjtAU0NWpkg3Z0iDnPRG9LlpssNWan6Hvy0cdDJa9QILqwUVgJ%2FDl6UzLlOdav0KT4GRyR1KlnPTrXiz7d1zVJl5tZk2Aw%3D%3D&alipay_sdk=alipay-sdk-nodejs-3.0.4&biz_content=%7B%22out_trade_no%22%3A%22JZJDD1553510395222%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%22150.00%22%2C%22subject%22%3A%22%E6%B1%9F%E5%AD%90%E6%9D%B0%E6%9C%8D%E5%8A%A1%22%2C%22body%22%3A%22payInfo.type%22%7D
     */

    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
