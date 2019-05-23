package com.wangzijie.nutrition_user.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Created by zhangshun on 2016/8/18.
 */
public class PwdCheckUtil {

    /**
     * 匹配手机号的规则：
     */
    public static final String PHONE_REGEX_MOBILE = "^[1][0-9][0-9]{9}$";

    /**
     * 匹配身份证号的正则：
     */
    public static final String ID_NUMBER_REGEX_MOBILE = "^[1][0-9][0-9]{9}$";

    /**
     * 校验手机号
     * @param view
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(@NonNull EditText view) {
        String s = view.getText().toString();
        return Pattern.matches(PHONE_REGEX_MOBILE, s);
    }

    /**
     * 身份证号码验证
     */
    public static boolean isIdNO(@NonNull EditText view) {
        // 去掉所有空格
        String num = view.getText().toString().replace(" ", "");

        Pattern idNumPattern = Pattern.compile("(\\d{17}[0-9xX])");

        //通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(num);

        //判断用户输入是否为身份证号
        if (idNumMatcher.matches()) {
            System.out.println("您的出生年月日是：");
            //如果是，定义正则表达式提取出身份证中的出生日期
            Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");//身份证上的前6位以及出生年月日

            //通过Pattern获得Matcher
            Matcher birthDateMather = birthDatePattern.matcher(num);

            //通过Matcher获得用户的出生年月日
            if (birthDateMather.find()) {
                String year = birthDateMather.group(1);
                String month = birthDateMather.group(2);
                String date = birthDateMather.group(3);
                if (Integer.parseInt(year) < 1900 // 如果年份是1900年之前
                        || Integer.parseInt(month) > 12 // 月份>12月
                        || Integer.parseInt(date) > 31 // 日期是>31号
                ) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }



    /**
     * 规则1：至少包含大小写字母及数字中的一种
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isLetterOrDigit(String str) {
        boolean isLetterOrDigit = false;//定义一个boolean值，用来表示是否包含字母或数字
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isLetterOrDigit = true;
            }
        }
        String regex = "^[a-zA-Z0-9]+$";
        boolean isRight = isLetterOrDigit && str.matches(regex);
        return isRight;
    }

    /**
     * 规则2：至少6位-12位包含字母及数字中的两种
     *
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        boolean isRight = isDigit && isLetter &&6<=str.length()&&str.length()<=12;
        return isRight;
    }

    /**
     * 规则3：必须同时包含大小写字母及数字
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isContainAll(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLowerCase = false;//定义一个boolean值，用来表示是否包含字母
        boolean isUpperCase = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLowerCase(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLowerCase = true;
            } else if (Character.isUpperCase(str.charAt(i))) {
                isUpperCase = true;
            }
        }
        String regex = "^[a-zA-Z0-9]+$";
        boolean isRight = isDigit && isLowerCase && isUpperCase && str.matches(regex);
        return isRight;
    }

    /**
     *   判断EditText输入的数字、中文还是字母方法
     */
    public static void whatIsInput(Context context, EditText edInput) {
        String txt = edInput.getText().toString();

        Pattern p = compile("[0-9]*");
        Matcher m = p.matcher(txt);
        if (m.matches()) {
            ToastUtil.show(context,"输入的是数字");
        }
        p = compile("[a-zA-Z]");
        m = p.matcher(txt);
        if (m.matches()) {
            ToastUtil.show(context,"输入的是字母");
        }
        p = compile("[\u4e00-\u9fa5]");
        m = p.matcher(txt);
        if (m.matches()) {
            ToastUtil.show(context,"输入的是汉字");
        }
    }



    /**
     * 判断输入框是否有数据
     * @param view 输入textview
     * @return true空 false非空
     */
    public static boolean selectViewData(@NonNull EditText view){
        String viewStr = getViewData(view);
        if (TextUtils.isEmpty(viewStr))
            return true;
        return false;
    }

    public static boolean isNameNo(@NonNull EditText editText){
        String name = editText.getText().toString().replace(" ", "");
        return name.length()<16;
    }

    /**
     * 返回输入框数据（字符串）
     * @param view
     * @return
     */
    public static String getViewData(@NonNull EditText view){
        String viewStr = "";
        if (TextUtils.isEmpty(viewStr)){
            viewStr = view.getText().toString();
        }else {
            viewStr = "";
        }
        return viewStr;

    }

}

