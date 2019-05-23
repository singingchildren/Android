package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.CaseContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class HisdePersenter extends BasePresenter<CaseContract.View> implements CaseContract.HisdePre {

    @Override
    public void HidesGetData(int page, int limit, String date) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .getPageBuilder(page,limit)
                .add("date","date")
                .build();
        ApiStore.getService()
                .getCasesList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HistoryEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HistoryEntity historyEntity) {
                        if (historyEntity.isSuccess()) {
                            view.HidesSucess(historyEntity);
                        }else {
                            view.HisdeErr(historyEntity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.HisdeErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
