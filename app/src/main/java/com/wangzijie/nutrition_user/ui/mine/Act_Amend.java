package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.CountDownTimerUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 更改/绑定手机号
 *
 * @author fanjiangpeng
 */
public class Act_Amend extends BaseActivity {


    @BindView(R.id.edit_old)
    EditText editOld;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_code)
    Button tvCode;

    private CountDownTimerUtils countDownTimerUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_amend;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.tv_code, R.id.commit,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                countDownTimerUtils = new CountDownTimerUtils(tvCode,60000,1000);
                countDownTimerUtils.start();
                break;
            case R.id.commit:
                if (selectData()){
                    ToastUtil.show(this,"提交");
                }
                break;
            case R.id.back:
                this.finish();
                break;
                default:
                break;
        }
    }

    private boolean selectData(){
        if (PwdCheckUtil.selectViewData(editOld)){
            ToastUtil.show(this,"请输入手机号码!");
            return false;
        }
        if (!PwdCheckUtil.isMobile(editOld)){
            ToastUtil.show(this,"请输入正确的手机号码!");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etCode)){
            ToastUtil.show(this,"请输入验证码!");
            return false;
        }
        return true;
    }
}
