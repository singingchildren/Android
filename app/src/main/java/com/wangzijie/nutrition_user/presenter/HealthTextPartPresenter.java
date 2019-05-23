package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HealthTextPartContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 健康乐园,文章正文Presenter
 */
public class HealthTextPartPresenter extends BasePresenter<HealthTextPartContract.View> implements HealthTextPartContract.BookMainPre {

    @Override
    public void BookMainGetData() {
        ApiStore.getService()
                .healthTextPart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean bookMainData) {
//                        view.BookmainSucess(bookMainData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.BookmainErr(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
