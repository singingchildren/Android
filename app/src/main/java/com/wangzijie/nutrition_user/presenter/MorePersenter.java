package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.MoreContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class MorePersenter extends BasePresenter<MoreContract.View> implements MoreContract.MorePer {

    private boolean hasRefresh = true;

    @Override
    public void moreGetData(int page, int limit) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .getPageBuild(page, Constant.LIMIT);
        this.currentPage = page;
        ApiStore.getService()
                .getRecommend(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<MoreNutritionBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<MoreNutritionBean> dataBean) {
                        if (dataBean.isSuccess()) {
                            view.moreSucess(dataBean.getData(), hasRefresh, dataBean.getData().isNextPage());
                        } else {
                            view.moreErr(dataBean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.moreErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void recommendData(int page, int limit) {
        this.currentPage = page;
        RequestBody body = RequestBodyBuilder.objBuilder().getPageBuild(page, limit);
        ApiStore.getService()
                .getMoreData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<MoreNutritionBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<MoreNutritionBean> moreData) {
                        if (moreData.isSuccess()){
                            view.moreSucess(moreData.getData(),hasRefresh,moreData.getData().isNextPage());
                        }else {
                            view.moreErr(moreData.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.moreErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void generateOrder(String sellerId, String price, String type) {

        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("sellerId", sellerId)
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
                        if (dataBean.isSuccess())
                            view.orderData(dataBean.getData());
                        else
                            view.moreErr(dataBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.moreErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onRefresh() {
        hasRefresh = true;
        currentPage=0;
        moreGetData(0, Constant.LIMIT);
    }

    @Override
    public void onLoadMore() {
        hasRefresh = false;
        currentPage++;
        moreGetData(currentPage, Constant.LIMIT);
    }

}
