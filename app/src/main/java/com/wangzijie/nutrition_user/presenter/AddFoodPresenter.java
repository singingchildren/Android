package com.wangzijie.nutrition_user.presenter;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.AddFoodContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 添加饮食评估Presenter
 */
public class AddFoodPresenter extends BasePresenter<AddFoodContract.View> implements AddFoodContract.Pre {

    @Override
    public void putData(String type1, String type2, String type3, String type4, String type5,
                        String type6, String type7, String type8, String type9, String type10,
                        String age, int gender, int gestation,String time) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("type1", type1)
                .add("type2", type2)
                .add("type3", type3)
                .add("type4", type4)
                .add("type5", type5)
                .add("type6", type6)
                .add("type7", type7)
                .add("type8", type8)
                .add("type9", type9)
                .add("type10", type10)
                .add("age", age)
                .add("Gender", gender)
                .add("gestation", gestation)
                .add("time", time)
                .build();
        ApiStore.getService()
                .DietAssessment(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DietAssessmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DietAssessmentBean bean) {
                        if (bean.isSuccess()) {
                            view.PutSuss(bean);
                        } else {
                            view.PutErr(bean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.PutErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void selectData(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10) {

        boolean isNoNull = false;

        if (!PwdCheckUtil.selectViewData(editText)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText2)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText3)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText4)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText5)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText6)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText7)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText8)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText9)) {
            isNoNull = true;
        } else if (!PwdCheckUtil.selectViewData(editText10)) {
            isNoNull = true;
        }

        if (isNoNull) {
            view.SelectSuss(PwdCheckUtil.getViewData(editText), PwdCheckUtil.getViewData(editText2), PwdCheckUtil.getViewData(editText3), PwdCheckUtil.getViewData(editText4), PwdCheckUtil.getViewData(editText5),
                    PwdCheckUtil.getViewData(editText6), PwdCheckUtil.getViewData(editText7), PwdCheckUtil.getViewData(editText8), PwdCheckUtil.getViewData(editText9), PwdCheckUtil.getViewData(editText10));
        }else {
            view.SelectErr("至少输入一种食物");
            return;
        }

    }


}
