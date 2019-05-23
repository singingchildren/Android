package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.AddSportContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.StopData;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 睡眠，运动数据提交
 */
public class AddSportPresenter extends BasePresenter<AddSportContract.View> implements AddSportContract.Pre {

    @Override
    public void putSleepAndSportData(String type, String sumNum, String time) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("type", type)
                .add("sumNum", sumNum)
                .add("time", time)
                .build();
        ApiStore.getService()
                .PutSleepAndSportData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean bean) {
                        if (bean.isSuccess()) {
                            view.Suss();
                        } else {
                            view.Err(bean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.Err(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void stopGetData() {
        ApiStore.getService()
                .getStopData(RequestBodyBuilder.objBuilder().build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StopData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StopData stopData) {
                        if (stopData.isSuccess()) {
//                        Log.d("more数据",stopData.getData().getData().get(0).getTitle());
                            view.stopSucess(stopData);
                        } else {
                            view.stopErr(stopData.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.stopErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
