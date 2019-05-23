package com.wangzijie.nutrition_user.utils.glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

public class GlideRectRound extends BitmapTransformation {


    private static float radius = 0f;
    // 构造方法1 无传入圆角度数 设置默认值为5
    public GlideRectRound(Context context) {
        this(context,5);
    }
    // 构造方法2 传入圆角度数
    public GlideRectRound(Context context, int dp) {
        // 设置圆角度数
        radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    // 重写该方法 返回修改后的Bitmap
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return rectRoundCrop(pool,toTransform);
    }
    // 四舍五入
    public String getId() {
        Log.e("getID",getClass().getName() + Math.round(radius));
        return getClass().getName() + Math.round(radius);
    }

    private Bitmap rectRoundCrop(BitmapPool pool, Bitmap toTransform) {
        if (toTransform == null) return null;
        // ARGB_4444——代表4x4位ARGB位图,ARGB_8888——代表4x8位ARGB位图
        Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        // setShader 对图像进行渲染
        // 子类之一 BitmapShader设置Bitmap的变换  TileMode 有CLAMP （取bitmap边缘的最后一个像素进行扩展），REPEAT（水平地重复整张bitmap）
        // MIRROR(和REPEAT类似，但是每次重复的时候，将bitmap进行翻转)
        paint.setShader(new BitmapShader(toTransform, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);   // 抗锯齿
        RectF rectF = new RectF(0f, 0f, toTransform.getWidth(), toTransform.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;

    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

    
}
