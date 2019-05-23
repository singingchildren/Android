package com.wangzijie.nutrition_user.ui.home;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.SitewinAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.SiteBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
/**
 *  @author     WangZequan
 *  @time       2019/5/11  2:26
 *  @describe
 */
public class SiteActivity extends BaseActivity {

    @BindView(R.id.site_huiimage)
    ImageView siteHuiimage;
    @BindView(R.id.cl_main_site_act)
    ConstraintLayout siteHide;
    @BindView(R.id.edt_seek_site_act)
    EditText edtSeekSiteAct;
    @BindView(R.id.cl_no_seek_site_act)
    ConstraintLayout clNoSeekSiteAct;
    @BindView(R.id.cl_ok_seek_site_act)
    ConstraintLayout clOkSeekSiteAct;
    @BindView(R.id.site_winrecycle)
    RecyclerView siteRecycle;
    @BindView(R.id.tv_location_site_act)
    TextView tvLocationSiteAct;


    private ArrayList<SiteBean.DataBean.AreaListBean> siteList = new ArrayList<>();
    private String find;
    private SitewinAdapter siteAdapter;
    private ProgressDialog waitingDialog;
    private String areaName;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_site;
    }

    @Override
    protected void initView() {
        gone();
        siteAdapter = new SitewinAdapter(R.layout.sitewin, siteList, this);
        siteRecycle.setLayoutManager(new LinearLayoutManager(this));
        siteRecycle.setAdapter(siteAdapter);
        siteAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            waitingDialog = DisplayUtils.showWaitingDialog(this, "等待提交");
            areaName = siteList.get(i).getAreaName();
            setBindArea(siteList.get(i).getAreaId());
        });
        tvLocationSiteAct.setOnClickListener(v -> {
            edtSeekSiteAct.setText(tvLocationSiteAct.getText());
        });


        edtSeekSiteAct.addTextChangedListener(new TextWatcher() {
            //输入之前
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //正在输入
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    gone();
                } else if (s.length() >= 2) {
                    find = edtSeekSiteAct.getText().toString().trim();
                    getAreadcarealist(find);
                }
            }

            //输入结果
            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(find)){
                    gone();
                } else {
                    clOkSeekSiteAct.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void getAreadcarealist(String areaName) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("areaName", areaName)
                .build();
        ApiStore.getService()
                .getAreadcarealist(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SiteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SiteBean siteBean) {
                        if (siteBean.isSuccess()) {
                            List<SiteBean.DataBean.AreaListBean> areaList = siteBean.getData().getAreaList();
                            if(areaList!=null&&areaList.size()>0)
                            showOk(siteBean);
                            else showNo();
                        }else {
                            showNo();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        showNo();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void initData() {
        String areaName = getIntent().getStringExtra("areaName");
        if (!TextUtils.isEmpty(areaName)) {
            tvLocationSiteAct.setText(areaName);
        }
        showNormal();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.site_huiimage, R.id.edt_seek_site_act})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.site_huiimage:
                finish();
                break;

        }

    }
    private void showOk(SiteBean siteBean){
        siteList.clear();
        clOkSeekSiteAct.setVisibility(View.VISIBLE);
        clNoSeekSiteAct.setVisibility(View.GONE);
        siteList.addAll(siteBean.getData().getAreaList());
        siteAdapter.notifyDataSetChanged();
    }

    private void showNo(){
        clOkSeekSiteAct.setVisibility(View.GONE);
        clNoSeekSiteAct.setVisibility(View.VISIBLE);
    }

    private void gone(){
        clOkSeekSiteAct.setVisibility(View.GONE);
        clNoSeekSiteAct.setVisibility(View.GONE);
    }


    private void setBindArea(String areaId) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("areaId", areaId)
                .build();
        ApiStore.getService()
                .setBindArea(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (waitingDialog!=null)
                        waitingDialog.dismiss();
                        if (baseBean.isSuccess()) {
                            Toast.makeText(myApplication, "设置地区成功", Toast.LENGTH_SHORT).show();
                            setResult(1,getIntent().putExtra("areaName",areaName));
                            finish();
                        }else {
                            Toast.makeText(myApplication, baseBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (waitingDialog!=null)
                        waitingDialog.dismiss();
                        Toast.makeText(myApplication, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
