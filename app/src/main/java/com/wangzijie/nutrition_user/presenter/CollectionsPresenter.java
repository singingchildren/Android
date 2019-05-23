package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.CollectionsContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 获取收藏数据
 */
public class CollectionsPresenter extends BasePresenter<CollectionsContract.View> implements CollectionsContract.Pre{

    @Override
    public void getData(int page, int limit, String type) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .getPageBuilder(page, Constant.LIMIT)
                .add("type",type)
                .build();
        ApiStore.getService()
                .getCollections(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(BaseBean bean) {
//                        view.DataSuss(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        view.DataErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
