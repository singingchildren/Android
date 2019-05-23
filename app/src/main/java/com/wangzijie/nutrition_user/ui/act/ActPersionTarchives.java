package com.wangzijie.nutrition_user.ui.act;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActSchemeActivity;
import com.wangzijie.nutrition_user.ui.mine.Act_History;
import com.wangzijie.nutrition_user.ui.mine.Act_Personal_Documents;
import com.wangzijie.nutrition_user.ui.mine.MyAssessActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 营养师端->消息->用户档案->档案Act
 *
 * @author fanjiangpeng
 */
public class ActPersionTarchives extends BaseActivity {
    @BindView(R.id.tv_abou_us)
    TextView file;
    @BindView(R.id.tv_verison)
    TextView tvVerison;
    @BindView(R.id.presentation)
    TextView presentation;
    @BindView(R.id.guidance)
    TextView guidance;

    @Override
    protected int getLayoutId() {
        return R.layout.act_persion_tarchives;
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


    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }


    @OnClick({R.id.tv_abou_us, R.id.tv_verison, R.id.presentation, R.id.guidance})
    public void onViewClicked(View view) {
        Bundle bundle=new Bundle();
        switch (view.getId()) {
            //个人文档
            case R.id.tv_abou_us:
                JumpUtil.overlay(this, Act_Personal_Documents.class);
                break;
            //病例和体检报告
            case R.id.tv_verison:
                JumpUtil.overlay(this, Act_History.class);
                break;
            //评估报告
            case R.id.presentation:
                bundle.putString("title", "评估报告");
                JumpUtil.overlay(this, MyAssessActivity.class, bundle);//评估报告
                break;
            //健康指导方案
            case R.id.guidance:
                JumpUtil.overlay(this, ActSchemeActivity.class);
                break;
            default:
                break;
        }
    }
}