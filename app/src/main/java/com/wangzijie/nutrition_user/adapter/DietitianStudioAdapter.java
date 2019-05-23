package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.DietitianStudioBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import java.util.ArrayList;
import java.util.List;

public class DietitianStudioAdapter extends RecyclerView.Adapter<DietitianStudioAdapter.ViewHolder> {

    private Context context;
    private List<DietitianStudioBean.DataBean.DietListBean> list = new ArrayList<>();

    public DietitianStudioAdapter(Context context){
        this.context = context;
    }
    public void setList(List list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dietitian_dietition,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(list.get(position).nickname);
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).avatar)
                .error(R.drawable.head)
                .into(new MyGlideHeaderLoader(holder.image,context));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.getUserId(list.get(position).id);
            }
        });


    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_dietitian_logo_home_item);
            name = itemView.findViewById(R.id.tv_dietitian_name_home_item);

        }
    }

    private getUiserIdCallback callback;
    public interface getUiserIdCallback{
        void getUserId(String userid);
    }

    public void setCallback(getUiserIdCallback callback){
        this.callback = callback;
    }

}
