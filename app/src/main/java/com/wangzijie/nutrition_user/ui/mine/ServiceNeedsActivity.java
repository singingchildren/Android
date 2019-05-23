package com.wangzijie.nutrition_user.ui.mine;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.ServiceNeesdsAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;
import com.wangzijie.nutrition_user.presenter.ServiceNeedsPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ServiceNeedsActivity extends BaseActivity<ServiceNeedsPresenter> implements ServiceNeedsPresenter.ServiceNeedsView,ServiceNeesdsAdapter.getServiceNewId {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.rcv_service_needs_act)
    RecyclerView rcvServiceNeedsAct;
    private ServiceNeesdsAdapter ServiceNeesdsAdapter;

    @BindView(R.id.submit)
    Button submit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_service_needs;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        title.setText("服务需求");
        mPresenter.getServiceNeeds();
        rcvServiceNeedsAct.setLayoutManager(new GridLayoutManager(this,4));
        ServiceNeesdsAdapter  = new ServiceNeesdsAdapter(this);
        rcvServiceNeedsAct.setAdapter(ServiceNeesdsAdapter);
        ServiceNeesdsAdapter.setServiceNewId(this);
        submit.setOnClickListener(v -> {
            if (list==null||list.size()==0) {
                return;
            }
            JSONArray jsonArray =new JSONArray();
            for (ServiceNeedBean.DataBean dataBean : list) {
                if (dataBean.isSelected()){
                    JSONObject jsonObject=new JSONObject();
                    try {
                        jsonObject.put("name",dataBean.getName());
                        jsonObject.put("id",dataBean.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                }
            }
            mPresenter.setServiceNeeds(jsonArray);

        });

    }

    @Override
    protected ServiceNeedsPresenter createPresenter() {
        return new ServiceNeedsPresenter();
    }


    @OnClick({R.id.iv_back, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    private List<ServiceNeedBean.DataBean> list;

    @Override
    public void onSuccess(ServiceNeedBean dataBean) {
        list = dataBean.getData();
        ServiceNeesdsAdapter.setList(dataBean.getData());
    }

    @Override
    public void onSuccessMsg(String msg) {
        finish();
        Toast.makeText(ServiceNeedsActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void err(String message) {
        Toast.makeText(ServiceNeedsActivity.this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void getToastString() {
        Toast.makeText(ServiceNeedsActivity.this,"最多选择4个",Toast.LENGTH_LONG).show();
    }

}
