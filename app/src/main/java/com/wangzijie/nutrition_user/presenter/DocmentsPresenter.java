package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.DocmentsContact;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DocmentsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DocmentsPresenter extends BasePresenter<DocmentsContact.View> implements DocmentsContact.Pre {

    @Override
    public void getData(String userId) {
        ApiStore.getService()
                .getDocuments(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DocmentsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DocmentsBean successBean) {

                        view.DataSuss(successBean);

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