package com.wangzijie.nutrition_user.adapter.healthguidance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private Context context;
    private List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> list = new ArrayList<>();

    public ExerciseAdapter(Context context){
        this.context = context;
    }
    public void setList(List list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.exerciseitem,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.time.setText(list.get(position).getTimeStr()+"    "+list.get(position).getCMSLREP_PEROID()+"/天");
        holder.content.setText(list.get(position).getContent());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            content = itemView.findViewById(R.id.content);

        }
    }
}
