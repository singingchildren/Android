package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.OrderListBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class OrderPersenter extends BasePresenter<OrderPersenter.OrderView> {



    public void orders(int page, int limit) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("page", page)
                .add("limit", limit)
                .build();

        ApiStore.getService()
                .orders(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<OrderListBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<OrderListBean> dataBean) {
                        if (dataBean.isSuccess())
                            view.orderData(dataBean.getData().getOrders());
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

    public void delOrders(OrderBean orderBean) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("orderNum", orderBean.getOrderNum())
                .build();

        ApiStore.getService()
                .delOrders(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean dataBean) {
                        if (null==dataBean){
                            view.delOrders(false,null);
                        }else
                            view.delOrders(dataBean.isSuccess(),orderBean);
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


    public void Pay(  String payChannle, String orderId) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("orderId", orderId)
                .add("payChannel", payChannle)
                .build();

        ApiStore.getService()
                .getPay(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<PayResultBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<PayResultBean> bean) {
                        if (bean.isSuccess()){
                            view.pay(bean.getData(),payChannle);
                        }

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

    public interface OrderView extends BaseView {



        /**
         * 订单列表
         * @param list
         */
        void orderData(List<OrderBean> list);

        /**
         * 删除订单
         * @param isSuccess
         */
        void delOrders(boolean isSuccess,OrderBean orderBean);

        /**
         * 支付
         * @param bean
         */
        void pay(PayResultBean bean,String payType);


        void err(String message);
    }



//    private String cybData2(int purchaserId, int sellerId, double price, String type) {
//        String url = null;
//
//
//        try {
//            JSONObject body = new JSONObject();
//            body.put("purchaserId", purchaserId);
//            body.put("sellerId", sellerId);
//            body.put("price", price);
//            body.put("type", type);
//            url = body.toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return url;
//    }


}
