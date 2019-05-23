package com.wangzijie.nutrition_user.adapter.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;

import java.util.ArrayList;


/**
 * @author WangZequan
 * @time 2019/4/22 10:33
 * @describe 收藏工作室的适配器(侧滑list需要ListAdapter的实现类)
 */
public class CollectionStudioAdapter extends BaseAdapter {

    private ArrayList<StudioListBean.DataBean.StudioBean> beanList;
    private Context context;

    public CollectionStudioAdapter(ArrayList<StudioListBean.DataBean.StudioBean> beanList, Context context) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public StudioListBean.DataBean.StudioBean getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.home_studio, null);
            viewHolder.studio_title=convertView.findViewById(R.id.studio_title);
            viewHolder.studio_content=convertView.findViewById(R.id.studio_content);
            viewHolder.studio_mi=convertView.findViewById(R.id.studio_mi);
            viewHolder.studio_number=convertView.findViewById(R.id.studio_number);
            viewHolder.studio_image=convertView.findViewById(R.id.studio_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (beanList!=null) {
            viewHolder.studio_title.setText(beanList.get(position).getSP_NAME());
            viewHolder.studio_content.setText(beanList.get(position).getSP_DESC());
            viewHolder.studio_mi.setText(beanList.get(position).getSP_ADDRESS());
            viewHolder.studio_number.setText(beanList.get(position).getAgree_count());
            Glide.with(context).load(beanList.get(position).getSP_LOGOURL()).apply((RequestOptions.bitmapTransform
                    (new RoundedCorners(30)))).into((ImageView) viewHolder.studio_image);
        }

        return convertView;
    }

    class ViewHolder {
        TextView studio_title
                ,studio_content
                ,studio_mi
                ,studio_number;
        ImageView studio_image;
    }
}
