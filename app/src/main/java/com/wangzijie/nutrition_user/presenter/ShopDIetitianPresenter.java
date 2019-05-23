package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.ShopDIetitianContact;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.ShopHeadData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopDIetitianPresenter extends BasePresenter<ShopDIetitianContact.View> implements ShopDIetitianContact.Pre{


    @Override
    public void getShopDietitianList(String id) {
        ApiStore.getService()
                .getShopHeadData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopHeadData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopHeadData shopHeadData) {
                        if (shopHeadData.isSuccess()&&shopHeadData.getData()!=null) {
                            view.DataSuss(shopHeadData);
                        }else {
                            view.DataErr(shopHeadData.getMessage());
                        }

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

//
//    @Override
//    public void shopGetData() {
//        ApiStore.getService()
//                .getShopData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ShopData>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(ShopData shopData) {
//                        view.shopSucess(shopData);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.shopErr(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//    }
}
