package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;

public class HealthPlanBean implements Serializable {

    /**
     * CMDREP_CMID : 28
     * CMDREP_CREATETIME : 20190511123012
     * timeStr : 2019-05-01~2019-05-11
     * CMDREP_TYPE10 : 1
     * type10 : 1
     * id : 1
     * CMDREP_PEROID : 2019-05-01~2019-05-11
     * CMDREP_TYPE9 : 1
     * CMDREP_ID : 1
     * CMDREP_DCID : 5
     * CMDREP_TYPE8 : 1
     * PAGINATION_NUMBER : 1
     * CMDREP_TYPE7 : 1
     * CMDREP_TYPE6 : 1
     * CMDREP_TYPE5 : 1
     * type5 : 1
     * CMDREP_TYPE4 : 1
     * type4 : 1
     * CMDREP_TYPE3 : 1
     * type3 : 1
     * CMDREP_TYPE2 : 1
     * type2 : 1
     * CMDREP_TYPE1 : 1
     * type9 : 1
     * type8 : 1
     * type7 : 1
     * type6 : 1
     * type1 : 1
     * 这种返回方式真让我无语，厉害了
     */

    private String CMDREP_CREATETIME;
    private String timeStr;
    private String type10;
    private String id;
    private String content;
    private String type5;
    private String type4;
    private String type3;
    private String type2;
    private String type9;
    private String type8;
    private String type7;
    private String type6;
    private String type1;

    public String getCMDREP_CREATETIME() {
        return CMDREP_CREATETIME;
    }

    public void setCMDREP_CREATETIME(String CMDREP_CREATETIME) {
        this.CMDREP_CREATETIME = CMDREP_CREATETIME;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getType10() {
        return type10;
    }

    public void setType10(String type10) {
        this.type10 = type10;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType5() {
        return type5;
    }

    public void setType5(String type5) {
        this.type5 = type5;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType9() {
        return type9;
    }

    public void setType9(String type9) {
        this.type9 = type9;
    }

    public String getType8() {
        return type8;
    }

    public void setType8(String type8) {
        this.type8 = type8;
    }

    public String getType7() {
        return type7;
    }

    public void setType7(String type7) {
        this.type7 = type7;
    }

    public String getType6() {
        return type6;
    }

    public void setType6(String type6) {
        this.type6 = type6;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTypes(){
        String[] arr=new String[10];
        arr[0]=type1;
        arr[1]=type2;
        arr[2]=type3;
        arr[3]=type4;
        arr[4]=type5;
        arr[5]=type6;
        arr[6]=type7;
        arr[7]=type8;
        arr[8]=type9;
        arr[9]=type10;
        return  arr;
    }
}
