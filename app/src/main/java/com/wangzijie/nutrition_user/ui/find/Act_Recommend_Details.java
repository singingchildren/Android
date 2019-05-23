package com.wangzijie.nutrition_user.ui.find;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.news.CommentAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.bean.NewsData;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.Log.AppLogMessageUtil;
import com.wangzijie.nutrition_user.utils.PwdCheckUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发现>推荐>评论>详情
 *
 * @author fanjiangpeng
 */
public class Act_Recommend_Details extends BaseActivity {

//    @BindView(R.id.back)
//    TextView back;
    @BindView(R.id.back2)
    ImageView back2;
    @BindView(R.id.relativeLayout4)
    RelativeLayout relativeLayout4;
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.fl_comment_icon)
    FrameLayout flCommentIcon;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.ll_info)
    LinearLayout title2;
    @BindView(R.id.tv_member)
    TextView tvMember;
    @BindView(R.id.tv_autor)
    TextView tvAutor;
    @BindView(R.id.like)
    ImageView like;
    @BindView(R.id.zan)
    ImageView zan;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.bottom)
    LinearLayout bootom;
    @BindView(R.id.bottom2)
    LinearLayout bottom2;
    @BindView(R.id.et_context)
    EditText etContext;

    private NewsDetailHeaderView newsDetailHeaderView;
    private CommentAdapter commentAdapter;
    private List<NewsData> newsDataList = new ArrayList<>();

    private int lastPosition;
    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initView() {
        newsDetailHeaderView = new NewsDetailHeaderView(this);
        rvComment.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    @Override
    protected void initData() {
        commentAdapter = new CommentAdapter(newsDataList);
        rvComment.setAdapter(commentAdapter);
        commentAdapter.addHeaderView(newsDetailHeaderView);

        commentAdapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            switch (view.getId()) {
                case R.id.tv_reply:
                    JumpUtil.overlay(this, Act_List_Comment.class);
                    break;
                default:
                    break;
            }
        });
        commentAdapter.setEmptyView(R.layout.pager_no_comment, rvComment);
        commentAdapter.setHeaderAndEmpty(true);
        for (int i = 0; i < 20; i++) {
            NewsData newsDetail = new NewsData();
            newsDataList.add(newsDetail);
        }
        commentAdapter.notifyDataSetChanged();
//        NewsDetail newsDetail = new NewsDetail();
//        newsDetail.setTitle("aaaaa");
//        newsDetail.setSource("bbbb");
//        newsDetailHeaderView.setDetail(newsDetail);

        rvComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.getLayoutManager() != null) {
                    getPositionAndOffset();
                }
            }
        });


    }

    /**
     * 记录RecyclerView当前位置
     */
    private void getPositionAndOffset() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) rvComment.getLayoutManager();
        //获取可视的第一个view
        View topView = layoutManager.getChildAt(0);
        if (topView != null) {
            //获取与该view的顶部的偏移量
            int lastOffset = topView.getTop();
            AppLogMessageUtil.e(lastOffset + "");
            //得到该View的数组位置
            lastPosition = layoutManager.getPosition(topView);
            if (lastPosition >= 1) {
                relativeLayout4.setVisibility(View.GONE);
                newsDetailHeaderView.setVisibility(View.GONE);
                title2.setVisibility(View.VISIBLE);
            } else {
                relativeLayout4.setVisibility(View.VISIBLE);
                newsDetailHeaderView.setVisibility(View.VISIBLE);
                title2.setVisibility(View.GONE);
            }
            AppLogMessageUtil.e(lastPosition + "");
        }
    }

    private void initPopwindow() {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.popwindow, null);
        //给popwindow加上动画效果
        LinearLayout layout_pop = (LinearLayout) view.findViewById(R.id.layout_pop);
        LinearLayout weixin = view.findViewById(R.id.weixin);
        LinearLayout friendq = view.findViewById(R.id.friendq);
        LinearLayout sina = view.findViewById(R.id.sina);
        LinearLayout qq = view.findViewById(R.id.qq);
        LinearLayout qq_zion = view.findViewById(R.id.qq_zion);
        view.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.fade_in));
        layout_pop.startAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.push_bottom_in));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        PopupWindow popupWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        layout_pop.setOnClickListener(v -> {
            bgAlpha(1f);
            popupWindow.dismiss();
        });
        qq.setOnClickListener(v -> ToastUtil.show(Act_Recommend_Details.this, "QQ"));
        qq_zion.setOnClickListener(v -> ToastUtil.show(Act_Recommend_Details.this, "QQ空间"));
        weixin.setOnClickListener(v -> ToastUtil.show(Act_Recommend_Details.this, "微信"));
        friendq.setOnClickListener(v -> ToastUtil.show(Act_Recommend_Details.this, "朋友圈"));
        sina.setOnClickListener(v -> ToastUtil.show(Act_Recommend_Details.this, "新浪"));
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(rvComment, Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        bgAlpha(0.5f);
    }

    private void bgAlpha(float alpha) {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = alpha;// 0.0-1.0
        this.getWindow().setAttributes(lp);
    }

    @OnClick({R.id.like, R.id.zan, R.id.share, R.id.back, R.id.tv_comment, R.id.fl_comment_icon, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.like:
                break;
            case R.id.zan:
                break;
            case R.id.share:
                initPopwindow();
                break;
//            case R.id.back:
//                this.finish();
//                break;
            case R.id.back2:
                this.finish();
                break;
            case R.id.tv_comment:
                bottom2.setVisibility(View.VISIBLE);
                bootom.setVisibility(View.GONE);
                break;
            case R.id.fl_comment_icon:
                if (lastPosition > 1) {
                    smoothMoveToPosition(rvComment, 0);
                } else {
                    smoothMoveToPosition(rvComment, 1);
                }
                break;
            case R.id.tv_commit:
                if (PwdCheckUtil.selectViewData(etContext)) {
                    ToastUtil.show(this, "请输入评论内容！");
                    return;
                }
                bottom2.setVisibility(View.GONE);
                bootom.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前，使用smoothScrollToPosition
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后，最后一个可见项之前
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                // smoothScrollToPosition 不会有效果，此时调用smoothScrollBy来滑动到指定位置
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }
}
