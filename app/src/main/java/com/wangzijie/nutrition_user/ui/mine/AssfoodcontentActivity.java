package com.wangzijie.nutrition_user.ui.mine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.AddFoodContract;
import com.wangzijie.nutrition_user.model.bean.AsswaamwnrBean;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;
import com.wangzijie.nutrition_user.presenter.AddFoodPresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加饮食二级页面
 */
public class AssfoodcontentActivity extends BaseActivity<AddFoodPresenter> implements AddFoodContract.View {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.assfoodcon)
    ConstraintLayout assfoodcon;
    @BindView(R.id.check_boy)
    ImageView checkBoy;
    @BindView(R.id.assfoodcontent_ed)
    EditText age;
    @BindView(R.id.check_gril)
    ImageView checkGril;
    @BindView(R.id.pregnancy)
    TextView pregnancy;
    private ArrayList<String> strings;
    private ArrayAdapter<String> adapter;

    private AsswaamwnrBean dataBean;

    private int Gender = 0;
    private int gestation = 0;
    private ProgressDialog waitingDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_assfoodcontent;
    }

    @Override
    protected void initView() {
        dataBean = (AsswaamwnrBean) getIntent().getSerializableExtra("bean");
        title.setText("添加饮食");
        strings = new ArrayList<>();
        strings.add("无");
        strings.add("孕早期");
        strings.add("孕中期");
        strings.add("孕晚期");


        //适配器
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strings);

        //设置样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //加载适配器
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gestation = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected AddFoodPresenter createPresenter() {
        return new AddFoodPresenter();
    }


    @OnClick({R.id.iv_back, R.id.assfoodcon, R.id.check_boy, R.id.check_gril})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.assfoodcon:
                if (PwdCheckUtil.selectViewData(age)) {
                    Toast.makeText(myApplication, "请输入年龄", Toast.LENGTH_SHORT).show();
                    return;
                }
                waitingDialog = DisplayUtils.showWaitingDialog(this, "等待上传");
                mPresenter.putData(dataBean.getType1(), dataBean.getType2(), dataBean.getType3(), dataBean.getType4(),
                        dataBean.getType5(), dataBean.getType6(), dataBean.getType7(), dataBean.getType8(), dataBean.getType9(),
                        dataBean.getType10(), PwdCheckUtil.getViewData(age), Gender, gestation,dataBean.getTime());
                break;
            //这家伙代码写的秀的飞起啊
            case R.id.check_boy:
                checkBoy.setImageDrawable(getResources().getDrawable(R.drawable.boyblue));
                checkGril.setImageDrawable(getResources().getDrawable(R.drawable.gril));
                Gender = 0;
                pregnancy.setVisibility(View.GONE);
                spinner.setVisibility(View.GONE);
                break;
            case R.id.check_gril:
                checkBoy.setImageDrawable(getResources().getDrawable(R.drawable.boy));
                checkGril.setImageDrawable(getResources().getDrawable(R.drawable.grilred));
                pregnancy.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                Gender = 1;
                break;
            default:
                break;
        }
    }

    @Override
    public void PutSuss(DietAssessmentBean bean) {
        waitingDialog.dismiss();
        Intent intent = new Intent(AssfoodcontentActivity.this, AssFoodtwoActivity.class);
        intent.putExtra("bean", bean.getData());
        intent.putExtra("data", dataBean);
        startActivity(intent);
        finish();
    }

    @Override
    public void PutErr(String err) {
        waitingDialog.dismiss();
        Toast.makeText(myApplication, "提交失败"+err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SelectSuss(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {

    }

    @Override
    public void SelectErr(String str) {

    }
}
