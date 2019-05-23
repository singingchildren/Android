package com.wangzijie.nutrition_user.ui.find.commentpersenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.NewsData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentPersenter extends BasePresenter<CommentContract.View> implements CommentContract.CommentPre {

    public CommentContract.View view;

    public CommentPersenter(CommentContract.View view) {
        this.view = view;
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
