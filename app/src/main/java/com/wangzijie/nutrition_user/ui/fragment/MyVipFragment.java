package com.wangzijie.nutrition_user.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wangzijie.nutrition_user.R;

public class MyVipFragment extends Fragment {

    private int image;
    private int [] images= new int[]{R.drawable.document1,R.drawable.document2,R.drawable.document3
    ,R.drawable.document4,R.drawable.document5,R.drawable.document6,R.drawable.document7
            ,R.drawable.document8,R.drawable.document9,R.drawable.document10,R.drawable.document11
            ,R.drawable.document12,R.drawable.document13,R.drawable.document14,R.drawable.document15};

    private int index;

    public MyVipFragment() {

    }

    public MyVipFragment(int index) {
        this.index=index;
        image=images[index];
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ImageView imageView = view.findViewById(R.id.imageviewpage);
        Glide.with(this).asBitmap().load(image).into(imageView);
        return view;
    }

}
