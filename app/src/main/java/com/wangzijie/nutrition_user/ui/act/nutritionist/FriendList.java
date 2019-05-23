package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChat;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.nutritionist.GroupListAdapter;
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
 * 群聊
 */
public class FriendList extends BaseActivity implements GroupListAdapter.OnItemChildClickListener {
    @BindView(R.id.rcv)
    RecyclerView recyclerView;
    private List<EMGroup> emGroups = new ArrayList<>();
    private GroupListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_friend_list;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
        adapter = new GroupListAdapter(emGroups);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(FriendList.this);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    private void getData() {
        Observable.create((ObservableOnSubscribe<List<EMGroup>>) emitter -> {
            List<EMGroup> emGroupList = EMClient.getInstance().groupManager().getJoinedGroupsFromServer();
            emitter.onNext(emGroupList);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(emGroupList -> {
                    emGroups.addAll(emGroupList);
                    adapter.notifyDataSetChanged();
                }, throwable -> {
                    throwable.printStackTrace();
                    Log.e("IM", throwable.getMessage());
                });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        EMGroup emGroup = (EMGroup) baseQuickAdapter.getData().get(i);
        Intent intent = new Intent(FriendList.this, EaseChat.class);
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_GROUP);
        intent.putExtra(EaseConstant.EXTRA_USER_ID, emGroup.getGroupId());
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            getData();
        }
    }


    @OnClick({R.id.back, R.id.group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.group:
                startActivityForResult(
                        new Intent(FriendList.this, ActCreateGroup.class),RESULT_OK);
                break;
        }
    }
}
