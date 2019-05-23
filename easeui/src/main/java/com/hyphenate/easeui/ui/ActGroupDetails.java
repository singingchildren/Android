package com.hyphenate.easeui.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.adapter.MemberAdatper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author fanjiangpeng
 */
public class ActGroupDetails extends AppCompatActivity {

    private TextView owner,groupname,gonggao;
    private RecyclerView recycler;
    private String groupId;
    private MemberAdatper adatper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_group_details);
        initView();
        groupId = getIntent().getStringExtra(EaseConstant.EXTRA_USER_ID);
        getdata();
    }

    private void getdata() {
        Observable.create(new ObservableOnSubscribe<EMGroup>() {
            @Override
            public void subscribe(ObservableEmitter<EMGroup> emitter) throws Exception {
                //根据群组ID从服务器获取群组基本信息
                EMGroup group = EMClient.getInstance().groupManager().getGroupFromServer(groupId);
                emitter.onNext(group);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EMGroup>() {
                    @Override
                    public void accept(EMGroup group) throws Exception {
                        owner.setText(group.getOwner());
                        groupname.setText(group.getGroupName());
                        List<String> members = group.getMembers();
                        adatper = new MemberAdatper(members);
                        recycler.setAdapter(adatper);
                        adatper.notifyDataSetChanged();
                        gonggao.setText(group.getAnnouncement());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("Im",throwable.getMessage());
                    }
                });
    }

    private void initView() {
        owner = findViewById(R.id.owner);
        groupname = findViewById(R.id.groupname);
        gonggao = findViewById(R.id.gonggao);
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this,3));
    }
}
