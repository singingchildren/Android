package com.wangzijie.nutrition_user.ui.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.collection.CollectionArticleAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.CollectionsContract;
import com.wangzijie.nutrition_user.model.bean.RecommendData;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;
import com.wangzijie.nutrition_user.presenter.CollectionsPresenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * @author WangZequan
 * @time 2019/4/21  18:49
 * @describe 我的收藏 文章
 */
public class CollectionArticleFragment extends BaseFragment<CollectionsPresenter> implements CollectionsContract.View {

    @BindView(R.id.sml_collection_article)
    SwipeMenuListView smlCollectionArticle;

    //创建侧滑菜单
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
    private CollectionArticleAdapter collectionArticleAdapter;
    private ArrayList<NewsListBean> beanList;

    public static CollectionArticleFragment getInstance() {
        return new CollectionArticleFragment();
    }

    @Override
    protected CollectionsPresenter createPresenter() {
        return new CollectionsPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.colletion_article;
    }

    @Override
    protected void initData() {
        mPresenter.getData( 1, Constant.LIMIT, "article");
        beanList = new ArrayList();
        beanList.add(new NewsListBean(0));
        beanList.add(new NewsListBean(1));
        beanList.add(new NewsListBean(2));


        // 绑定侧滑菜单
        smlCollectionArticle.setMenuCreator(creator);
        // 设置滑动向左
        smlCollectionArticle.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

        //设置侧滑菜单点击事件
        smlCollectionArticle.setOnMenuItemClickListener((int position, SwipeMenu menu, int index) -> {
            //false:关闭菜单;true:不关闭菜单
            return false;
        });
        //设置条目点击事件
        smlCollectionArticle.setOnItemClickListener((parent, view, position, id) -> {
            NewsListBean bean = beanList.get(position);
            JumpUtil.jumpWebActivity(getActivity(),"我的收藏",bean.getNewsId()+"","http://www.baidu.com");

        });

        collectionArticleAdapter = new CollectionArticleAdapter(beanList, myApplication);
        smlCollectionArticle.setAdapter(collectionArticleAdapter);
    }

    @Override
    protected void initUI() {
    }

    @Override
    public void DataSuss(RecommendData data) {
//        beanList = data.getData().getData().getBlogList();
//        beanList.addAll(list);
        collectionArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void DataErr(String err) {

    }


}
