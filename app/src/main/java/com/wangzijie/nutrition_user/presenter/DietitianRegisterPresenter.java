package com.wangzijie.nutrition_user.presenter;

import android.util.Log;
import android.widget.EditText;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.DietitianRegisterContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.RegisterData;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


/**
 * @author fanjiangpeng
 *
 */
public class DietitianRegisterPresenter extends BasePresenter<DietitianRegisterContract.DietitianView> implements DietitianRegisterContract.DietitianPresenter {


//    private void automaticLogin(String phone, String password, String mixed, String account) {
//        RequestBody body = RequestBodyBuilder.RequestObjBodyBuilder()
//                .add("password", password)
//                .add("phone", phone)
//                .add("mixed", mixed)
//                .add("account", account).build();
//        ApiStore.getService()
//                .postLogin(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginData>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(LoginData loginData) {
//                        if (loginData.isSuccess()) {
//                            view.registSuss(loginData);
//                        } else {
//                            view.registErr("自动登录失败" + loginData.getMessage());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("RegisterPresenter", "e:" + e);
//                        view.registErr(e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    @Override
    public void selectViewData(EditText etName, EditText etIdnum, EditText etRegion, EditText etAddress, EditText etIntroduce) {
        if (PwdCheckUtil.selectViewData(etName)){
            view.selectErr("请输入姓名！");
            return;
        }
        if (!PwdCheckUtil.isNameNo(etName)){
            view.selectErr("姓名需小于16位！");
            return;
        }
        if (PwdCheckUtil.selectViewData(etIdnum)){
            view.selectErr("请输入身份证号码！");
            return;
        }
        if (!PwdCheckUtil.isIdNO(etIdnum)){
            view.selectErr("请输入正确身份证号码！");
            return;
        }

        if (PwdCheckUtil.selectViewData(etRegion)){
            view.selectErr("请输入所在地区！");
            return;
        }
        if (PwdCheckUtil.selectViewData(etAddress)){
            view.selectErr("请输入所在地区！");
            return;
        }
        if (PwdCheckUtil.selectViewData(etIntroduce)){
            view.selectErr("请输入个人介绍！");
            return;
        }

        view.selectSuss(PwdCheckUtil.getViewData(etName),PwdCheckUtil.getViewData(etIdnum),PwdCheckUtil.getViewData(etRegion),
                PwdCheckUtil.getViewData(etAddress),PwdCheckUtil.getViewData(etIntroduce));
    }

    @Override
    public void registerDietitian(String code, String phone,String password, String role, String name, String idNumber, String invitationCode, String studioCode, String area, String address, ArrayList<String> urlList1, ArrayList<String> urlList2, String introduce) {
        String certImgUrl="";
        String healthImgUrl="";
        if (urlList1!=null&&urlList1.size()>0){
            certImgUrl= urlList1.get(0);
        }
        if (urlList2!=null&&urlList2.size()>0){
            healthImgUrl= urlList2.get(0);
        }
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("code", code)
                .add("password", password)
                .add("role", role)
                .add("phone", phone)
                .add("platform", MyApplication.globalData.getPlatform())
                .add("platform_uid", MyApplication.globalData.getPlatform_udi())
                .add("accessToken", MyApplication.globalData.getAccessToken())
                //下面是营养师注册界面填的信息
                .add("userName",name)
                .add("idNumber", idNumber)
                .add("inviteCode",invitationCode)
                .add("inviteShopCode",studioCode)
                .add("area", area)
                .add("address", address)
                .add("certImgUrl", certImgUrl)
                .add("healthImgUrl", healthImgUrl)
                .add("descr",introduce)
//                .addStringArray(urlList1)
//                .addStringArray(urlList2)
                .build();

        ApiStore.getService()
                .register(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterData registerData) {
                        if (registerData.isSuccess()) {
                            view.registSuss(registerData);
//                            automaticLogin(phone,password,"",phone);
                        } else {
                            Log.e("RegisterPresenter", "registerData" + registerData.getMessage());
                            view.registErr(registerData.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.registErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
