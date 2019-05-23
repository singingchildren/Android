package com.wangzijie.nutrition_user.ui.home;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.SeekAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.bean.SiteData;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//搜索框
public class SeekActivity extends BaseActivity {

    @BindView(R.id.fl_seek_act)
    FrameLayout frameLayoutSeek;
    @BindView(R.id.ll_seek_act)
    LinearLayout llSeekAct;
    @BindView(R.id.seek_huiimage)
    ImageView seekHuiimage;

    @BindView(R.id.seekRecycle)
    RecyclerView seekRecycle;
    @BindView(R.id.seek_con)
    ConstraintLayout seekMatter;

    @BindView(R.id.rb1_tab_top_seek_act)
    RadioButton rb1TabTopSeekAct;
    @BindView(R.id.rb2_tab_top_seek_act)
    RadioButton rb2TabTopSeekAct;
    @BindView(R.id.rb3_tab_top_seek_act)
    RadioButton rb3TabTopSeekAct;
    @BindView(R.id.rg_seek_activity)
    RadioGroup rgSeekActivity;
    @BindView(R.id.edt_seek_act)
    EditText edtSeekAct;
    @BindView(R.id.seek_toolbar)
    ConstraintLayout seekToolbar;
    @BindView(R.id.textView72)
    TextView textView72;
    @BindView(R.id.iv_delete_seek_act)
    ImageView imageView2;

    private SiteData seekdata;
    private ArrayList<SiteData> seeklist = new ArrayList<>();
    private SeekAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_seek;
    }

    @Override
    protected void initView() {

        seekdata = new SiteData();
        for (int i = 0; i < 8; i++) {
            seekdata.setRegion("优秀营养师");
            seeklist.add(seekdata);
        }
        adapter = new SeekAdapter(R.layout.item_site, seeklist, this);
        seekRecycle.setLayoutManager(new GridLayoutManager(this, 4));
        seekRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initData() {
        showNormal();
        //Andorid键盘按钮
        edtSeekAct.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            private String find;
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //判断是否是搜索键
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    find = edtSeekAct.getText().toString().trim();
                    if (TextUtils.isEmpty(find)) {
                        ToastUtil.show(SeekActivity.this, "请输入您想要搜索的关键字");
                    }
                    //  下面就是大家的业务逻辑
                    //  这里记得一定要将键盘隐藏了
                    DisplayUtils.hideKeyBoard(SeekActivity.this);
                    return true;
                }
                return false;
            }


        });


        //Edit的输入状态
        edtSeekAct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //输入状态
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.edt_seek_act, R.id.seek_huiimage,R.id.iv_delete_seek_act})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edt_seek_act:

                break;
            case R.id.seek_huiimage:
                finish();
                break;
            case R.id.iv_delete_seek_act:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        seeklist.clear();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.immobility_in, R.anim.below_out);
    }


}
