package com.hyphenate.easeui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.widget.chatrow.EaseCustomChatRowProvider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author fanjiangpeng
 */
public class EaseChat extends AppCompatActivity {
    private EaseChatFragment chatFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_chat);
        chatFragment = new EaseChatFragment();
        //new出EaseChatFragment或其子类的实例
        String id = getIntent().getStringExtra(EaseConstant.EXTRA_USER_ID);
        int type = getIntent().getIntExtra(EaseConstant.EXTRA_CHAT_TYPE,0);
        //传入参数
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, type);
        args.putString(EaseConstant.EXTRA_USER_ID, id);
        chatFragment.setArguments(args);
        chatFragment.setChatFragmentHelper(new EaseChatFragment.EaseChatFragmentHelper() {
            @Override
            public void onSetMessageAttributes(EMMessage message) {

            }

            //跳转详情
            @Override
            public void onEnterToChatDetails(EMGroup group) {
                startActivity(new Intent(EaseChat.this,ActGroupDetails.class)
                        .putExtra(EaseConstant.EXTRA_USER_ID, group.getGroupId()));
            }

            @Override
            public void onAvatarClick(String username) {

            }

            @Override
            public void onAvatarLongClick(String username) {

            }

            @Override
            public boolean onMessageBubbleClick(EMMessage message) {
                return false;
            }

            @Override
            public void onMessageBubbleLongClick(EMMessage message) {

            }

            @Override
            public boolean onExtendMenuItemClick(int itemId, View view) {
                return false;
            }

            @Override
            public EaseCustomChatRowProvider onSetCustomChatRowProvider() {
                return null;
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.contanier, chatFragment).commit();
    }
}
