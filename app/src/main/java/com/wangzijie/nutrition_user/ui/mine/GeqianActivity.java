package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class GeqianActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.commit)
    TextView commit;
    @BindView(R.id.et_asign)
    EditText etAsign;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_geqian;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.back, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.commit:
                if (PwdCheckUtil.selectViewData(etAsign)) {
                    ToastUtil.show(this, "请输入个性签名!");
                    return;
                } else {
                    //提交接口
                }
                break;
        }
    }
}
