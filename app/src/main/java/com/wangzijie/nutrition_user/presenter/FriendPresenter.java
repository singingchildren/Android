package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.FriendContact;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.FriendBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FriendPresenter extends BasePresenter<FriendContact.View> implements FriendContact.Pre{

    @Override
    public void getData(int userId) {

        ApiStore.getService()
                .getFriend(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FriendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FriendBean homeData) {

                        view.DataSuss(homeData);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.DataErr(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
