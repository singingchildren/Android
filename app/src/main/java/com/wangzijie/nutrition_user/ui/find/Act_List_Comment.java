package com.wangzijie.nutrition_user.ui.find;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.news.CommentAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.bean.NewsData;
import com.wangzijie.nutrition_user.utils.KeybordUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/***
 * 评论>回复>详情页
 * @author fanjiangpeng
 */
public class Act_List_Comment extends BaseActivity {
    @BindView(R.id.home_healthimage)
    ImageView homeHealthimage;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.home_healthtext)
    TextView homeHealthtext;
    @BindView(R.id.relativeLayout6)
    RelativeLayout relativeLayout6;
    @BindView(R.id.zan)
    ImageView zan;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.rcv)
    RecyclerView normalView;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    @BindView(R.id.et_comment)
    EditText etComment;

    private NewsData newsData;
    private CommentAdapter commentAdapter;
    private List<NewsData> newsDataList = new ArrayList<>();

    private boolean isShow = false;

    @Override
    protected int getLayoutId() {
        return R.layout.act_list_comment;
    }

    @Override
    protected void initView() {
        normalView.setLayoutManager(new LinearLayoutManager(this));
        commentAdapter = new CommentAdapter(newsDataList);
        normalView.setAdapter(commentAdapter);
        smart.setOnRefreshListener(refreshLayout -> {
            smart.finishRefresh(300);
            smart.finishRefresh();
        });

        smart.setOnLoadMoreListener(refreshLayout -> {
            smart.finishLoadMore(300);
            smart.finishLoadMore();
        });

        commentAdapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            if (isShow) {
                KeybordUtils.closeKeybord(etComment, this);
                isShow = false;
            } else {
                KeybordUtils.openKeybord(etComment, this);
                isShow = true;
            }
        });

        commentAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            KeybordUtils.closeKeybord(etComment, this);
        });


    }

    @Override
    protected void initData() {
        setData();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.back, R.id.home_healthtext, R.id.zan, R.id.share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.home_healthtext:
                break;
            case R.id.zan:
                break;
            case R.id.share:
                break;
            default:
                break;
        }
    }

    private void setData() {
        newsData = new NewsData();
        for (int i = 0; i < 10; i++) {
            newsDataList.add(newsData);
        }
        commentAdapter.notifyDataSetChanged();
    }
}
