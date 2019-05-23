package com.wangzijie.nutrition_user.ui.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChat;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.nutritionist.FriendAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.FriendBean;
import com.wangzijie.nutrition_user.contract.FriendContact;
import com.wangzijie.nutrition_user.presenter.FriendPresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActCreateType;
import com.wangzijie.nutrition_user.ui.act.nutritionist.FriendList;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author fanjiangpeng
 * 通讯录
 */
public class FriendFragment extends BaseFragment<FriendPresenter> implements FriendContact.View {
    @BindView(R.id.rcv)
    RecyclerView recycler;
    private FriendAdapter adapter;
    private List<FriendBean.DataBean> friendBeanList = new ArrayList<>();
    private FriendPresenter friendPresenter;

    public static FriendFragment getInstance() {
        return new FriendFragment();
    }

    @Override
    protected FriendPresenter createPresenter() {
        return new FriendPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_friends;
    }

    @Override
    protected void initData() {
        friendPresenter.getData(1);
    }


    @Override
    protected void initUI() {
        super.initUI();
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FriendAdapter(friendBeanList);
        recycler.setAdapter(adapter);
        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            FriendBean.DataBean bean = (FriendBean.DataBean) baseQuickAdapter.getItem(i);
            if (bean.getId() == 0) {
                JumpUtil.overlay(getActivity(), FriendList.class);
            } else if (bean.getId() == 1) {
                JumpUtil.overlay(getActivity(), ActCreateType.class);
            } else {
                startActivity(new Intent(getActivity(), EaseChat.class)
                        .putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE)
                        .putExtra(EaseConstant.EXTRA_USER_ID, bean.getId()));
            }
        });

    }


    private void getData() {
        FriendBean.DataBean friendBean = new FriendBean.DataBean();
        friendBean.setNickname("群聊");
        friendBean.setId(0);
        friendBeanList.add(friendBean);
        FriendBean.DataBean friendBean2 = new FriendBean.DataBean();
        friendBean2.setNickname("标签");
        friendBean2.setId(1);
        friendBeanList.add(friendBean2);
    }


    @Override
    public void DataSuss(FriendBean dataBean) {
        getData();
        friendBeanList.addAll(dataBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void DataErr(String err) {

    }
}
