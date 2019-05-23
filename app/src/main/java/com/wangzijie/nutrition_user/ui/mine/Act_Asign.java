package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.PersonalDocumentContract;
import com.wangzijie.nutrition_user.presenter.PersonalDocumentPresenter;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改个性签名
 *
 * @author fanjiangpeng
 */
public class Act_Asign extends BaseActivity<PersonalDocumentPresenter> implements PersonalDocumentContract.View  {
    @BindView(R.id.et_asign)
    EditText etAsign;

    @Override
    protected int getLayoutId() {
        return R.layout.act_asign;
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
                if (PwdCheckUtil.selectViewData(etAsign)) {
                    ToastUtil.show(this, "请输入个性签名!");
                    return;
                } else {
                    //提交接口
                    String descr = etAsign.getText().toString();
                    //提交接口
                    if (myApplication.globalData.isNutritionist()){
                        mPresenter.changeDocunment("","","","",descr,"");
                    }else{
                        mPresenter.changeProfile("","","","","",descr,"","");
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
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void putErr(String err) {
        Toast.makeText(activity,err,Toast.LENGTH_LONG).show();
    }

    @Override
    public void selectSuss(String realname, String height, String age, String weigh) {



    }
}
