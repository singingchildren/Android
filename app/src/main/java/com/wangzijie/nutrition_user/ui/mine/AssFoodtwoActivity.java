package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.bean.AsswaamwnrBean;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;
import com.wangzijie.nutrition_user.utils.devik.AppDavikActivityUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 查看饮食评估结果
 */
public class AssFoodtwoActivity extends BaseActivity {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.editText)
    TextView editText;
    @BindView(R.id.shuichang_ed)
    TextView shuichangEd;
    @BindView(R.id.dadou_ed)
    TextView dadouEd;
    @BindView(R.id.shucai_ed)
    TextView shucaiEd;
    @BindView(R.id.jidan_ed)
    TextView jidanEd;
    @BindView(R.id.shuiguo_ed)
    TextView shuiguoEd;
    @BindView(R.id.rou_ed)
    TextView rouEd;
    @BindView(R.id.naiqin_ed)
    TextView naiqinEd;
    @BindView(R.id.youzhi_ed)
    TextView youzhiEd;
    @BindView(R.id.shui_ed)
    TextView shuiEd;



    @BindView(R.id.cb1_food_ass_act)
    CheckBox cb1FoodAssAct;
    @BindView(R.id.cb2_food_ass_act)
    CheckBox cb2FoodAssAct;
    @BindView(R.id.cb3_food_ass_act)
    CheckBox cb3FoodAssAct;
    @BindView(R.id.cb4_food_ass_act)
    CheckBox cb4FoodAssAct;
    @BindView(R.id.cb5_food_ass_act)
    CheckBox cb5FoodAssAct;
    @BindView(R.id.cb6_food_ass_act)
    CheckBox cb6FoodAssAct;
    @BindView(R.id.cb7_food_ass_act)
    CheckBox cb7FoodAssAct;
    @BindView(R.id.cb8_food_ass_act)
    CheckBox cb8FoodAssAct;
    @BindView(R.id.cb9_food_ass_act)
    CheckBox cb9FoodAssAct;
    @BindView(R.id.cb10_food_ass_act)
    CheckBox cb10FoodAssAct;

    private AsswaamwnrBean data = new AsswaamwnrBean();
    private DietAssessmentBean.DataBean dataBean = new DietAssessmentBean.DataBean();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ass_foodtwo;
    }

    @Override
    protected void initView() {
        title.setText("查看结果");
    }

    @Override
    protected void initData() {
        showNormal();
        dataBean = (DietAssessmentBean.DataBean) getIntent().getSerializableExtra("bean");
        data = (AsswaamwnrBean) getIntent().getSerializableExtra("data");
        if (data != null) {
            editText.setText(data.getType1());
            shuichangEd.setText(data.getType2());
            dadouEd.setText(data.getType3());
            shucaiEd.setText(data.getType4());
            jidanEd.setText(data.getType5());
            shuiguoEd.setText(data.getType6());
            rouEd.setText(data.getType7());
            naiqinEd.setText(data.getType8());
            youzhiEd.setText(data.getType9());
            shuiEd.setText(data.getType10());
        }
        if (dataBean != null) {
            setCheckBoxType(cb1FoodAssAct,dataBean.getType1());
            setCheckBoxType(cb2FoodAssAct,dataBean.getType2());
            setCheckBoxType(cb3FoodAssAct,dataBean.getType3());
            setCheckBoxType(cb4FoodAssAct,dataBean.getType4());
            setCheckBoxType(cb5FoodAssAct,dataBean.getType5());
            setCheckBoxType(cb6FoodAssAct,dataBean.getType6());
            setCheckBoxType(cb7FoodAssAct,dataBean.getType7());
            setCheckBoxType(cb8FoodAssAct,dataBean.getType8());
            setCheckBoxType(cb9FoodAssAct,dataBean.getType9());
            setCheckBoxType(cb10FoodAssAct,dataBean.getType10());
        }
    }

    private void setCheckBoxType(CheckBox checkBox, String type) {
        checkBox.setText(type);
        if (type.equals("不合理")) {
            checkBox.setChecked(false);
        }else {
            checkBox.setChecked(true);
        }
    }


    @OnClick(R.id.back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                AppDavikActivityUtil.getScreenManager().clearActiivty();
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
