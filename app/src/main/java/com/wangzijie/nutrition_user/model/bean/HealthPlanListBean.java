package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;
import java.util.List;

public class HealthPlanListBean implements Serializable {

    /**
     * nextPage : false
     * planList : [{"CMDREP_CMID":"28","CMDREP_CREATETIME":"20190511123012","timeStr":"2019-05-01~2019-05-11","CMDREP_TYPE10":"1","type10":"1","id":"1","CMDREP_PEROID":"2019-05-01~2019-05-11","CMDREP_TYPE9":"1","CMDREP_ID":"1","CMDREP_DCID":"5","CMDREP_TYPE8":"1","PAGINATION_NUMBER":"1","CMDREP_TYPE7":"1","CMDREP_TYPE6":"1","CMDREP_TYPE5":"1","type5":"1","CMDREP_TYPE4":"1","type4":"1","CMDREP_TYPE3":"1","type3":"1","CMDREP_TYPE2":"1","type2":"1","CMDREP_TYPE1":"1","type9":"1","type8":"1","type7":"1","type6":"1","type1":"1"}]
     */

    private boolean nextPage;
    private List<HealthPlanBean> planList;

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public List<HealthPlanBean> getPlanList() {
        return planList;
    }

    public void setPlanList(List<HealthPlanBean> planList) {
        this.planList = planList;
    }


}
