package com.wangzijie.nutrition_user.presenter;

import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.PersonalDocumentContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PersonalDocumentPresenter extends BasePresenter<PersonalDocumentContract.View> implements PersonalDocumentContract.Pre {

    @Override
    public void changeProfile(String nickname, String avatar, String height, String realname, String age, String descr, String gender, String weight) {
        String body = cyaData(nickname, avatar, realname, age, descr, gender);
        RequestBody requ = RequestBody.create(MediaType.parse("api/user/changeProfile"), body);
        ApiStore.getService()
                .changeProfile(requ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        if (successBean.isSuccess()){
                            view.putSuess("修改成功");
                        }else {
                            view.putErr(successBean.getMessage());
                        }

                    }



                    @Override
                    public void onError(Throwable e) {
                        view.putErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private String cyaData(String nickname, String avatar, String realname, String age, String descr, String gender) {
        String url = null;

        try {
            JSONObject body = new JSONObject();
            body.put("nickname", nickname);
            body.put("avatar", avatar);
            body.put("realname", realname);
            body.put("age", age);
            body.put("descr", descr);
            body.put("gender", gender);
            url = body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return url;
    }



    public void changeDocunment(String nickname, String avatar, String realname, String age, String descr, String gender) {
        String body = cyaData2(nickname, avatar, realname, age, descr, gender);
        RequestBody requ = RequestBody.create(MediaType.parse("api/user/changeProfile"), body);
        ApiStore.getService()
                .changeProfile(requ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        if (successBean.isSuccess()){
                            view.putSuess("修改成功");
                        }else {
                            view.putErr(successBean.getMessage());
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        view.putErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private String cyaData2(String nickname, String avatar, String realname, String age, String descr, String gender) {
        String url = null;

        try {
            JSONObject body = new JSONObject();
            body.put("nickname", nickname);
            body.put("avatar", avatar);
            body.put("realname", realname);
            body.put("age", age);
            body.put("descr", descr);
            body.put("gender", gender);
            url = body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return url;
    }


    @Override
    public void selectData(EditText realname, EditText height, EditText age, EditText weight) {
        if (PwdCheckUtil.selectViewData(realname)) {
            view.putErr("请输入姓名");
            return;
        }
        if (!PwdCheckUtil.isNameNo(realname)) {
            view.putErr("姓名需小于16位");
            return;
        }
        if (PwdCheckUtil.selectViewData(age)) {
            view.putErr("请输入年龄");
            return;
        }
        if (PwdCheckUtil.selectViewData(height)) {
            view.putErr("请输入身高");
            return;
        }

        if (PwdCheckUtil.selectViewData(weight)) {
            view.putErr("请输入体重");
            return;
        }
        view.selectSuss(PwdCheckUtil.getViewData(realname), PwdCheckUtil.getViewData(height), PwdCheckUtil.getViewData(age), PwdCheckUtil.getViewData(weight));
    }

}
