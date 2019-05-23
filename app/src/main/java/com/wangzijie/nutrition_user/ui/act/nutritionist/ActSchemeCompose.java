package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.bean.DieticianWriteBean;
import com.wangzijie.nutrition_user.presenter.DieticianWriteElsePresenter;
import com.wangzijie.nutrition_user.ui.healthycompose.SchemeComposeFoodFragment;
import com.wangzijie.nutrition_user.ui.healthycompose.SchemeComposeSleepFragment;
import com.wangzijie.nutrition_user.ui.healthycompose.SchemeComposeStopFragment;
import com.wangzijie.nutrition_user.ui.healthycompose.SchemeComposeloveFragment;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.SharedPreferenceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 健康指导方案
 */
public class ActSchemeCompose extends BaseActivity<DieticianWriteElsePresenter> implements DieticianWriteElsePresenter.DieticianWriteElseView {

    @BindView(R.id.scheme_food)
    RadioButton schemeFood;
    @BindView(R.id.scheme_sleep)
    RadioButton schemeSleep;
    @BindView(R.id.scheme_stop)
    RadioButton schemeStop;
    @BindView(R.id.scheme_love)
    RadioButton schemeLove;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.release)
    TextView release;

    @BindView(R.id.start_time)
    LinearLayout start_time;

    @BindView(R.id.end_time)
    LinearLayout end_time;

    @BindView(R.id.starttime)
    TextView starttime;

    @BindView(R.id.endtime)
    TextView endtime;
    private SchemeComposeFoodFragment schemeComposeFoodFragment;
    private SchemeComposeSleepFragment schemeComposeSleepFragment;
    private SchemeComposeStopFragment schemeComposeStopFragment;
    private SchemeComposeloveFragment schemeComposeloveFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_scheme2;
    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();
        schemeComposeFoodFragment = new SchemeComposeFoodFragment();
        schemeComposeSleepFragment = new SchemeComposeSleepFragment();
        schemeComposeStopFragment = new SchemeComposeStopFragment();
        schemeComposeloveFragment = new SchemeComposeloveFragment();

        fragmentList.add(schemeComposeFoodFragment);
        fragmentList.add(schemeComposeSleepFragment);
        fragmentList.add(schemeComposeStopFragment);
        fragmentList.add(schemeComposeloveFragment);
    }

    @Override
    protected void initData() {
        selectFragment(0);

        start_time.setOnClickListener(v -> DisplayUtils.showFutureCalendarDialog(activity, starttime, null));
        end_time.setOnClickListener(v -> DisplayUtils.showFutureCalendarDialog(activity, endtime,null));

        release.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DieticianWriteBean.FoodData diet = schemeComposeFoodFragment.getType();
                String sleep = schemeComposeSleepFragment.getData();
                String sport = schemeComposeStopFragment.getData();
                String psychology = schemeComposeloveFragment.getData();
                String userId = (String) SharedPreferenceUtil.get(ActSchemeCompose.this, "userId", "");

                DieticianWriteBean dieticianWriteBean = new DieticianWriteBean();
                dieticianWriteBean.start_time = starttime.getText().toString();
                dieticianWriteBean.end_time = endtime.getText().toString();
                dieticianWriteBean.diet = diet;
                dieticianWriteBean.sleep = sleep;
                dieticianWriteBean.sport = sport;
                dieticianWriteBean.cmId = userId;
                dieticianWriteBean.psychology = psychology;

                if (!"年/月/日".equals(starttime.getText().toString())&&!"年/月/日".equals(endtime.getText().toString())&&(!"".equals(sleep)||!"".equals(sport)||!"".equals(psychology)||diet!=null)){

                    mPresenter.getDieticianWriteElse(dieticianWriteBean);

                }else{
                    Toast.makeText(activity,"请选择时间,并添加内容！",Toast.LENGTH_LONG).show();
                }


            }
        });




    }


    @Override
    protected DieticianWriteElsePresenter createPresenter() {
        return new DieticianWriteElsePresenter();
    }

    @OnClick({R.id.scheme_food, R.id.scheme_sleep, R.id.scheme_stop, R.id.scheme_love,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scheme_food:
                selectFragment(0);
                break;
            case R.id.scheme_sleep:
                selectFragment(1);
                break;
            case R.id.scheme_stop:
                selectFragment(2);
                break;
            case R.id.scheme_love:
                selectFragment(3);
                break;
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onDieticianWriteElse(String msg) {

        finish();
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void err(String message) {
        Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
    }
}
