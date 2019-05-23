package com.wangzijie.nutrition_user.adapter.mine;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.utils.DateTimeUtils;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class HistoryAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    private final List<HistoryEntity.DataBean.CasesBean> dataList;
    private final Activity activity;

    public HistoryAdapter(@Nullable List<HistoryEntity.DataBean.CasesBean> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @Override
    public long getHeaderId(int position) {
        String year = DateTimeUtils.getTime(dataList.get(position).getCreatedAt(),
                "yyyy-MM-dd", "yyyy");
        return Long.parseLong(year);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public HistoryEntity.DataBean.CasesBean getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder hvh;
        if (convertView == null) {
            hvh = new HeaderViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_hander, null);
            hvh.text =  convertView.findViewById(R.id.tv_header_item);
            convertView.setTag(hvh);
        } else {
            hvh = (HeaderViewHolder) convertView.getTag();
        }
        String year = DateTimeUtils.getTime(dataList.get(position).getCreatedAt(),
                "yyyy-MM-dd", "yyyy");
        hvh.text.setText(year + "年");
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.histroy_item, null);
            viewHolder.recyclerView= convertView.findViewById(R.id.rcv_history_item);
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_title_history_item);
            viewHolder.tvDate = convertView.findViewById(R.id.tv_date_history_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HistoryEntity.DataBean.CasesBean bean = dataList.get(position);
        String friendlyDate = DateTimeUtils.getFriendlyDate(
                DateTimeUtils.parseDate(bean.getCreatedAt(), null));
        Log.d("HistoryAdapter", friendlyDate);
        viewHolder.tvDate.setText(friendlyDate);
        viewHolder.tvTitle.setText(bean.getContent());
        List<String > img_url = bean.getImg_url();
        viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(activity,3));
        HistoryPhotoAdapter adapter = new HistoryPhotoAdapter(R.layout.histroy_image_item,img_url);
        viewHolder.recyclerView.setAdapter(adapter);
        return convertView;
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView tvTitle,tvDate;
        RecyclerView recyclerView;
    }
   class HistoryPhotoAdapter extends BaseQuickAdapter<String , BaseViewHolder>  {

       public HistoryPhotoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
           super(layoutResId, data);
       }

       @Override
       protected void convert(BaseViewHolder baseViewHolder,  String url) {
           Glide.with(mContext)
                   .load(url)
                   .error(R.drawable.banner)
                   .into((ImageView) baseViewHolder.getView(R.id.iv_histroy_image_item));
       }


   }
}
