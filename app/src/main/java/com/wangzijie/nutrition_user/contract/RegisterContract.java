package com.wangzijie.nutrition_user.contract;

import android.content.Context;
import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.RegisterData;

public class RegisterContract {

    public interface registerView extends BaseView{

        /**
         * 注册成功
         * RegisterData 返回一个对象
         */
        void registerOk(RegisterData registerData);

        /**
         * 注册失败
         * @param err 失败信息
         */
        void RegisterErr(String err);

        /**
         * 获取组件数据成功
         * @param phone 获取到的账号
         * @param code 获取到的验证码
         * @param password 获取到的密码
         */
        void getDataOk(String phone,String code,String password);

        /**
         * 获取组件数据失败
         * @param err
         */
        void getDataErr(String err);

        /**
         * 注册发送的验证码（View层）
         */
        //成功
        void getVerificationSucceed();

        //失败
        void getVerificationErr(String err);



    }


    public interface registerPresenter{
        /**
         * 登陆
         * @param username 账号
         * @param code 验证码
         * @param password  密码
         */
        void RegisterUser(Context context,String username, String code, String password,String role);

        /**
         * 获取组件内容
         * @param etPhone 账号
         * @param etCode 验证码
         * @param etPassword   密码
         */
        void selectData(EditText etPhone,EditText etCode, EditText etPassword);

        /**
         * 注册验证码（Persion层）
         */
        void verification(String phone);
    }
}
