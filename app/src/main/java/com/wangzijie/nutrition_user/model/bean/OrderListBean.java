package com.wangzijie.nutrition_user.model.bean;

import java.io.Serializable;
import java.util.List;

public class OrderListBean implements Serializable {


    private boolean nextPage;
    private List<OrderBean> orders;

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public List<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBean> orders) {
        this.orders = orders;
    }


}
