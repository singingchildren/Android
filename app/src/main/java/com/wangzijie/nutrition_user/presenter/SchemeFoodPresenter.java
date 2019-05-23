package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.SchemeFoodContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 健康指导方案
 * @author fanjiangpeng
 */
public class SchemeFoodPresenter extends BasePresenter<SchemeFoodContract.View> implements SchemeFoodContract.Pre{


    @Override
    public void getHealthAssessment(int page, int limit, String type) {

        RequestBody body = RequestBodyBuilder.objBuilder()
                .getPageBuilder(page,limit)
                .add("type",type)
                .build();
        ApiStore.getService()
                .getMyHealthGuidePlan2(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyHealthGuidePlan2Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyHealthGuidePlan2Bean bean) {
                        view.DataMentSuss(bean);
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
