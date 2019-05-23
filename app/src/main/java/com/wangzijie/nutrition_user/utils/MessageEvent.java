package com.wangzijie.nutrition_user.utils;

public class MessageEvent<T> {

    private String message;

    private T data;
    public  MessageEvent(String message){
        this.message=message;
    }
    public  MessageEvent(String message ,T data){
        this.data=data;
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
