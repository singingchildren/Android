package com.wangzijie.nutrition_user.model.bean;

public class DataBean<T> extends BaseBean{



    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
