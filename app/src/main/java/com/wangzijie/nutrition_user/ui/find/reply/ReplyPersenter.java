package com.wangzijie.nutrition_user.ui.find.reply;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.ReplyData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ReplyPersenter extends BasePresenter<ReplyContract.View> implements ReplyContract.ReplyPre {

    private ReplyContract.View view;

    public ReplyPersenter(ReplyContract.View view) {
        this.view = view;
    }

    @Override
    public void ReplyGetData(int id) {
        ApiStore.getService()
                .getReplyData("api/comments/:"+id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReplyData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReplyData replyData) {
                        view.ReplySucess(replyData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.ReplyErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
