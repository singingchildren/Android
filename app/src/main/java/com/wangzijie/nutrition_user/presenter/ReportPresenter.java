package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.ReportContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.ReportBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 *   我的报告Presenter
 */
public class ReportPresenter extends BasePresenter<ReportContract.View> implements ReportContract.Pre {

    @Override
    public void getData(String token) {
        RequestBody body= RequestBodyBuilder.objBuilder().build();//服务器说要一个空的json
        ApiStore.getService()
                .myReport(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReportBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReportBean bean) {
                        if (bean.isSuccess()) {
                            view.Suss(bean);
                        }else {
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
}
