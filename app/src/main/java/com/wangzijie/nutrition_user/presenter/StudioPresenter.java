package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.StudioContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class StudioPresenter extends BasePresenter<StudioContract.View> implements StudioContract.workPer {


    @Override
    public void getStudioData(int page) {
        RequestBody body = RequestBodyBuilder.objBuilder().getPageBuild(page, Constant.LIMIT);
        ApiStore.getService()
                .getStudiodata(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StudioListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StudioListBean studioBean) {
                        if (studioBean.isSuccess()) {
                            view.studioSucess(studioBean);
                        }else {
                            view.studioErr(studioBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.studioErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
