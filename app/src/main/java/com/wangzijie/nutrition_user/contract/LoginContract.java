package com.wangzijie.nutrition_user.contract;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.LoginData;

/**
 * @author fanjiangpeng
 */
public class

LoginContract {
    public interface View extends BaseView{
        /**
         * 登陆成功
         */
        void loginOk(LoginData loginData);

        /**
         * 登陆失败
         * @param err 失败信息
         */
        void loginErr(String err);

        /**
         * 获取组件数据成功
         * @param phone 获取到的账号
         * @param password 获取到的密码
         */
        void getDataOk(String phone,String password);

        /**
         * 获取组件数据失败
         * @param err
         */
        void getDataErr(String err);

        /**
         * 环信登陆成功
         */
        void loginImOk();

        /**
         * 环信登陆失败
         * @param err
         */
        void loginImErr(String err);

    }

    public interface Per{
        /**
         * 登陆
         * @param username 账号
         * @param password  密码
         */
        void loginUser(String username,String password);

        /**
         * 获取组件内容
         * @param etPhone 账号
         * @param etPassword   密码
         */
        void selectData(EditText etPhone,EditText etPassword);


        /**
         * 登陆环信
         * @param phone
         * @param password
         */
        void loginIm(String phone, String password);
    }
}
