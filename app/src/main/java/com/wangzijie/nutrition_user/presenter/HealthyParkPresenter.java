package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HealthyParkContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.HealthParkBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class HealthyParkPresenter extends BasePresenter<HealthyParkContract.View> implements HealthyParkContract.Pre {



    @Override
    public void getHealthPark(int page) {
        RequestBody body=RequestBodyBuilder.objBuilder()
                .getPageBuild(page, Constant.LIMIT);
        ApiStore.getService()
                .getHealthPark(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HealthParkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HealthParkBean healthParkBean) {
                        if (healthParkBean.isSuccess()) {
                            view.dataSuss(healthParkBean);
                        }else {
                            view.dataErr(healthParkBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dataErr(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
