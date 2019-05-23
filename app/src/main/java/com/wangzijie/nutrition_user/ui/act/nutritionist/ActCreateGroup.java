package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;

import butterknife.BindView;

/**
 * @author fanjiangpeng
 * 创建群聊
 */
public class ActCreateGroup extends BaseActivity {
    @BindView(R.id.etgroupname)
    EditText etgroupname;
    @BindView(R.id.etIntroduction)
    TextView etIntroduction;

    private String groupName,desc;
    private String allMembers[];

    @Override
    protected int getLayoutId() {
        return R.layout.act_create_group;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


//    @OnClick({R.id.add, R.id.commit})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.add:
//                allMembers = null;
//                Intent intent = new Intent(ActCreateGroup.this, ActSelectGroup.class);
//                startActivityForResult(intent,0);
//                break;
//            case R.id.commit:
//                if (selectData()){
//                    groupName = PwdCheckUtil.getViewData(etgroupname);
//                    desc = "";
//                    /**
//                     * 创建群组
//                     * @param groupName 群组名称
//                     * @param desc 群组简介
//                     * @param allMembers 群组初始成员，如果只有自己传空数组即可
//                     * @param reason 邀请成员加入的reason
//                     * @param option 群组类型选项，可以设置群组最大用户数(默认200)及群组类型@see {@link EMGroupStyle}
//                     *               option.inviteNeedConfirm表示邀请对方进群是否需要对方同意，默认是需要用户同意才能加群的。
//                     *               option.extField创建群时可以为群组设定扩展字段，方便个性化订制。
//                     * @return 创建好的group
//                     * @throws HyphenateException
//                     */
//                    Observable.create((ObservableOnSubscribe<EMGroup>) emitter -> {
//                        EMGroupOptions option = new EMGroupOptions();
//                        option.maxUsers = 200;
//                        option.style = EMGroupManager.EMGroupStyle.EMGroupStylePrivateOnlyOwnerInvite;
//                        EMGroup emGroup = EMClient.getInstance().groupManager().createGroup(groupName, desc, allMembers, null, option);
//                        emitter.onNext(emGroup);
//                    }).subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(emGroup -> {
//                                startActivity(new Intent(ActCreateGroup.this, EaseChat.class)
//                                        .putExtra(EaseConstant.EXTRA_CHAT_TYPE,EaseConstant.CHATTYPE_GROUP)
//                                        .putExtra(EaseConstant.EXTRA_USER_ID, emGroup.getGroupId()));
//                                ActCreateGroup.this.finish();
//                            }, throwable -> {
//                                throwable.printStackTrace();
//                                Log.e("IM",throwable.getMessage());
//                            });
//                }
//                break;
//                default:
//                    break;
//        }
//    }

    private boolean selectData(){
        if (PwdCheckUtil.selectViewData(etgroupname)){
            Toast.makeText(this, "请输入群聊名称！", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (allMembers.length == 0){
            Toast.makeText(this, "请选择群成员！", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            allMembers = bundle.getStringArray("users");
        }
    }
}
