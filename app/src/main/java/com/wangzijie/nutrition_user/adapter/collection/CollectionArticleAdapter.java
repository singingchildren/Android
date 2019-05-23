package com.wangzijie.nutrition_user.adapter.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;

import java.util.ArrayList;


/**
 * @author WangZequan
 * @time 2019/4/22 10:33
 * @describe 收藏新闻的适配器
 */
public class CollectionArticleAdapter extends BaseAdapter {

    private ArrayList<NewsListBean> beanList;
    private Context context;

    public CollectionArticleAdapter(ArrayList<NewsListBean> beanList, Context context) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public NewsListBean getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        int type = getItemViewType(position);
        //无convertView，需要new出各个控件
        if (convertView == null) {
            //按当前所需的样式，确定new的布局
            switch (type) {
                case 0:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_text_news, parent, false);
                    holder1 = new ViewHolder1();
                    convertView.setTag(holder1);
                    break;
                case 1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_pic_news, parent, false);
                    holder2 = new ViewHolder2();
                    convertView.setTag(holder2);
                    break;
                case 2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_three_news, parent, false);
                    holder3 = new ViewHolder3();
                    convertView.setTag(holder3);
                    break;

            }
        } else {
            //有convertView，按样式，取得不用的布局
            switch (type) {
                case 0:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case 1:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case 2:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
            }
        }

        //设置资源
        switch (type) {
            case 0:
                break;
            case 1:

                break;
            case 2:
                break;
        }

        return convertView;
    }


    @Override
    public int getItemViewType(int position) {
        return beanList.get(position).getNewsType();
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    class BaseViewHolder {

    }

    class ViewHolder1 extends BaseViewHolder {

    }

    class ViewHolder2 extends BaseViewHolder {

    }

    class ViewHolder3 extends BaseViewHolder {

    }

}
