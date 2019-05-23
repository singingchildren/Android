package com.wangzijie.nutrition_user.utils;

import com.wangzijie.nutrition_user.model.bean.BaseBean;

/**
 * 营养师详情bean
 */
public class DetailsData extends BaseBean {
    //标签唯一值 0  1
    private int DetailasOne;
    private int image;

    public DetailsData() {
        super();
    }



    public int getDetailasOne() {
        return DetailasOne;
    }

    public void setDetailasOne(int detailasOne) {
        DetailasOne = detailasOne;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
