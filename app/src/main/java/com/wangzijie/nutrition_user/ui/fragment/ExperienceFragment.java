package com.wangzijie.nutrition_user.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.R;

public class ExperienceFragment extends Fragment {

    private static int image;
    private static int [] images= new int[]{R.drawable.experience1,R.drawable.experience2,R.drawable.experience3
    ,R.drawable.experience4,R.drawable.experience5,R.drawable.experience6,R.drawable.experience7
            ,R.drawable.experience8,R.drawable.experience9,R.drawable.experience10,R.drawable.experience11
            ,R.drawable.experience12,R.drawable.experience13,R.drawable.experience14};

    public ExperienceFragment() {

    }

    public static ExperienceFragment newInstance(int index) {
        ExperienceFragment fragment = new ExperienceFragment();
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
        Glide.with(this).load(image).into(imageView);
        return view;
    }

}
