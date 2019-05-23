package com.wangzijie.nutrition_user.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.MyNutritionistAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.MyDietitianBean;
import com.wangzijie.nutrition_user.ui.mine.HealthGuidelinesActivity;
import com.wangzijie.nutrition_user.ui.mine.HealthRecordActivity;
import com.wangzijie.nutrition_user.ui.mine.MyAssessActivity;
import com.wangzijie.nutrition_user.ui.mine.MyVipActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * 我的营养师Fragment
 */
public class MyNutritionistFragment extends BaseFragment {


    @BindView(R.id.rcv_my_nutritionist_message_fragment)
    RecyclerView rcvMyNutritionistMessageFragment;
    private ArrayList<MyDietitianBean.DataBean> list;
    private MyNutritionistAdapter adapter;

    public MyNutritionistFragment() {

    }

    public static MyNutritionistFragment getInstance() {
        return new MyNutritionistFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_nutritionist_my;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        getData();
        list = new ArrayList<>();

        adapter = new MyNutritionistAdapter(R.layout.item_my_nutritionist, list);

        LinearLayoutManager manager = new LinearLayoutManager(myApplication);
        rcvMyNutritionistMessageFragment.setNestedScrollingEnabled(false);
        rcvMyNutritionistMessageFragment.setLayoutManager(manager);
        rcvMyNutritionistMessageFragment.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view, i)->{
            MyDietitianBean.DataBean bean = list.get(i);
            Bundle bundle=new Bundle();
            bundle.putString("dietitianName", bean.getRealname());
            bundle.putString("id", bean.getId());
            JumpUtil.overlay(getContext(), More_DetailsActivity.class, bundle);
        });
    }

    private void getData() {
        ApiStore.getService()
                .getMyDietitian(RequestBodyBuilder.objBuilder().build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyDietitianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyDietitianBean myDietitianBean) {
                        if (myDietitianBean.isSuccess()) {
                            list.addAll(myDietitianBean.getData());
                            adapter.notifyDataSetChanged();
                        }else {
                            Toast.makeText(activity, myDietitianBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MyNutritionistFG,ljq", e.getMessage());
                        Toast.makeText(activity, "我的营养师获取失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    @OnClick({R.id.btn4_my_nutritionist_message_fragment,R.id.btn1_my_nutritionist_message_fragment, R.id.btn2_my_nutritionist_message_fragment, R.id.btn3_my_nutritionist_message_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1_my_nutritionist_message_fragment:
                JumpUtil.overlay(getContext(), HealthGuidelinesActivity.class);//健康指导方案
                break;
            case R.id.btn2_my_nutritionist_message_fragment:
                JumpUtil.overlay(getContext(), MyVipActivity.class);//会员手册
                break;
            case R.id.btn3_my_nutritionist_message_fragment:
                JumpUtil.overlay(getActivity(), HealthRecordActivity.class);//我的健康档案
                break;
            case R.id.btn4_my_nutritionist_message_fragment:
                JumpUtil.overlay(getContext(), MyAssessActivity.class);//我的评估报告
                break;
        }
    }
}
