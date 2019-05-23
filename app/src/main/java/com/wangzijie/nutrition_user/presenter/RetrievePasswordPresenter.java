package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class RetrievePasswordPresenter extends BasePresenter {

    public void RetriavaPwd(String oldPassword,String newPassword){

        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("oldPassword", oldPassword)
                .add("newPassword", newPassword)
                .build();
        ApiStore.getService()
                .amendPwd(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public interface RetrievePasswordPresenterView extends BaseView {

        void SuccessMsg(String msg);
        void Error(String msg);


    }



}
