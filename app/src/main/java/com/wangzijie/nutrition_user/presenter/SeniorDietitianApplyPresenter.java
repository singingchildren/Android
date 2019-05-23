package com.wangzijie.nutrition_user.presenter;

import android.util.Log;
import android.widget.EditText;

import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.SeniorDietitianRegisterContract;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class SeniorDietitianApplyPresenter extends BasePresenter<SeniorDietitianRegisterContract.SeniorDietitianView>
        implements SeniorDietitianRegisterContract.Pre{

    @Override
    public void selectViewData(EditText etName, EditText etIdnum, EditText etPhone, EditText etRegion, EditText etAddress) {
        if (PwdCheckUtil.selectViewData(etName)){
            view.selectErr("请输入姓名！");
            return;
        }
        if (!PwdCheckUtil.isNameNo(etName)) {
            view.selectErr("姓名需小于16位");
            return;
        }
        if (PwdCheckUtil.selectViewData(etPhone)){
            view.selectErr("请输手机号！");
            return;
        }
        if (!PwdCheckUtil.isMobile(etPhone)) {
            view.selectErr("请输入正确手机号");
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

        view.selectSuss(PwdCheckUtil.getViewData(etName),PwdCheckUtil.getViewData(etIdnum),PwdCheckUtil.getViewData(etPhone),PwdCheckUtil.getViewData(etRegion),
                PwdCheckUtil.getViewData(etAddress));
    }



    @Override
    public void dietitianApply(String etName, String etIdnum, String phone, String etRegion, String etAddress, ArrayList<String> urlList) {
        RequestBody body= RequestBodyBuilder.objBuilder()
                .add("phone", phone)
                .add("userName",etName)
                .add("idNumber", etIdnum)
                .add("area", etRegion)
                .add("address", etAddress)
                .addSingleFieldObjectArray("certificates","imgUrl",urlList)
                .build();
        ApiStore.getService()
                .dieticianApply(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean registerData) {
                        if (registerData.isSuccess()) {
                            view.applySuss();
                        } else {
                            Log.e("RegisterPresenter", "registerData" + registerData.getMessage());
                            view.applyErr(registerData.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.applyErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
