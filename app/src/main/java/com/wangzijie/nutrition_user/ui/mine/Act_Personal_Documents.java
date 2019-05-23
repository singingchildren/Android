package com.wangzijie.nutrition_user.ui.mine;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.DocmentsContact;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.DocmentsBean;
import com.wangzijie.nutrition_user.presenter.DocmentsPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.SharedPreferenceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 个人文档activity
 *
 * @author fanjiangpeng
 */
public class Act_Personal_Documents extends BaseActivity<DocmentsPresenter> implements DocmentsContact.View {


    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.home_healthimage)
    ImageView homeHealthimage;
    @BindView(R.id.home_healthtext)
    TextView homeHealthtext;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_sex)
    EditText etSex;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_height)
    EditText etHeight;
    @BindView(R.id.et_weight)
    EditText etWeight;
    @BindView(R.id.ll_member_user_file)
    LinearLayout llMemberUserFile;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_height)
    TextView tvHeight;
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.ll_dietician_user_file)
    LinearLayout llDieticianUserFile;

    @Override
    protected int getLayoutId() {
        return R.layout.act_personal_documents;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        if (MyApplication.globalData.isNutritionist()) {
            homeHealthtext.setText("用户文档");
            DisplayUtils.goneView(commit,llMemberUserFile);
            DisplayUtils.visibleView(llDieticianUserFile);
            String userId = (String) SharedPreferenceUtil.get(Act_Personal_Documents.this, "userId", "");
            mPresenter.getData(userId);
        }else {
            homeHealthtext.setText("个人文档");
            DisplayUtils.visibleView(commit,llMemberUserFile);
            DisplayUtils.goneView(llDieticianUserFile);
        }
    }

    @Override
    protected DocmentsPresenter createPresenter() {
        return new DocmentsPresenter();
    }


    @OnClick({R.id.back, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.commit:
                if (selectData()) {
                    commitData();
                }
                break;
            default:
                break;
        }
    }

    private void commitData() {
        ProgressDialog waitingDialog = DisplayUtils.showWaitingDialog(this, "提交中");
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("realname",etName.getText().toString())
                .add("gender",etSex.getText().toString())
                .add("age",etAge.getText().toString())
                .add("height",etHeight.getText().toString())
                .add("weight",etWeight.getText().toString())
                .build();
        ApiStore.getService()
                .postPersonal(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        waitingDialog.dismiss();
                        if (baseBean.isSuccess()) {
                            finish();
                        }else {
                            Toast.makeText(myApplication, "提交失败:"+baseBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        waitingDialog.dismiss();
                        Toast.makeText(myApplication, "提交失败:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private boolean selectData() {
        if (PwdCheckUtil.selectViewData(etName)) {
            ToastUtil.show(this, "请输入姓名");
            return false;
        }
        if (!PwdCheckUtil.isNameNo(etName)) {
            ToastUtil.show(this, "姓名需小于16位！");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etSex)) {
            ToastUtil.show(this, "请输入性别");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etAge)) {
            ToastUtil.show(this, "请输入年龄");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etHeight)) {
            ToastUtil.show(this, "请输入身高");
            return false;
        }
        if (PwdCheckUtil.selectViewData(etWeight)) {
            ToastUtil.show(this, "请输入电话");
            return false;
        }
        return true;
    }


    @Override
    public void DataSuss(DocmentsBean dataBean) {

        tvName.setText(dataBean.data.realname);
        tvSex.setText(dataBean.data.gender);
        tvAge.setText(dataBean.data.age);
        tvHeight.setText(dataBean.data.height);
        tvWeight.setText(dataBean.data.weight);

    }

    @Override
    public void DataSussMsg(String msg) {
        ToastUtil.show(this, msg);
    }

    @Override
    public void DataErr(String err) {
        ToastUtil.show(this, err);
    }
}
