package com.wangzijie.nutrition_user.contract;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;

/**
 * 添加饮食管理器
 */
public class AddFoodContract {

    public interface View extends BaseView {
        /**
         * 成功
         * @param bean
         */
        void PutSuss(DietAssessmentBean bean);

        /**
         * 失败
         * @param err
         */
        void PutErr(String err);

        /**
         *
         * @param str1
         * @param str2
         * @param str3
         * @param str4
         * @param str5
         * @param str6
         * @param str7
         * @param str8
         * @param str9
         * @param str10
         */
        void SelectSuss(String str1, String str2, String str3, String str4, String str5,
                        String str6, String str7, String str8, String str9, String str10);

        /**
         *
         * @param str
         */
        void SelectErr(String str);
    }


    public interface Pre {

        /**
         *
         * @param type1
         * @param type2
         * @param type3
         * @param type4
         * @param type5
         * @param type6
         * @param type7
         * @param type8
         * @param type9
         * @param type10
         * @param age
         * @param Gender    0表男1表女
         * @param gestation 0表无1表孕早期2表孕中期3表孕晚期
         */
        void putData(String type1, String type2, String type3, String type4, String type5, String type6, String type7
                , String type8, String type9, String type10, String age, int Gender, int gestation,String time);


        void selectData(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5,
                        EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10);

    }
}
