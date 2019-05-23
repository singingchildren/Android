package com.wangzijie.nutrition_user.contract;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;

import java.util.ArrayList;

public class SeniorDietitianRegisterContract {
    public interface SeniorDietitianView extends BaseView {

        /**
         * 检出数据符合要求
         *
         * @param name
         * @param idNum
         * @param region
         * @param address
         */
        void selectSuss(String name, String idNum,String phone, String region, String address);

        void selectErr(String errCode);


        /**
         * 注册成功
         */
        void applySuss();

        /**
         * 注册失败
         *
         * @param errCode
         */
        void applyErr(String errCode);
    }


    public interface Pre {

        /**
         * 判断输入框数据是否符合要求
         *
         * @param etName    名字
         * @param etIdnum   身份证号码
         * @param etRegion  所在地区
         * @param etAddress 具体地址
         */
        void selectViewData(EditText etName, EditText etIdnum, EditText edPhone, EditText etRegion,
                            EditText etAddress);


        /**
         *
         *
         * @param etName
         * @param etIdnum
         * @param phone
         * @param etRegion
         * @param etAddress
         * @param urlList
         */
        void dietitianApply(String etName, String etIdnum, String phone, String etRegion, String etAddress, ArrayList<String> urlList);
    }

}
