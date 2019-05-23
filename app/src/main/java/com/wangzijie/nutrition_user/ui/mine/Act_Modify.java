package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.presenter.PersonageDetailsPresenter;
import com.wangzijie.nutrition_user.presenter.RetrievePasswordPresenter;
import com.wangzijie.nutrition_user.ui.act.Act_Retrieve_Password;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改密码
 *
 * @author fanjiangpeng
 */
public class Act_Modify extends  BaseActivity<RetrievePasswordPresenter> implements RetrievePasswordPresenter.RetrievePasswordPresenterView {

    @BindView(R.id.edit_old)
    EditText editOld;
    @BindView(R.id.edit_new)
    EditText editNew;
    @BindView(R.id.text_forget)
    TextView textForget;
    @BindView(R.id.button_forget)
    Button buttonForget;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected RetrievePasswordPresenter createPresenter() {
        return new RetrievePasswordPresenter();
    }


    @OnClick({R.id.button_forget,R.id.text_forget,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.button_forget:
                if (selectData()){
                    String oldpwd = editOld.getText().toString();
                    String newpwd = editNew.getText().toString();
                    mPresenter.RetriavaPwd(oldpwd,newpwd);
                }
                break;
            case R.id.text_forget:
                JumpUtil.overlay(this, Act_Retrieve_Password.class);
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
            ToastUtil.show(this,"请输入旧密码!");
            return false;
        }
        if (PwdCheckUtil.selectViewData(editNew)){
            ToastUtil.show(this,"请输入新密码!");
            return false;
        }
        if (!PwdCheckUtil.isLetterDigit(PwdCheckUtil.getViewData(editNew))){
            ToastUtil.show(this,"请设置高强度密码,至少6位包含字母和数字！");
            return false;
        }
        return true;
    }

    @Override
    public void SuccessMsg(String msg) {
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show();
    }
}
