package com.wangzijie.nutrition_user.ui.healthycompose;

import android.widget.EditText;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.SchemeFoodAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.DieticianWriteBean;
import com.wangzijie.nutrition_user.presenter.DieticianWriteElsePresenter;
import com.wangzijie.nutrition_user.utils.SchemeFood;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * @author fanjiangpeng
 *  撰写饮食计划Fragment
 */
public class SchemeComposeFoodFragment extends BaseFragment  {


    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.shucai_ed)
    EditText shucai_ed;
    @BindView(R.id.dadou_ed)
    EditText dadou_ed;
    @BindView(R.id.jidan_ed)
    EditText jidan_ed;
    @BindView(R.id.shuichang_ed)
    EditText shuichang_ed;
    @BindView(R.id.rou_ed)
    EditText rou_ed;
    @BindView(R.id.naiqin_ed)
    EditText naiqin_ed;
    @BindView(R.id.shuiguo_ed)
    EditText shuiguo_ed;
    @BindView(R.id.youzhi_ed)
    EditText youzhi_ed;
    @BindView(R.id.shui_ed)
    EditText shui_ed;


    public SchemeComposeFoodFragment() {
        // Required empty public constructor
    }


    @Override
    protected DieticianWriteElsePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_scheme_food_input;
    }

    @Override
    protected void initData() {
    }


    public DieticianWriteBean.FoodData getType(){

        DieticianWriteBean.FoodData foodData = new DieticianWriteBean.FoodData();
        foodData.type1 = "".equals(editText.getText().toString())?"0":editText.getText().toString();
        foodData.type2 = "".equals(shucai_ed.getText().toString())?"0":shucai_ed.getText().toString();
        foodData.type3 = "".equals(dadou_ed.getText().toString())?"0":dadou_ed.getText().toString();
        foodData.type4 = "".equals(jidan_ed.getText().toString())?"0":jidan_ed.getText().toString();
        foodData.type5 = "".equals(shuichang_ed.getText().toString())?"0":shuichang_ed.getText().toString();
        foodData.type6 = "".equals(rou_ed.getText().toString())?"0":rou_ed.getText().toString();
        foodData.type7 = "".equals(naiqin_ed.getText().toString())?"0":naiqin_ed.getText().toString();
        foodData.type8 = "".equals(shuiguo_ed.getText().toString())?"0":shuiguo_ed.getText().toString();
        foodData.type9 = "".equals(youzhi_ed.getText().toString())?"0":youzhi_ed.getText().toString();
        foodData.type10 = "".equals(shui_ed.getText().toString())?"0":shui_ed.getText().toString();

        return foodData;

    }


}
