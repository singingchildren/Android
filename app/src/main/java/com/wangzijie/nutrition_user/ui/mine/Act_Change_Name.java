package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.PersonalDocumentContract;
import com.wangzijie.nutrition_user.presenter.PersonalDocumentPresenter;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 更改名字
 *
 * @author fanjiangpeng
 */
public class Act_Change_Name extends BaseActivity<PersonalDocumentPresenter> implements PersonalDocumentContract.View {
    @BindView(R.id.et_name)
    EditText etName;

    @Override
    protected int getLayoutId() {
        return R.layout.act_change_name;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.back, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.commit:
                if (PwdCheckUtil.selectViewData(etName)) {
                    ToastUtil.show(this, "请输入名字!");
                    return;
                } else if (!PwdCheckUtil.isNameNo(etName)) {
                    ToastUtil.show(this, "名字需小于16位！");
                    return ;
                } else {

                    String realname = etName.getText().toString();
                    //提交接口
                    if (myApplication.globalData.isNutritionist()) {
                        mPresenter.changeDocunment("", "", realname, "", "", "");
                    } else {
                        mPresenter.changeProfile("", "", "", realname, "", "", "", "");
                    }

                    finish();

                }
                break;
            default:
                break;
        }
    }


    @Override
    protected PersonalDocumentPresenter createPresenter() {
        return new PersonalDocumentPresenter();
    }

    @Override
    public void putSuess(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void putErr(String err) {
        Toast.makeText(activity, err, Toast.LENGTH_LONG).show();
    }

    @Override
    public void selectSuss(String realname, String height, String age, String weigh) {


    }
}
