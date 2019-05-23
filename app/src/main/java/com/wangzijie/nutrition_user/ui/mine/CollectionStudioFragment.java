package com.wangzijie.nutrition_user.ui.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.collection.CollectionStudioAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.CollectionsContract2;
import com.wangzijie.nutrition_user.model.bean.RecommendData;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;
import com.wangzijie.nutrition_user.presenter.CollectionsPresenter2;
import com.wangzijie.nutrition_user.ui.home.ShopActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 *  @author     WangZequan
 *  @time       2019/4/21  19:18
 *  @describe   我的收藏 工作室
 */
public class CollectionStudioFragment extends BaseFragment<CollectionsPresenter2> implements CollectionsContract2.View {

    @BindView(R.id.sml_collection_studio)
    SwipeMenuListView smlCollectionStudio;

    SwipeMenuCreator creator = menu -> {
        // 创建删除的条目
        SwipeMenuItem deleteItem = new SwipeMenuItem(
                getContext());
        // 设置背景色
        deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                0x3F, 0x25)));
        // 设置宽度
        deleteItem.setWidth(360);
        // set a icon
//            deleteItem.setIcon(R.drawable.ic_delete);

        //设置文字和文字属性
        deleteItem.setTitle(getContext().getString(R.string.cancel_collection));
        deleteItem.setTitleSize(18);
        deleteItem.setTitleColor(Color.WHITE);

        // 添加两个条目
        menu.addMenuItem(deleteItem);
    };

    private CollectionStudioAdapter collectionStudioAdapter;
    private ArrayList<StudioListBean.DataBean.StudioBean> beanList;


    @Override
    protected CollectionsPresenter2 createPresenter() {
        return new CollectionsPresenter2();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.colletion_studio;
    }

    @Override
    protected void initData() {
//        presenter.getData(1, 1, Constant.LIMIT, "studio");

        beanList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudioListBean.DataBean.StudioBean dataBean = new StudioListBean.DataBean.StudioBean();
            dataBean.setSP_NAME("兰州康复会员店");
            dataBean.setSP_DESC("你好，这里显示的是相关内容，请查看！！！！");
            dataBean.setSP_ADDRESS("13.5km");
            dataBean.setAgree_count("135000");
            beanList.add(dataBean);
        }
        collectionStudioAdapter = new CollectionStudioAdapter(beanList,getContext());
        smlCollectionStudio.setAdapter(collectionStudioAdapter);
        // 绑定侧滑菜单
        smlCollectionStudio.setMenuCreator(creator);
        // 设置滑动向左
        smlCollectionStudio.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        //设置侧滑菜单点击事件
        smlCollectionStudio.setOnMenuItemClickListener((position, menu, index) -> {

            //false:关闭菜单;true:不关闭菜单
            return false;
        });
        //设置条目点击事件
        smlCollectionStudio.setOnItemClickListener((parent,view,position,id)->{
            StudioListBean.DataBean.StudioBean data = beanList.get(position);
            String title = data.getSP_NAME();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            JumpUtil.overlay(getActivity(), ShopActivity.class, bundle);
        });
    }

    @Override
    protected void initUI() {
        super.initUI();
    }

    @Override
    public void DataSuss(RecommendData data) {
        if (!data.getData().isNextPage()) {
//            smart.setEnableLoadMore(false);
        } else {
//            page++;
        }
        collectionStudioAdapter.notifyDataSetChanged();
    }

    @Override
    public void DataErr(String err) {

    }
}
