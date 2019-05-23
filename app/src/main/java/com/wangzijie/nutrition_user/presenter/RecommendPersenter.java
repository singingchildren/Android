package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.RecommendContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class RecommendPersenter extends BasePresenter<RecommendContract.View> implements RecommendContract.RecommendPer {

    @Override
    public void recommendGetData(int page) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .getPageBuild(page,Constant.LIMIT);
        ApiStore.getService()
                .getRecommendData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean recommendData) {
                        if (recommendData.isSuccess()) {
                            //                        view.recommendSucess(recommendData);
                        }else {

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.recommendErr(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
