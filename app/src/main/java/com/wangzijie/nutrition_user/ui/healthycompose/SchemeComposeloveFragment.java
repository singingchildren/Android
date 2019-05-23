package com.wangzijie.nutrition_user.ui.healthycompose;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.presenter.DieticianWriteElsePresenter;
import com.wangzijie.nutrition_user.utils.DisplayUtils;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author fanjiangpeng
 * 撰写心理计划Fragment
 */
public class SchemeComposeloveFragment extends BaseFragment<DieticianWriteElsePresenter> implements DieticianWriteElsePresenter.DieticianWriteElseView {


    @BindView(R.id.editText8)
    EditText editText8;


    public SchemeComposeloveFragment() {
        // Required empty public constructor
    }

    @Override
    protected DieticianWriteElsePresenter createPresenter() {
        return new DieticianWriteElsePresenter();
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_compose_scheme_sleep;
    }

    @Override
    protected void initData() {

    }

    public String getData(){
        if (editText8!=null){
            return editText8.getText().toString();
        }else{
            return "";
        }
    }

    @Override
    public void onDieticianWriteElse(String msg) {

    }

    @Override
    public void err(String message) {
    }
}
