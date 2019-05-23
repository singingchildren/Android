package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.DetailContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.DieticianDetailsData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.DetailPer {

    public void generateOrder(String sellerId,String price, String type) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("sellerId",sellerId)
                .add("price", price)
                .add("type", type)
                .build();

        ApiStore.getService()
                .generateOrder(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<OrderBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<OrderBean> dataBean) {
                        if (dataBean.isSuccess()) {
                            view.OrderSucess(dataBean);
                        } else
                            view.OrderErr(dataBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.OrderErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void detailGetData(String id) {
        ApiStore.getService()
                .getDetailData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DieticianDetailsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DieticianDetailsData detailsData) {
                        if (detailsData.isSuccess()) {
                            view.DetailSucess(detailsData.getData());
                        }else {
                            view.DetailErr(detailsData.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.DetailErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
