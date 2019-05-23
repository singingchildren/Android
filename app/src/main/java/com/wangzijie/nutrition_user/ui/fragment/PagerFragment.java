package com.wangzijie.nutrition_user.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.R;

public class PagerFragment extends Fragment {

    private static int image;
    private static int [] images= new int[]{R.drawable.agreementt1,R.drawable.agreementt2,R.drawable.agreementt3
    ,R.drawable.agreementt4,R.drawable.agreementt5,R.drawable.agreementt6,R.drawable.agreementt7
            ,R.drawable.agreementt8,R.drawable.agreementt9,R.drawable.agreementt10,R.drawable.agreementt11
            ,R.drawable.agreementt12};

    public PagerFragment() {

    }

    public static PagerFragment newInstance(int index) {
        PagerFragment fragment = new PagerFragment();
        image=images[index];
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
