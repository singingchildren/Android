package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import org.json.JSONArray;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class ServiceNeedsPresenter extends BasePresenter<ServiceNeedsPresenter.ServiceNeedsView> {

        public void getServiceNeeds() {

            RequestBody body = RequestBodyBuilder.objBuilder()
                    .build();
            ApiStore.getService()
                    .queryServiceNeed(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ServiceNeedBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ServiceNeedBean serviceNeedBean) {

                            view.onSuccess(serviceNeedBean);


                        }

                        @Override
                        public void onError(Throwable e) {
                            view.err(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    public void setServiceNeeds(JSONArray jsonArray) {
        RequestBody body= RequestBodyBuilder
                .objBuilder()
                .addObjectArray("data",jsonArray)
                .build();
        ApiStore.getService()
                .submitServiceNeed(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        if (successBean.isSuccess()){
                            view.onSuccessMsg("提交成功!");
                        }else {
                            view.err("提交失败!"+successBean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.err("提交失败!请稍后重试！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




public interface ServiceNeedsView extends BaseView {

    void onSuccess(ServiceNeedBean dataBean);
    void onSuccessMsg(String msg);
    void err(String message);
}


}
