package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 健康档案
 *
 * @author fanjiangpeng
 */
public class HealthRecordActivity extends BaseActivity {
    @BindView(R.id.home_healthimage)
    ImageView homeHealthimage;
    @BindView(R.id.upload_document)
    TextView uploadDocument;
    @BindView(R.id.update_case)
    TextView updateCase;

    @Override
    protected int getLayoutId() {
        return R.layout.act_health_records;
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


    @OnClick({R.id.upload_document, R.id.update_case,R.id.home_healthimage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.upload_document://个人文档
                JumpUtil.overlay(this,Act_Personal_Documents.class);
                break;
            case R.id.update_case://病例和体检报告历史记录
                JumpUtil.overlay(this,Act_History.class);
                break;
            case R.id.home_healthimage:
                this.finish();
                break;
                default:
                    break;
        }
    }
}
