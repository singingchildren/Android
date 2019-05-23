package com.wangzijie.nutrition_user.adapter.mine;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.glide.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT;
import static com.wangzijie.nutrition_user.Constant.REQUEST_CODE_SELECT2;

/**
 *  @author     WangZequan
 *  @time       2019/4/26  22:13
 *  @describe   放微信选择图片的列表适配器
 */
public class PhotoAdapter extends BaseQuickAdapter<ImageItem, BaseViewHolder> {
    //请求码,如果一个页面用到多个PhotoAdapter,传入不同的requestCode代表不同的列表与适配器
    private final int requestCode;

    private List<ImageItem> imageItemList;
    private Activity activity;
    //父布局的一个view,用于弹出popWindow
    private View parent;
    //选择图片数量的上限,默认是3,可用包含imageUploadLimit参数的构造传入大于0的int值覆盖
    private int imageUploadLimit=Constant.IMAGE_UPLOAD_LIMIT;

    private boolean isSetClickImage;

    public PhotoAdapter(@Nullable ArrayList<ImageItem> data, int requestCode,int imageUploadLimit) {
        super(R.layout.image_item, data);
        imageItemList = data;
        this.requestCode=requestCode;
        if (imageUploadLimit>0)
        this.imageUploadLimit=imageUploadLimit;
    }

    public PhotoAdapter(@Nullable List<ImageItem> data, int requestCode) {
        super(R.layout.image_item, data);
        imageItemList = data;
        this.requestCode=requestCode;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImageItem imageItem) {
        GlideImageLoader glideImageLoader = new GlideImageLoader();
        ImageView delete = baseViewHolder.getView(R.id.delete);
        if (TextUtils.isEmpty(imageItem.path)) {
            glideImageLoader.displayImage(mContext, R.drawable.add, baseViewHolder.getView(R.id.iv_photo));
            delete.setVisibility(View.GONE);
        } else {
            glideImageLoader.displayImage(mContext, imageItem.path, baseViewHolder.getView(R.id.iv_photo));
            delete.setVisibility(View.VISIBLE);
        }

        baseViewHolder.getView(R.id.delete).setOnClickListener(v -> {
            imageItemList.remove(imageItem);
            if (imageItemList.size() == imageUploadLimit - 1) {
                imageItemList.add(new ImageItem());
            }
            notifyDataSetChanged();
        });
        baseViewHolder.getView(R.id.iv_photo).setOnClickListener(v -> {
            if (isSetClickImage){
                clickedImage(imageItem,requestCode);
            }
        });

    }

    /**
     * 设置item中图片的点击事件
     * @param parent    用于弹出popupWindow父视图view
     * @param activity  弹出popupWindow的activity
     */
    public void setClickImageListener(View parent, Activity activity){
        isSetClickImage=true;
        this.parent=parent;
        this.activity=activity;
    }

    /**
     *  item中图片的点击事件
     * @param imageItem
     */
    public void clickedImage(ImageItem imageItem, int requestCode) {
        if (TextUtils.isEmpty(imageItem.path)) {
            DisplayUtils.initUploadPicturesPopWindow(parent, activity
                    , imageUploadLimit + 1 - imageItemList.size(),requestCode);
        } else {
            //打开预览,现在有bug,先不改了
//            ArrayList<ImageItem> list = new ArrayList<>();
//            list.add(imageItem);
//            Intent intentPreview = new Intent(activity, ImagePreviewDelActivity.class);
//            intentPreview.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS, (Parcelable) imageItem);
//            intentPreview.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, list);
//            intentPreview.putExtra(ImagePicker.EXTRA_FROM_ITEMS, true);
//            activity.startActivityForResult(intentPreview, REQUEST_CODE_PREVIEW);
        }
    }


    /**
     *  从相册或相机返回activity的回调方法,直接传入activity回调方法的参数即可
     *  有新的回调需求在这里加就好
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data != null && requestCode == REQUEST_CODE_SELECT) {
            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            imageItemList.remove(imageItemList.size() - 1);
            if (images.size() > 0) {
                imageItemList.addAll(images);
                if (imageItemList.size() < imageUploadLimit) {
                    ImageItem imageItem = new ImageItem();
                    imageItemList.add(imageItem);
                }
                notifyDataSetChanged();
            }
        }
        else if (data != null && requestCode == REQUEST_CODE_SELECT2) {
            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            imageItemList.remove(imageItemList.size() - 1);
            if (images.size() > 0) {
                imageItemList.addAll(images);
                if (imageItemList.size() < imageUploadLimit) {
                    ImageItem imageItem = new ImageItem();
                    imageItemList.add(imageItem);
                }
                notifyDataSetChanged();
            }
        }
    }

}
