package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.model.Userinfo;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.nutritionist.SelectAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author fanjiangpeng
 * 选择群成员
 */
public class ActSelectGroup extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recycler;

    private List<Userinfo> userinfoList = new ArrayList<>();
    private List<String> strings = new ArrayList<>();

    private SelectAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_select_group;
    }

    @Override
    protected void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectAdapter(userinfoList);
        recycler.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        getData();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.title_bar, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar:
                this.finish();
                break;
            case R.id.commit:
                getid();
                Intent intent = ActSelectGroup.this.getIntent();
                String[] array = (String[])strings.toArray(new String[strings.size()]);
                intent.putExtra("users",array);
                setResult(RESULT_OK,intent);
                ActSelectGroup.this.finish();
                break;
        }
    }

    private void getData(){
        Observable.create((ObservableOnSubscribe<List<String>>) emitter -> {
            List<String> usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            emitter.onNext(usernames);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(strings -> {
                    if (strings.size()>0){
                        final Userinfo userinfo = new Userinfo();
                        for (int i = 0; i < strings.size(); i ++){
                            userinfo.setUserId(strings.get(i));
                            userinfo.setSelect(false);
                            userinfoList.add(userinfo);
                        }
                        adapter.notifyDataSetChanged();
                        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
                            Userinfo userinfo1 = (Userinfo) baseQuickAdapter.getData().get(i);
                            if (userinfo1.isSelect()){
                                userinfoList.get(i).setSelect(false);
                                adapter.replaceData(userinfoList);
                                adapter.notifyDataSetChanged();
                            }else {
                                userinfoList.get(i).setSelect(true);
                                adapter.replaceData(userinfoList);
                                adapter.notifyDataSetChanged();
                            }

                        });
                    }

                }, throwable -> {
                    throwable.printStackTrace();
                    Log.e("IM",throwable.getMessage());
                });
    }

    private void getid(){
        for (int i = 0; i < userinfoList.size(); i ++){
            if (userinfoList.get(i).isSelect()){
                strings.add(userinfoList.get(i).getUserId());
            }
        }
    }
}
