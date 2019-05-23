package com.wangzijie.nutrition_user.contract;

import com.wangzijie.nutrition_user.base.contract.BaseView;
import com.wangzijie.nutrition_user.model.bean.AstatusBean;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.HasStudioBean;
import com.wangzijie.nutrition_user.model.bean.HomeData;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * @author fanjiangpeng
 * 营养师端首页管理类
 */
public class HomeContract {
    public interface View extends BaseView {
        /**
         * 首页View
         * 成功
         * @param homeData
         */
        void homeSucess(HomeData homeData);

        /**
         * 失败
         * @param msg
         */
        void homeErr(String msg);

        /**
         * 轮播图点击
         * @param
         */
        void bannerOnclick(HomeData.DataBean.BannerBean bannerBean);

        void areaNameError(String message);

        void areaNameOK(BaseBean message);

        void getHasStudioOK(HasStudioBean baseBean);

        void getAstatusOK(AstatusBean astatusBean);

        void getAstatusError(String message);

        void getHasStudioError(String message);
    }

    public interface homePer {
        /**
         * Persent
         */
        void homeGetData();

        void sendAreaName(String areaName);

        /**
         * 设置轮播图
         * @param bannerBeans
         * @param imageBanan
         */
        void setBanner(ArrayList<HomeData.DataBean.BannerBean> bannerBeans, Banner imageBanan);

        void getHasStudio();

        void getAstatus();
    }
}
