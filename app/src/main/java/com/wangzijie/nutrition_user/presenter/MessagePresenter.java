package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.MessageContract;

public class MessagePresenter extends BasePresenter<MessageContract.MessageView> implements MessageContract.MessagePre{

    public MessageContract.MessageView view;

    public MessagePresenter(MessageContract.MessageView view){
        this.view = view;
    }

    @Override
    public void getContact() {
    }
}
