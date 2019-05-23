//package com.wangzijie.nutrition_user.ui.message;
//
//import android.os.Bundle;
//
//import com.hyphenate.easeui.EaseConstant;
//import com.hyphenate.easeui.ui.EaseChatFragment;
//import com.wangzijie.nutrition_user.R;
//import com.wangzijie.nutrition_user.base.BaseActivity;
//import com.wangzijie.nutrition_user.base.contract.BasePresenter;
//
///**
// * 会话界面
// * @author fanjiangpeng
// */
//public class EaseChat extends BaseActivity {
//    private EaseChatFragment chatFragment;
//    @Override
//    protected int getLayoutId() {
//        return R.layout.act_chat;
//    }
//
//    @Override
//    protected void initView() {
//        chatFragment = new EaseChatFragment();
//    }
//
//    @Override
//    protected void initData() {
//        //new出EaseChatFragment或其子类的实例
//        String id = getIntent().getStringExtra(EaseConstant.EXTRA_USER_ID);
//        int type = getIntent().getIntExtra(EaseConstant.EXTRA_CHAT_TYPE,0);
//        //传入参数
//        Bundle args = new Bundle();
//        args.putInt(EaseConstant.EXTRA_CHAT_TYPE,type);
//        args.putString(EaseConstant.EXTRA_USER_ID, id);
//        chatFragment.setArguments(args);
//        getSupportFragmentManager().beginTransaction().add(R.id.contanier, chatFragment).commit();
//    }
//
//    @Override
//    protected BasePresenter createPresenter() {
//        return null;
//    }
//}
