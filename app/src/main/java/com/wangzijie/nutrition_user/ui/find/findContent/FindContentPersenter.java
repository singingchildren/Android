package com.wangzijie.nutrition_user.ui.find.findContent;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.FindContent;
import com.wangzijie.nutrition_user.model.bean.NewsData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FindContentPersenter extends BasePresenter<FindContentContract.View> implements FindContentContract.FindContentPre {

    @Override
    public void findComtentGetData(int id) {
        ApiStore.getService()
                .getFindData("discover/blog/:"+id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindContent findContent) {
                        view.FindContentSucess(findContent);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.FindContentErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void commentGetData(int blogId,int limit,int page) {
        ApiStore.getService()
                .getNewData(blogId,limit,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsData newsData) {
                        view.CommentSucess(newsData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.CommentErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
