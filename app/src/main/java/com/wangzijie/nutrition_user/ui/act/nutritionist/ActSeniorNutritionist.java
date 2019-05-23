package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.view.View;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 去申请高级营养师
 *
 * @author fanjiangpeng
 */
public class ActSeniorNutritionist extends BaseActivity {
    @BindView(R.id.tv1_go_apply_dietician)
    TextView tv1GoApplyDietician;
    @BindView(R.id.tv2_go_apply_dietician)
    TextView tv2GoApplyDietician;
    @BindView(R.id.tv3_go_apply_dietician)
    TextView tv3GoApplyDietician;
    @BindView(R.id.release)
    TextView release;
    @Override
    protected int getLayoutId() {
        return R.layout.act_senior_nutritionist;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        int astatus = getIntent().getExtras().getInt("astatus");
        switch (astatus) {
            case 0:
                DisplayUtils.visibleView(tv1GoApplyDietician);
                DisplayUtils.goneView(tv2GoApplyDietician, tv3GoApplyDietician);
                break;
            case 1:
                DisplayUtils.visibleView(tv2GoApplyDietician);
                DisplayUtils.goneView(tv1GoApplyDietician, tv3GoApplyDietician,release);
                break;
            case -1:
                DisplayUtils.visibleView(tv3GoApplyDietician);
                DisplayUtils.goneView(tv1GoApplyDietician, tv2GoApplyDietician,release);
                break;
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.back, R.id.release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.release:
                JumpUtil.overlay(this, ActSeniorDietitianApply.class);
                break;
        }
    }

}
