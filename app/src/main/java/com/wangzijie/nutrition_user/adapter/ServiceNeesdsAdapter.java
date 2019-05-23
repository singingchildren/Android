package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;

import java.util.List;

public class ServiceNeesdsAdapter extends RecyclerView.Adapter<ServiceNeesdsAdapter.ViewHolder> {

    private Context context;
    private List<ServiceNeedBean.DataBean> list;
    private int i = 0;
    private getServiceNewId serviceNewId;

    public ServiceNeesdsAdapter(Context context) {
        this.context = context;
    }

    public void setList(List list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_label, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getName());
        if (list.get(position).isSelected()) {
            holder.title.setChecked(true);
            i++;
        }
        holder.title.setOnClickListener(v -> {
            if (i >= 4) {
                if (!holder.title.isChecked()) {
                    i--;
                    list.get(position).setSelected(holder.title.isChecked());
                } else {
                    holder.title.setChecked(false);
                    list.get(position).setSelected(false);
                    if (serviceNewId != null) {
                        serviceNewId.getToastString();
                    }
                }
            } else {
                if (holder.title.isChecked()) {
                    i++;
                    list.get(position).setSelected(holder.title.isChecked());
                } else {
                    i--;
                    list.get(position).setSelected(holder.title.isChecked());
                }
            }


        });


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setServiceNewId(getServiceNewId serviceNewId) {
        this.serviceNewId = serviceNewId;
    }

    public interface getServiceNewId {
        void getToastString();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.label_service_item);
        }
    }


}
