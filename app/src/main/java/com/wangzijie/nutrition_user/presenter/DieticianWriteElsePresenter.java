package com.wangzijie.nutrition_user.presenter;

import com.google.gson.Gson;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DieticianWriteBean;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class DieticianWriteElsePresenter extends BasePresenter<DieticianWriteElsePresenter.DieticianWriteElseView> {

    public void getDieticianWriteElse( DieticianWriteBean dieticianWriteBean) {

            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),new Gson().toJson(dieticianWriteBean));

            ApiStore.getService()
                    .getDieticianWriteElse(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<SuccessBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SuccessBean successBean) {

                            if (successBean.isSuccess()){
                                view.onDieticianWriteElse("撰写成功！");
                            }else {
                                view.err(successBean.getMessage());
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            view.err("网络不稳定，请重新撰写！");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }




    public interface DieticianWriteElseView extends BaseView {

        void onDieticianWriteElse(String msg);

        void err(String message);
    }


}
