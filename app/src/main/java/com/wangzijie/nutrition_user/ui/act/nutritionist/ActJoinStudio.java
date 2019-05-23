package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.HasStudioBean;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author fanjiangpeng
 * 加入工作室
 */
public class ActJoinStudio extends BaseActivity {


    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_name_add_studio_act)
    TextView tvNameAddStudioAct;
    @BindView(R.id.ll_join_add_studio)
    LinearLayout llJoinAddStudio;

    @BindView(R.id.tv_quit_add_studio)
    TextView tvQuitAddStudio;
    @BindView(R.id.ll_quit_add_studio)
    LinearLayout llQuitAddStudio;


    @Override
    protected int getLayoutId() {
        return R.layout.act_add_studio;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getHasStudio();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.back, R.id.commit, R.id.tv_quit_add_studio})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.commit:
                if (PwdCheckUtil.selectViewData(etCode)) {
                    Toast.makeText(activity, "请输入邀请码", Toast.LENGTH_SHORT).show();
                    return;
                }
                joinStudio(etCode.getText().toString());
                break;
            case R.id.tv_quit_add_studio:
                quitStudio(etCode.getText().toString());
                break;
            default:
                break;
        }
    }

    private void getHasStudio() {
        ApiStore.getService()
                .getHasStudio()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HasStudioBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HasStudioBean hasStudioBean) {
                        if (hasStudioBean.isSuccess()) {
                            if (hasStudioBean.getData().isHasStudio()) {
                                showQuit();
                                MyApplication.globalData.setStudioInvitationCode(hasStudioBean.getData().getSpCode());
                                tvNameAddStudioAct.setText(hasStudioBean.getData().getSpName());
                            }else {
                                Toast.makeText(activity, "还未加入工作室", Toast.LENGTH_SHORT).show();
                                showJoin();
                            }
                        }else {
                            showJoin();
                            Toast.makeText(activity, "查看工作室失败:" + hasStudioBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        showJoin();
                        Toast.makeText(activity, "查看工作室失败:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void quitStudio(String code) {
        ApiStore.getService()
                .quitStudio(RequestBodyBuilder.objBuilder().add("code", code).build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (baseBean.isSuccess()) {
                            Toast.makeText(activity, "退出成功", Toast.LENGTH_SHORT).show();
                            initData();
                            showJoin();
                        } else {
                            Toast.makeText(activity, baseBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "退出失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void joinStudio(String code) {
        ApiStore.getService()
                .joinStudio(RequestBodyBuilder.objBuilder().add("code", code).build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (baseBean.isSuccess()) {
                            Toast.makeText(activity, "加入成功", Toast.LENGTH_SHORT).show();
                            initData();
                            showQuit();
                        } else {
                            Toast.makeText(activity, baseBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "加入失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void showJoin(){
        llJoinAddStudio.setVisibility(View.VISIBLE);
        llQuitAddStudio.setVisibility(View.GONE);
    }

    private void showQuit(){
        llJoinAddStudio.setVisibility(View.GONE);
        llQuitAddStudio.setVisibility(View.VISIBLE);
    }

}
