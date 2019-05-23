package com.wangzijie.nutrition_user.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.HomeContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.AstatusBean;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.HasStudioBean;
import com.wangzijie.nutrition_user.model.bean.HomeData;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author fanjiangpeng
 * 营养师端首页管理类
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.homePer {

    @Override
    public void homeGetData() {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .getPageBuild(1, Constant.LIMIT);
        ApiStore.getService()
                .getHomeData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeData homeData) {
                        view.showNormal();
                        view.homeSucess(homeData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                        view.homeErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void sendAreaName(String areaName){
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("areaName",areaName)
                .build();
        ApiStore.getService()
                .getAreadcarealist(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (baseBean.isSuccess()) {
                            view.areaNameOK(baseBean);
                        }else {
                            view.areaNameError(baseBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.areaNameError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void setBanner(ArrayList<HomeData.DataBean.BannerBean> bannerBeans, Banner imageBanan) {
        ArrayList<String> images = new ArrayList<>();
        //获取轮播图路径
        for (int i = 0; i < bannerBeans.size(); i++) {
            images.add(bannerBeans.get(i).getImgUrl());
        }

        //Banner轮播图
        imageBanan.setImages(images);
        //设置时间
        imageBanan.setDelayTime(3000);
        imageBanan.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        });
        imageBanan.isAutoPlay(true);
        imageBanan.setBannerAnimation(Transformer.Default);
        //Banner的点击事件
        //imageBanan.setOnBannerListener(position -> view.bannerOnclick(bannerBeans.get(position)));
        //开启轮播
        imageBanan.start();
    }

    @Override
    public void getHasStudio() {
        ApiStore.getService()
                .getHasStudio()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HasStudioBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HasStudioBean hasStudio) {
                        if (hasStudio.isSuccess()) {
                            view.getHasStudioOK(hasStudio);
                        }else {
                            view.getHasStudioError(hasStudio.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getHasStudioError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getAstatus() {
        ApiStore.getService()
                .getAstatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AstatusBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AstatusBean baseBean) {
                        if (baseBean.isSuccess()) {
                            view.getAstatusOK(baseBean);
                        }else {
                            view.getAstatusError(baseBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getAstatusError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
