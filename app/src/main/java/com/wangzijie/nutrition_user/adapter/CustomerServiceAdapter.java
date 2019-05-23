package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.CustomerServiceBean;

import java.util.List;

/**
 * @author WangZequan
 * @time 2019/5/16 19:09
 * @describe
 */
public class CustomerServiceAdapter extends BaseAdapter {
    private Context context;
    private List<CustomerServiceBean> list;

    public CustomerServiceAdapter(Context context, List<CustomerServiceBean> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.customer_service_item, null);
            viewHolder=new ViewHolder();
            viewHolder.text_name = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text_name.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView text_name,text_sex;
    }
}
