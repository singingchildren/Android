package com.wangzijie.nutrition_user.ui.message;

import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.chatui.ui.ChatActivity;
import com.wangzijie.nutrition_user.chatui.ui.ContactListFragment;
import com.wangzijie.nutrition_user.chatui.ui.ConversationListFragment;
import com.wangzijie.nutrition_user.ui.home.MyNutritionistFragment;
import com.wangzijie.nutrition_user.weight.MyTabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 消息Fragment
 */
public class Fragment_message extends BaseFragment {
    protected List<Fragment> fragmentList = new ArrayList<>();
    protected int lastIndex;
    @BindView(R.id.tab)
    MyTabLayout tab;
    private ArrayList<String> tablist = new ArrayList<>();
    private List<Fragment> mFragmentList;
    private ConversationListFragment easeConversationListFragment;
    private ContactListFragment contactListFragment;
    private BaseFragment thirdFragment;
    private ViewPager mVp;
    public static Fragment_message getInstance() {
        return new Fragment_message();
    }

//    /**
//     * 设置默认选中fragment
//     *
//     * @param index 碎片fragment
//     */
//    protected void selectFragment(int index) {
//        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//        Fragment currentFragment = fragmentList.get(index);
//        Fragment lastFragment = fragmentList.get(lastIndex);
//        lastIndex = index;
//        ft.hide(lastFragment);
//        if (!currentFragment.isAdded()) {
//            getActivity().getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
//            ft.add(R.id.frame, currentFragment);
//        }
//        ft.show(currentFragment);
//        ft.commitAllowingStateLoss();
//    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.act_message;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {
        super.initUI();
        //添加标题
        initTitle();
        //添加fragment
        initFragment();
        //设置适配器
        mVp = getView().findViewById(R.id.mVp);
        mVp.setAdapter(new MessageFragmentPageAdapter(getChildFragmentManager(), mFragmentList, tablist));
        //将tablayout与fragment关联
        tab.setupWithViewPager(mVp);
        mVp.setOffscreenPageLimit(3);

        getContact();
//        //设置item点击事件
//        contactListFragment.setContactListItemClickListener(
//                user -> startActivity(
//                        new Intent(getContext(), EaseChat.class)
//                                .putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE)
//                                .putExtra(EaseConstant.EXTRA_USER_ID, user.getUsername())));

        EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {

            @Override
            public void onContactInvited(String username, String reason) {
                //收到好友邀请

            }

            @Override
            public void onFriendRequestAccepted(String s) {

            }

            @Override
            public void onFriendRequestDeclined(String s) {

            }

            @Override
            public void onContactDeleted(String username) {
                //被删除时回调此方法
                new Thread() {//需要在子线程中调用
                    @Override
                    public void run() {
                        //需要设置联系人列表才能启动fragment
                        getContact();
                        contactListFragment.refresh();
                    }
                }.start();
            }


            @Override
            public void onContactAdded(String username) {
                //增加了联系人时回调此方法
                new Thread() {//需要在子线程中调用
                    @Override
                    public void run() {
                        //需要设置联系人列表才能启动fragment
                        getContact();
                        contactListFragment.refresh();
                    }
                }.start();

            }
        });
        easeConversationListFragment.setConversationListItemClickListener(
                conversation -> {
                    startActivity(new Intent(getActivity(), ChatActivity.class)
                            .putExtra(EaseConstant.EXTRA_CHAT_TYPE, conversation.getType())
                            .putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));
                });

    }

    private void initTitle(){

        tablist.add("消息");
        tablist.add("通信录");
        if (myApplication.globalData.isNutritionist()) {
            tablist.add("用户档案");
        } else {
            tablist.add("我的营养师");
        }

        tab.setTitle(tablist);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initFragment() {
        easeConversationListFragment = ConversationListFragment.getInstance();
        contactListFragment = ContactListFragment.getInstance();
        if (myApplication.globalData.isNutritionist()) {
            thirdFragment = FragmentUserFile.getInstance();
        } else {
            thirdFragment = MyNutritionistFragment.getInstance();

        }
        mFragmentList = new ArrayList<>();
        mFragmentList.add(easeConversationListFragment);//会话列表
        mFragmentList.add(contactListFragment);//联系人列表
        mFragmentList.add(thirdFragment);
    }


    private void getContact() {
        Observable.create((ObservableOnSubscribe<Map<String, EaseUser>>) emitter -> {
            Map<String, EaseUser> map = new HashMap<>();
            List<String> userNames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            for (String userId : userNames) {
                map.put(userId, new EaseUser(userId));
            }
            emitter.onNext(map);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stringEaseUserMap -> {
                    //需要设置联系人列表才能启动fragment
                    contactListFragment.setContactsMap(stringEaseUserMap);
                    contactListFragment.refresh();
                }, throwable -> {
                    throwable.printStackTrace();
                    Log.e("IM", throwable.getMessage());
                });
    }
}
