package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.MentalityTestContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author WangZequan
 * @time 2019/5/6 13:00
 * @describe
 */
public class MentalityTestPresenter extends BasePresenter<MentalityTestContract.View> implements MentalityTestContract.Presenter {

    @Override
    public void getData() {
        ApiStore.getService()
                .userAnxiousAndPressure(RequestBodyBuilder.objBuilder().add("type","").build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (baseBean.isSuccess()) {
                            view.getDataOk(baseBean);
                        }else {
                            view.getDataEerror(baseBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataEerror(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
