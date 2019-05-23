package com.wangzijie.nutrition_user.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * @author WangZequan
 * @time 2019/5/2 14:58
 * @describe    用于glide加载头像
 */
public class MyGlideHeaderLoader extends BitmapImageViewTarget {
    private final ImageView imageView;
    private final Context context;

    public MyGlideHeaderLoader(ImageView imageView, Context context) {
        super(imageView);
        this.imageView=imageView;
        this.context=context;
    }
    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        circularBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(circularBitmapDrawable);
    }
}
