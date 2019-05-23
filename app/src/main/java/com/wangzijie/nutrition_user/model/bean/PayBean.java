package com.wangzijie.nutrition_user.model.bean;

public class PayBean {

    /**
     * code : 0
     * msg : success
     * data : method=alipay.trade.app.pay&app_id=2019033063694901&charset=utf-8&version=1.0&sign_type=RSA2&timestamp=2019-04-01%2016%3A08%3A50&notify_url=http%3A%2F%2Fjzjapi.ngrok.muzhifm.com%2Fpay%2Fcall&sign=LjckpuNDiwMIVjbbdnDymictOV1BMTizPJHcfMgDOdyhCWQLl87KWEKSg4YRa%2FtILdMOKdW46Gobx7lLVV3dY4gwBoLb9rz0TR1N6j4fkEUPMV%2FzMRPyEHCBZ%2BtZoifpBhZX8gPW9JAy%2BoIXP%2B0unIC0F%2FiCgEKi1dJhTiRHlYolHg8x1nLVj4Z1ULKP%2Fsd63izTuOTnIRshmxegeJLQf0r3kPSCI7%2BOAZBISO4u8ARUIosN0KO2%2B1iGDE5cq1%2Frhr9hC4qGxzM0TjCL44j6wgd%2FZMICkPc0uCTpOqV0c4Cnik32i0rEBMugSo8xYJXU6nOLMvnDMS4iVZOlh5SH%2BA%3D%3D&alipay_sdk=alipay-sdk-nodejs-3.0.4&biz_content=%7B%22out_trade_no%22%3A%22JZJDD1553918468999%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22%E6%B1%9F%E5%AD%90%E6%9D%B0%E6%9C%8D%E5%8A%A1%22%2C%22body%22%3A%22150%E4%B8%80%E5%B9%B4%E6%9C%8D%E5%8A%A1%22%7D
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
