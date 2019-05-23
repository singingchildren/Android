package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HealthArticlesContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.HealthArticlesBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author WangZequan
 * @time 2019/5/8 11:41
 * @describe
 */
public class HealthArticlesPresenter extends BasePresenter<HealthArticlesContract.View> implements HealthArticlesContract.Presenter {


    @Override
    public void onLoadMore(int page) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .getPageBuild(page, Constant.LIMIT);
        ApiStore.getService()
                .getHealthParkMenu(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HealthArticlesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HealthArticlesBean healthArticlesBean) {
                        if (healthArticlesBean.isSuccess()
                                ||healthArticlesBean.getData().getInfoList()==null) {
                            view.moreSucess(healthArticlesBean);
                        }else {
                            view.moreErr(healthArticlesBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.moreErr(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
