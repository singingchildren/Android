package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.CardDisplayContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import org.json.JSONArray;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author WangZequan
 * @time 2019/5/15 20:34
 * @describe
 */
public class CardDisplayPresenter extends BasePresenter<CardDisplayContract.View> implements CardDisplayContract.Presenter {

    @Override
    public void getLabel() {
        ApiStore.getService()
                .queryExpertise(RequestBodyBuilder.objBuilder().build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ServiceNeedBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ServiceNeedBean serviceNeedBean) {
                        if (serviceNeedBean.isSuccess()) {
                            view.getServiceOK(serviceNeedBean);
                        } else {
                            view.err("提交失败!" + serviceNeedBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.err("获取擅长领域标签失败!请稍后重试！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void saveCard(String realname, String content, String service, JSONArray jsonArray, List urlList1, List urlList2) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("realname",realname)
                .add("service", service)
                .add("content",content)
                .addSingleFieldObjectArray("imgUrl","certificates",urlList1)
                .addSingleFieldObjectArray("imgUrl","cases",urlList2)
                .addObjectArray("data",jsonArray)
                .build();
        ApiStore.getService()
                .saveMyCard(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        if (successBean.isSuccess()) {
                            view.saveMyCardOK();
                        } else {
                            view.err("提交失败!" + successBean.getMessage());
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
}
