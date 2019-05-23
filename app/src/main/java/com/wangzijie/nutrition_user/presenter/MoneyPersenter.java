package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.MoenyContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class MoneyPersenter extends BasePresenter<MoenyContract.View> implements MoenyContract.MoneyPer {


//    public String cybData(String purchaserId, String sellerld, String price) {
//        String url = null;
//        try {
//            JSONObject body = new JSONObject();
//            body.put("purchaserId", purchaserId);
//            body.put("sellerId", sellerld);
//            body.put("price", price);
//            url = body.toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return url;
//    }


//    @Override
//    public void moneyGetData(String purchaserId, String sellerId, String price, String appId, String type, String payChannle) {
//        String s = cybData(purchaserId, sellerId, price);
//        RequestBody body = RequestBody.create(MediaType.parse("pay/call"), s);
//        ApiStore.getService()
//                .getMoneyData(body, appId, type, payChannle)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MoenyData>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(MoenyData moenyData) {
//                        view.moneySucess(moenyData);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.moneyErr(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//               });
//    }



    /**
     * 微信
     *
     * @param payChannl
     */
    @Override
    public void Pay(  String payChannl, String orderId) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("orderId", orderId)
                .add("payChannel", payChannl)
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
                            view.pay(bean.getData(),payChannl);
                        }else {
                            view.moneyErr(bean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.moneyErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
