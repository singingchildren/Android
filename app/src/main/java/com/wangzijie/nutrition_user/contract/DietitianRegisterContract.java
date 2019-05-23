package com.wangzijie.nutrition_user.contract;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.RegisterData;

import java.util.ArrayList;

/**
 * @author fanjiangpeng
 * 营养师注册管理类
 */
public class DietitianRegisterContract {

    public interface DietitianView extends BaseView {

        /**
         * 检出数据符合要求
         * @param name
         * @param idNum
         * @param region
         * @param address
         */
        void selectSuss(String name, String idNum, String region, String address,String introduce);

        void selectErr(String errCode);


        /**
         * 注册成功
         */
        void registSuss(RegisterData registerData);

        /**
         * 注册失败
         * @param errCode
         */
        void registErr(String errCode);


    }


    public interface DietitianPresenter {

        /**
         * 判断输入框数据是否符合要求
         * @param etName        名字
         * @param etIdnum       身份证号码
         * @param etRegion      所在地区
         * @param etAddress     具体地址
         * @param etIntroduce   介绍
         */
        void selectViewData(EditText etName, EditText etIdnum, EditText etRegion,
                            EditText etAddress,EditText etIntroduce);


        /**
         * 注册营养师
         * @param code              验证码
         * @param phone             手机号
         * @param password          密码
         * @param role              角色
         * @param name              名字
         * @param idNumber          身份证号
         * @param InvitationCode    邀请码
         * @param studioCode        工作室邀请码
         * @param area              地区名称
         * @param address           详细地址
         * @param urlList1          第一个照片列表path集合
         * @param urlList2          第一个照片列表path集合
         * @param introduce         介绍
         */
        void registerDietitian(String code,String phone, String password, String role, String name, String idNumber, String InvitationCode , String studioCode, String area,
                               String address, ArrayList<String> urlList1, ArrayList<String> urlList2,String introduce);

    }



}
