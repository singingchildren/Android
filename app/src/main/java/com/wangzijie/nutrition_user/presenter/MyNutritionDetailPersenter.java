package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.contract.MoenyContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.AliplayBean;
import com.wangzijie.nutrition_user.model.bean.MoenyData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.PayBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MyNutritionDetailPersenter extends BasePresenter<MyNutritionDetailPersenter.MyNutritionDetailView> {



    public void generateOrder(String token, int purchaserId, int sellerId, double price, String type) {
//        Map<String,String> map=new HashMap<>();
//        map.put("purchaserId",String.valueOf(purchaserId));
//        map.put("sellerId",String.valueOf(sellerId));
//        map.put("price",String.valueOf(price));
//        map.put("type",type);
////        RequestBody body = RequestBody.create(MediaType.parse("pay/call"), s);
//        ApiStore.getService()
//                .generateOrder(map)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<OrderBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(OrderBean orderBean) {
//                        view.generateOrderSuccess(orderBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
////                        view.moneyErr(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }





    public interface MyNutritionDetailView extends BaseView {
        /**
         *
         * 生成订单
         * @param orderBean
         */

        void generateOrderSuccess(OrderBean orderBean);




    }

}
