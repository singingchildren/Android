package com.wangzijie.nutrition_user.contract;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;

public class PersonalDocumentContract {

    public interface View extends BaseView{

        void putSuess(String msg);

        void putErr(String err);

        void selectSuss(String realname, String height, String age, String weigh);
    }

    public interface Pre{

        /**
         * 个人信息
         * @param nickname
         * @param avatar
         * @param height
         * @param realname
         * @param age
         * @param descr
         * @param gender
         * @param weight
         */
        void changeProfile(String nickname, String avatar, String height, String realname, String age, String descr, String gender, String weight);


        /**
         * 个人档案
         * @param realname
         * @param height
         * @param age
         * @param weight
         */
        void changeDocunment(String nickname, String avatar, String realname, String age, String descr, String gender);


        /**
         * 查询数据
         * @param realname
         * @param height
         * @param age
         * @param weight
         */
        void selectData(EditText realname, EditText height, EditText age, EditText weight);
    }
}
