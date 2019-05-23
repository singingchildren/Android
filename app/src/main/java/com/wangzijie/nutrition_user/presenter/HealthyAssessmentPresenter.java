package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HealthyAssessmentContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.HealthAssessmentBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 健康评估Presenter
 */
public class HealthyAssessmentPresenter extends BasePresenter<HealthyAssessmentContract.View> implements HealthyAssessmentContract.Pre{

    @Override
    public void getData(String time, String type) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("time",time)
                .add("type",type)
                .build();
        ApiStore.getService()
                .getHealthAssessment(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HealthAssessmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HealthAssessmentBean bean) {
                        if (bean.isSuccess()) {
                            view.DataSuss(bean);
                        }else {
                            view.DataErr(bean.getMessage());
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
}
