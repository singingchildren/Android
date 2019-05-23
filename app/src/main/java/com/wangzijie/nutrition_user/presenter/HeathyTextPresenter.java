package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HeathyTextContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HeathyTextPresenter extends BasePresenter<HeathyTextContract.View> implements HeathyTextContract.Pre {

    @Override
    public void getData(int contentId) {
        ApiStore.getService()
                .healthTextPart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean homeData) {
//                        view.DataSuss(homeData);

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
