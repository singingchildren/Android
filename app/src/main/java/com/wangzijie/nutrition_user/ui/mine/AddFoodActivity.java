package com.wangzijie.nutrition_user.ui.mine;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.AsswaamwnrBean;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;
import com.wangzijie.nutrition_user.contract.AddFoodContract;
import com.wangzijie.nutrition_user.presenter.AddFoodPresenter;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.BuildConfig;

/**
 * 添加饮食Activity
 */
public class AddFoodActivity extends BaseActivity<AddFoodPresenter> implements AddFoodContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.shuichang_ed)
    EditText shuichangEd;
    @BindView(R.id.dadou_ed)
    EditText dadouEd;
    @BindView(R.id.shucai_ed)
    EditText shucaiEd;
    @BindView(R.id.jidan_ed)
    EditText jidanEd;
    @BindView(R.id.shuiguo_ed)
    EditText shuiguoEd;
    @BindView(R.id.rou_ed)
    EditText rouEd;
    @BindView(R.id.naiqin_ed)
    EditText naiqinEd;
    @BindView(R.id.youzhi_ed)
    EditText youzhiEd;
    @BindView(R.id.shui_ed)
    EditText shuiEd;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_food;
    }

    @Override
    protected void initView() {
        title.setText("添加饮食");
    }


    @Override
    protected void initData() {
        showNormal();
    }

    @Override
    protected AddFoodPresenter createPresenter() {
        return new AddFoodPresenter();
    }


    @OnClick({R.id.button6, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button6:
                mPresenter.selectData(editText, shuichangEd, dadouEd, shucaiEd, jidanEd, shuiguoEd, rouEd, naiqinEd, youzhiEd, shuiEd);

                break;
            case R.id.back:
                this.finish();
                break;
            default:
                break;
        }
    }


    @Override
    public void PutSuss(DietAssessmentBean bean) {

    }

    @Override
    public void PutErr(String err) {

    }

    @Override
    public void SelectSuss(String str1, String str2, String str3, String str4, String str5,
                           String str6, String str7, String str8, String str9, String str10) {
        AsswaamwnrBean bean = new AsswaamwnrBean();
        bean.setType1(str1);
        bean.setType2(str2);
        bean.setType3(str3);
        bean.setType4(str4);
        bean.setType5(str5);
        bean.setType6(str6);
        bean.setType7(str7);
        bean.setType8(str8);
        bean.setType9(str9);
        bean.setType10(str10);
        bean.setTime(getIntent().getExtras().getString("time"));
        Intent intent = new Intent(this, AssfoodcontentActivity.class);
        intent.putExtra("bean", bean);
        startActivity(intent);
        finish();
        if (BuildConfig.DEBUG)
            Log.d("AddFoodActivity", str1 + "/" + str2 + "/" + str3 + "/" + str4 + "/" + str5 + "/" + str6 + "/" + str7 + "/" + str8 + "/" + str9 + "/" + str10);

    }

    @Override
    public void SelectErr(String str) {
        ToastUtil.show(this,str);
    }

}
