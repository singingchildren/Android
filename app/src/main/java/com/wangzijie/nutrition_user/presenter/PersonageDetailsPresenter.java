package com.wangzijie.nutrition_user.presenter;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.model.bean.UserInfo;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PersonageDetailsPresenter extends BasePresenter<PersonageDetailsPresenter.PersonageDetailsPresenterView> {

    public void getUserDetails(){
        ApiStore.getService()
                .myProfile(RequestBodyBuilder.objBuilder().build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        if (userInfo.isSuccess()) {
                            view.PersonageDetailsSuccess(userInfo);
                        } else {
                            view.PersonageDetailsError(userInfo.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.PersonageDetailsError("网络不稳定，请稍后重试！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public interface PersonageDetailsPresenterView extends BaseView {

        void PersonageDetailsSuccess(UserInfo userInfo);
        void PersonageDetailsSuccessMsg(String msg);
        void PersonageDetailsError(String msg);
        void putSuess(String msg);
        void putErr(String msg);
        void DataSuss(String msg);
        void DataErr(String err);


    }



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


    public void getInvitationCodeData(String nvitationode) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("code",nvitationode)
                .build();
        ApiStore.getService()
                .getInvitationCode(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuccessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SuccessBean successBean) {
                        if (successBean.isSuccess()){
                            view.DataSuss("发送成功！");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.DataErr("发送失败!");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
