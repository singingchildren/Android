package com.wangzijie.nutrition_user.ui.home;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.CustomerServiceActivity;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.UserInfo;
import com.wangzijie.nutrition_user.presenter.PersonageDetailsPresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActJoinStudio;
import com.wangzijie.nutrition_user.ui.mine.Act_Amend;
import com.wangzijie.nutrition_user.ui.mine.Act_Asign;
import com.wangzijie.nutrition_user.ui.mine.Act_Change_Name;
import com.wangzijie.nutrition_user.ui.mine.Act_Collection;
import com.wangzijie.nutrition_user.ui.mine.Act_Persion;
import com.wangzijie.nutrition_user.ui.mine.Act_about_us;
import com.wangzijie.nutrition_user.ui.mine.MyDingActivity;
import com.wangzijie.nutrition_user.ui.mine.ServiceNeedsActivity;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_PAY;
import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;

/**
 * 我的
 *
 * @author
 */
public class Fragment_mine extends BaseFragment<PersonageDetailsPresenter> implements PersonageDetailsPresenter.PersonageDetailsPresenterView {


    @BindView(R.id.service)
    ImageView service;
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.tv_logo_authentication)
    TextView tvLogoAuthentication;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.Asign)
    TextView Asign;
    @BindView(R.id.compile)
    TextView compile;
    @BindView(R.id.iv_logo_vip_mine)
    ImageView ivLogoVipMine;
    @BindView(R.id.tv_vip_time)
    TextView tvVipTime;
    @BindView(R.id.iv_logo_vip_mine2)
    ImageView ivLogoVipMine2;
    @BindView(R.id.tv_vip_time2)
    TextView tvVipTime2;
    @BindView(R.id.tv1_mine)
    TextView tv1Mine;
    @BindView(R.id.iv1_mine)
    ImageView iv1Mine;
    @BindView(R.id.tv2_mine)
    TextView tv2Mine;
    @BindView(R.id.tv_collect_mine)
    TextView tvCollectMine;
    @BindView(R.id.iv_collect_mine)
    ImageView ivCollectMine;
    @BindView(R.id.tv_code_mine)
    TextView tvCodeMine;
    @BindView(R.id.tv_import_mine)
    TextView tvImportMine;
    @BindView(R.id.iv_import_mine)
    ImageView ivImportMine;
    @BindView(R.id.tv_about_us_mine)
    TextView tvAboutUsMine;
    @BindView(R.id.tv_versions_mine)
    TextView tvVersionsMine;
    @BindView(R.id.tv_account_mine)
    TextView tvAccountMine;
    @BindView(R.id.tv_phone_mine)
    TextView tvPhoneMine;
    private UserInfo.DataBean userInfo;
    private boolean isErr;
    private String newAvatar;

    public Fragment_mine() {
    }

    /**
     * 复制文本到剪切板
     *
     * @param context
     * @param text    要复制的文本
     */
    public static void copyToClipboard(Context context, String text) {
        ClipboardManager clip = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clip.getPrimaryClip(); // 粘贴
        clip.setPrimaryClip(ClipData.newPlainText("text", text)); // 复制
        Toast.makeText(context, "已复制邀请码到剪切板", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected PersonageDetailsPresenter createPresenter() {
        return new PersonageDetailsPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mine;
    }

    public void getData() {
        mPresenter.getUserDetails();
    }

    private void setData() {
        if (!TextUtils.isEmpty(myApplication.userInfo.getCode())) {
            tvCodeMine.setText(activity.getString(R.string.invitation_code
                    , myApplication.userInfo.getCode()));
        }
        tvVersionsMine.setText(activity.getString(R.string.version_updating
                , myApplication.globalData.isVersion()));
        Glide.with(this)
                .asBitmap()
                .load(userInfo.getAvatar())
                .error(R.drawable.my3)
                .into(new MyGlideHeaderLoader(head, getActivity()));
        if (!TextUtils.isEmpty(userInfo.getRealname())) {
            username.setText(userInfo.getRealname());
        }
        if (!TextUtils.isEmpty(userInfo.getDescr())) {
            Asign.setText(userInfo.getDescr());
        }

        if (myApplication.globalData.isNutritionist()) {
            if (userInfo.getDcAuthStatus().equals("去认证"))
                tvLogoAuthentication.setClickable(true);
            else
                tvLogoAuthentication.setClickable(false);
            tvLogoAuthentication.setText(userInfo.getDcAuthStatus());
            ivLogoVipMine2.setVisibility(View.GONE);
            tvVipTime2.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(myApplication.userInfo.getDcAuthCertTime())) {
                //判断用户是否有两种会员，显示第二组VIP标志
                ivLogoVipMine.setVisibility(View.VISIBLE);
                tvVipTime.setVisibility(View.VISIBLE);
                tvVipTime.setText(myApplication.userInfo.getDcAuthCertTime());
            } else {
                ivLogoVipMine.setVisibility(View.GONE);
                tvVipTime.setVisibility(View.GONE);
            }
        } else {
            if (!TextUtils.isEmpty(myApplication.userInfo.getYearCertTime())) {
                //判断用户是否有两种会员，显示第二组VIP标志
                ivLogoVipMine.setVisibility(View.VISIBLE);
                tvVipTime.setVisibility(View.VISIBLE);
                tvVipTime.setText(myApplication.userInfo.getYearCertTime());
            } else {
                ivLogoVipMine.setVisibility(View.INVISIBLE);
                tvVipTime.setVisibility(View.INVISIBLE);
            }
            if (!TextUtils.isEmpty(myApplication.userInfo.getCusCertTime())) {
                //判断用户是否有两种会员，显示第二组VIP标志
                ivLogoVipMine2.setVisibility(View.VISIBLE);
                tvVipTime2.setVisibility(View.VISIBLE);
                tvVipTime2.setText(myApplication.userInfo.getCusCertTime());
            } else {
                ivLogoVipMine2.setVisibility(View.INVISIBLE);
                tvVipTime2.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void initData() {
        getData();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isErr) {
            getData();
        }
    }

    @Override
    protected void initUI() {
        if (myApplication.globalData.isNutritionist()) {
            DisplayUtils.goneView(tv1Mine, iv1Mine);
            tv2Mine.setText(activity.getString(R.string.join_store));
            ivLogoVipMine.setImageResource(R.drawable.icon_time);
            tvLogoAuthentication.setVisibility(View.VISIBLE);
        } else {
            tv1Mine.setText(activity.getString(R.string.my_order));
            tv2Mine.setText(activity.getString(R.string.service_needs));
            ivLogoVipMine.setImageResource(R.drawable.huiyuan);
        }
        DisplayUtils.goneView(tvCollectMine, ivCollectMine);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT
                && requestCode == REQUEST_CODE_SELECT && data != null) {
            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            if (images.size() > 0) {
                OssServiceUtil.upload(".jpe", images, new OssServiceUtil.CallBack1() {

                    @Override
                    public void ossUploadSucceed(ArrayList<String> urlList) {
                        newAvatar = urlList.get(0);
                        mPresenter.changeProfile("", urlList.get(0), "", "", "", "", "", "");
                    }

                    @Override
                    public void ossUploadFailed(String error) {
                        Toast.makeText(activity, "上传头像失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if (requestCode == REQUEST_CODE_PAY//支付成功回来
                && resultCode == Constant.RESULT_CODE_PAY) {
            Toast.makeText(activity, "已支付,请等待审核", Toast.LENGTH_SHORT).show();
            tvLogoAuthentication.setClickable(false);
            tvLogoAuthentication.setText("审核中");
        } else {
            initData();
        }
    }

    @OnClick({R.id.tv_logo_authentication, R.id.service, R.id.head, R.id.username, R.id.Asign, R.id.compile, R.id.tv_phone_mine,
            R.id.tv1_mine, R.id.tv2_mine, R.id.tv_collect_mine, R.id.tv_code_mine,
            R.id.tv_import_mine, R.id.tv_about_us_mine, R.id.tv_versions_mine, R.id.tv_account_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.service://客服
                JumpUtil.overlay(getContext(), CustomerServiceActivity.class);
                break;
            case R.id.head://头像
                ImagePicker.getInstance().setSelectLimit(1);
                Intent intent1 = new Intent(getActivity(), ImageGridActivity.class);
                startActivityForResult(intent1, REQUEST_CODE_SELECT);
                break;
            case R.id.username://用户名
                JumpUtil.startForResult(this, Act_Change_Name.class, 1, null);
                break;
            case R.id.Asign://个性签名
                JumpUtil.startForResult(this, Act_Asign.class, 1, null);
                break;
            case R.id.compile://编辑
                JumpUtil.startForResult(this, Act_Persion.class, 1, null);
                break;

            case R.id.tv1_mine://我的碎片中的第1个选项（用户端和营养师端会不同）
                if (myApplication.globalData.isNutritionist())
                    tv1Mine.setVisibility(View.GONE);//营养师少一下项
                else
                    JumpUtil.overlay(getActivity(), MyDingActivity.class);//我的订单
                break;
            case R.id.tv2_mine://我的碎片中的第2个选项（用户端和营养师端会不同）
                if (myApplication.globalData.isNutritionist())
                    JumpUtil.overlay(getActivity(), ActJoinStudio.class);//加入工作室
                else
                    JumpUtil.overlay(getActivity(), ServiceNeedsActivity.class);//服务需求
                break;
            case R.id.tv_collect_mine://跳转我的收藏
                JumpUtil.overlay(getActivity(), Act_Collection.class);
                break;
            case R.id.tv_code_mine://复制我的邀请码
                copyToClipboard(activity, myApplication.userInfo.getCode());
                break;
            case R.id.tv_import_mine://输入邀请码
                showInputDialog();
                break;
            case R.id.tv_about_us_mine://关于我们
                JumpUtil.overlay(getActivity(), Act_about_us.class);
                break;
            case R.id.tv_versions_mine://版本更新
                ToastUtil.show(getActivity(), "已是最新版本");
                break;
            case R.id.tv_account_mine://切换账号
                DisplayUtils.showNormalDialog(getContext(), "是否要切换账号?", "",
                        (dialog, which) -> {
                            jumpLogin();
                        });
                break;
            case R.id.tv_phone_mine://更改绑定我的手机号码
                JumpUtil.overlay(getActivity(), Act_Amend.class);
                break;
            case R.id.tv_logo_authentication://营养师端去认证
                if (userInfo == null) {
                    Toast.makeText(activity, "数据异常,请稍后再试!", Toast.LENGTH_SHORT).show();
                    return;
                }
                generateOrder(userInfo.getDcAuthPrice(), "servicefee");
                break;

        }
    }

    public void generateOrder(String price, String type) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .add("price", price)
                .add("type", type)
                .build();

        ApiStore.getService()
                .generateOrder(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean<OrderBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean<OrderBean> dataBean) {
                        if (dataBean.isSuccess()) {
                            JumpUtil.jumpMoney(getActivity(), dataBean.getData());
                        } else
                            moreErr(dataBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        moreErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void moreErr(String message) {
        ToastUtil.show(getContext(), message);
    }


    private void showInputDialog() {
        /*@setView 装入一个EditView
         */
        final EditText editText = new EditText(activity);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(activity);
        inputDialog.setTitle("请输入邀请码").setView(editText);
        inputDialog.setPositiveButton("确定",
                (dialog, which) -> {
                    String s = editText.getText().toString();
                    if (TextUtils.isEmpty(s)) {
                        Toast.makeText(activity, "邀请码不能为空",
                                Toast.LENGTH_SHORT).show();
                    } else if (s.equals(myApplication.userInfo.getCode())) {
                        Toast.makeText(activity, "不能输入自己的邀请码",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(activity,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();

                        mPresenter.getInvitationCodeData(editText.getText().toString());

                    }
                });
        inputDialog.setNegativeButton("取消", null).show();
    }


    @Override
    public void PersonageDetailsSuccess(UserInfo userInfo) {
        isErr = false;
        Fragment_mine.this.userInfo = userInfo.getData();
        myApplication.userInfo = userInfo.getData();
        setData();
    }

    @Override
    public void PersonageDetailsError(String msg) {
        isErr = true;
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void PersonageDetailsSuccessMsg(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void putSuess(String msg) {
        if (!TextUtils.isEmpty(newAvatar)) {
            Glide.with(this)
                    .asBitmap()
                    .load(newAvatar)
                    .error(R.drawable.my)
                    .into(new MyGlideHeaderLoader(head, getActivity()));
        }
    }

    @Override
    public void putErr(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void DataSuss(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void DataErr(String err) {
        Toast.makeText(activity, err, Toast.LENGTH_LONG).show();
    }

}
