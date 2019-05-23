package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.CaseContract;
import com.wangzijie.nutrition_user.contract.DietitianStudioContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DietitianStudioBean;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class DietitianStudioPersenter extends BasePresenter<DietitianStudioContract.View> implements DietitianStudioContract.DietitianStudioPre {


    @Override
    public void getDietitianStudioGetData(String studioId) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("studioId",studioId)
                .build();
        ApiStore.getService()
                .getDietitianStudio(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DietitianStudioBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DietitianStudioBean dietitianStudioBean) {
                        view.onDietitianStudioSucess(dietitianStudioBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onDietitianStudioErr("网路不稳定！请稍后重试！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
