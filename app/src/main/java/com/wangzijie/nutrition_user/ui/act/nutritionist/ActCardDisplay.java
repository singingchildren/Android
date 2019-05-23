package com.wangzijie.nutrition_user.ui.act.nutritionist;


import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.ServiceNeesdsAdapter;
import com.wangzijie.nutrition_user.adapter.mine.PhotoAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.CardDisplayContract;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;
import com.wangzijie.nutrition_user.presenter.CardDisplayPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;
import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT2;

/**
 * @author WangZequan
 * @time 2019/5/14  23:40
 * @describe 营养师>编辑>我的名片展示
 */
public class ActCardDisplay extends BaseActivity<CardDisplayPresenter> implements CardDisplayContract.View {

    @BindView(R.id.et_name_card_display_act)
    EditText etNameCardDisplayAct;
    @BindView(R.id.rct_label_card_display_act)
    RecyclerView rctLabelCardDisplayAct;
    @BindView(R.id.rcv_resume_card_display_act)
    RecyclerView rcvResumeCardDisplayAct;
    @BindView(R.id.rcv_case_card_display_act)
    RecyclerView rcvCaseCardDisplayAct;
    @BindView(R.id.et_introduction_card_display_act)
    EditText etIntroductionCardDisplayAct;
    @BindView(R.id.edt_service_card_display_act)
    EditText edtServiceCardDisplayAct;


    ImageItem imageItem = new ImageItem();

    private ServiceNeesdsAdapter labelAdapter;
    private PhotoAdapter photoAdapter1;
    private PhotoAdapter photoAdapter2;


    private ArrayList<ServiceNeedBean.DataBean> labelList = new ArrayList<>();
    private ArrayList<ImageItem> imageItemList1 = new ArrayList<>();
    private ArrayList<ImageItem> imageItemList2 = new ArrayList<>();

    private ProgressDialog progressDialog;
    private JSONArray jsonArray;


    @Override
    protected int getLayoutId() {
        return R.layout.act_card_display;
    }

    @Override
    protected void initView() {
        rctLabelCardDisplayAct.setLayoutManager(new GridLayoutManager(this, 4));
        rcvResumeCardDisplayAct.setLayoutManager(new GridLayoutManager(this, 4));
        rcvCaseCardDisplayAct.setLayoutManager(new GridLayoutManager(this, 4));

        rctLabelCardDisplayAct.setNestedScrollingEnabled(false);
        rcvResumeCardDisplayAct.setNestedScrollingEnabled(false);
        rcvCaseCardDisplayAct.setNestedScrollingEnabled(false);


        labelAdapter = new ServiceNeesdsAdapter(this);
        rctLabelCardDisplayAct.setAdapter(labelAdapter);


        imageItemList1.add(imageItem);
        imageItemList2.add(imageItem);

        photoAdapter1 = new PhotoAdapter(imageItemList1, REQUEST_CODE_SELECT, 4);
        rcvResumeCardDisplayAct.setAdapter(photoAdapter1);
        photoAdapter1.setClickImageListener(rcvResumeCardDisplayAct,this);

        photoAdapter2 = new PhotoAdapter(imageItemList2, REQUEST_CODE_SELECT2, 4);
        rcvCaseCardDisplayAct.setAdapter(photoAdapter2);
        photoAdapter2.setClickImageListener(rcvCaseCardDisplayAct,this);

    }

    @Override
    protected void initData() {
        mPresenter.getLabel();
    }

    @Override
    protected CardDisplayPresenter createPresenter() {
        return new CardDisplayPresenter();
    }


    @OnClick({R.id.back, R.id.btn_submit_card_display_act})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_submit_card_display_act:
                checkInput();
                break;
        }
    }

    private void checkInput() {
        if (PwdCheckUtil.selectViewData(etNameCardDisplayAct)) {
            err("请输入名字");
            return;
        }
        if (!putLabel()) {
            err("请选择擅长领域");
            return;
        }
        boolean isNull = false;
        for (ImageItem item : imageItemList1) {
            if (!TextUtils.isEmpty(item.path)) {
                isNull = true;
            }
        }
        if (!isNull) {
            err("请上传资历证书照片!");
            return;
        }
        if (PwdCheckUtil.selectViewData(etIntroductionCardDisplayAct)) {
            err("请输入个人介绍!");
            return;
        }
        if (PwdCheckUtil.selectViewData(edtServiceCardDisplayAct)) {
            err("请输入服务内容!");
            return;
        }

        progressDialog = DisplayUtils.showWaitingDialog(this, "图片上传中");

        //HashMap<String(列表类型), String(文件path)>
        ArrayList<HashMap<String, String>> urlMapList = new ArrayList<>();
        for (ImageItem item : imageItemList1) {
            if (!TextUtils.isEmpty(item.path)) {
                HashMap<String, String> urlMap = new HashMap();
                urlMap.put(OssServiceUtil.UPLOAD_FILE_LIST_TYPE1, item.path);
                urlMapList.add(urlMap);
            }
        }
        for (ImageItem item : imageItemList2) {//选填字段不做要求
            if (!TextUtils.isEmpty(item.path)) {
                HashMap<String, String> urlMap = new HashMap();
                urlMap.put(OssServiceUtil.UPLOAD_FILE_LIST_TYPE2, item.path);
                urlMapList.add(urlMap);
            }
        }

        OssServiceUtil.upload(".jpg", urlMapList, new OssServiceUtil.CallBack2() {

            @Override
            public void ossUploadSucceed(ArrayList<String>... urlList) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                mPresenter.saveCard(etNameCardDisplayAct.getText().toString()
                        , etIntroductionCardDisplayAct.getText().toString()
                        , edtServiceCardDisplayAct.getText().toString()
                        , jsonArray, urlList[0], urlList[1]);
            }

            @Override
            public void ossUploadFailed(String error) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                ToastUtil.show(ActCardDisplay.this, "上传图片失败" + error);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT) {
            photoAdapter1.onActivityResult(requestCode, resultCode, data);
        } else if (requestCode == REQUEST_CODE_SELECT2) {
            photoAdapter2.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void getServiceOK(ServiceNeedBean serviceNeedBean) {
        labelList.addAll(serviceNeedBean.getData());
        labelAdapter.setList(labelList);
    }

    @Override
    public void err(String s) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveMyCardOK() {
        Toast.makeText(activity, "提交成功", Toast.LENGTH_SHORT).show();
        finish();
    }


    private boolean putLabel() {
        if (labelList == null || labelList.size() == 0) {
            return false;
        }
        jsonArray = new JSONArray();
        for (ServiceNeedBean.DataBean dataBean : labelList) {
            if (dataBean.isSelected()) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("name", dataBean.getName());
                    jsonObject.put("id", dataBean.getId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jsonArray.put(jsonObject);
            }
        }
        return jsonArray.length() > 0;
    }
}
