package com.wangzijie.nutrition_user.ui.message;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.message.UserFileAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.UserFileListBean;
import com.wangzijie.nutrition_user.ui.act.ActPersionTarchives;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.RequestBodyBuilder;
import com.wangzijie.nutrition_user.utils.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author WangZequan
 * @time 2019/5/9  17:24
 * @describe 营养师端>消息>用户档案列表Fragment
 */
public class FragmentUserFile extends BaseFragment {
    @BindView(R.id.rcv_user_file_fragment)
    RecyclerView rcvUserFile;
    @BindView(R.id.rfl_user_file)
    SmartRefreshLayout refreshLayout;
    int page = 1;
    private boolean nextPage;
    private UserFileAdapter adapter;
    private UserFileListBean bean;
    private List<UserFileListBean.DataBean.ListBean> list = new ArrayList<>();

    public static FragmentUserFile getInstance() {
        return new FragmentUserFile();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_user_file;
    }

    @Override
    protected void initData() {
        onLoadData(null);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initUI() {
        list.clear();
        rcvUserFile.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new UserFileAdapter(list);
        adapter.setOnItemChildClickListener((baseQuickAdapter, view, i) -> {
            UserFileListBean.DataBean.ListBean listBean = list.get(i);
            String userId = listBean.getUserId();
            SharedPreferenceUtil.put(getContext(),"userId",userId);
            JumpUtil.overlay(getContext(), ActPersionTarchives.class);
        });
        rcvUserFile.setAdapter(adapter);
        //刷新
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            page = 1;
            list.clear();
            onLoadData(refreshLayout);

        });

        //加载
        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (nextPage) {
                onLoadData(refreshLayout);
            } else {
                Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                refreshLayout.finishLoadMore(1000);
            }
        });
        super.initUI();
    }

    private void onLoadData(RefreshLayout refreshLayout) {
        RequestBody body = RequestBodyBuilder.objBuilder()
                .getPageBuild(page, Constant.LIMIT);
        ApiStore.getService()
                .getMycustomerList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFileListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFileListBean userFileListBean) {
                        if (userFileListBean.isSuccess()) {
                            if (refreshLayout!=null) {
                                refreshLayout.finishRefresh();
                                Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                            }
                            nextPage = userFileListBean.getData().isNextPage();
                            list.addAll(userFileListBean.getData().getList());
                            page++;
                        } else {
                            showError(userFileListBean.getMessage());
                            Toast.makeText(activity, userFileListBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        if (refreshLayout != null) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (refreshLayout != null) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        }
                        showError(e.getMessage());
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
