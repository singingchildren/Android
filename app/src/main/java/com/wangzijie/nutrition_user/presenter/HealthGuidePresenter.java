package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.model.bean.HealthPlanListBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class HealthGuidePresenter extends BasePresenter<HealthGuidePresenter.HealthGuideView> {
        public void getMyHealthGuidePlan(int page, int limit,String type) {

            if ("diet".equals(type)){

                RequestBody body = RequestBodyBuilder.objBuilder()
                        .add("page", page)
                        .add("limit", limit)
                        .add("type", type)
                        .build();
                ApiStore.getService()
                        .getMyHealthGuidePlan(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<DataBean<HealthPlanListBean>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(DataBean<HealthPlanListBean> dataBean) {
                                if (dataBean.isSuccess())
                                    view.onUpdateMyHealthGuidePlan(dataBean.getData().getPlanList());
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.err(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else {


                RequestBody body = RequestBodyBuilder.objBuilder()
                        .add("page", page)
                        .add("limit", limit)
                        .add("type", type)
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
                            public void onNext(MyHealthGuidePlan2Bean myHealthGuidePlan2Bean) {
                                if (myHealthGuidePlan2Bean.isSuccess())
                                    view.onUpdateMyHealthGuidePlan2(myHealthGuidePlan2Bean.getData().getPlanList());
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
        }




public interface HealthGuideView extends BaseView {
    /**
     * 订单列表
     * @param list
     */
    void onUpdateMyHealthGuidePlan(List<HealthPlanBean> list);

    void onUpdateMyHealthGuidePlan2(List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list);

    void err(String message);
}


}
