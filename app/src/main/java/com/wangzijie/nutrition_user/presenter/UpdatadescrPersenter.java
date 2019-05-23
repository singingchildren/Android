package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.UpdatadescrContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class UpdatadescrPersenter extends BasePresenter<UpdatadescrContract.View> implements UpdatadescrContract.Per {


    @Override
    public void getDietitianStudioGetData(String studioId, String descr, ArrayList<String> urlList ) {

        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("studioId",studioId)
                .add("descr",descr)
                .addSingleFieldObjectArray("url","imgUrl",urlList)
                .build();


        ApiStore.getService()
                .getupdatedescr(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        view.onSuccess(successBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFreali("网络异常！请稍后重试！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
