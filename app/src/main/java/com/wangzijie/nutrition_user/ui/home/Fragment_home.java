package com.wangzijie.nutrition_user.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.HomeDietitianAdapter;
import com.wangzijie.nutrition_user.adapter.HomeHealthArticlesAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.contract.HomeContract;
import com.wangzijie.nutrition_user.model.bean.AstatusBean;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.HasStudioBean;
import com.wangzijie.nutrition_user.model.bean.HomeData;
import com.wangzijie.nutrition_user.presenter.HomePresenter;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActAddSeniorNutritionist;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActHealthPark;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActMyStudio;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActSeniorNutritionist;
import com.wangzijie.nutrition_user.ui.act.nutritionist.ActShopRegistration;
import com.wangzijie.nutrition_user.ui.mine.MyAssessActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.LocationUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author WangZequan
 * @time 2019/4/22  23:39
 * @describe 首页
 */
public class Fragment_home extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.banner_home_fragment)
    Banner imageBanan;

    @BindView(R.id.rcv1_home_fragment)
    RecyclerView rcv1VideoHomeFragment;
    @BindView(R.id.rcv_dietitian_home)
    RecyclerView rcvDietitianHome;

    @BindView(R.id.more_studio_home)
    TextView homeMoreWork;
    @BindView(R.id.tv_city_site_home)
    TextView tvCitySiteHome;
    @BindView(R.id.edt_search_home)
    EditText edtSearchHome;
    @BindView(R.id.iv_studio_logo_home_fragment)
    ImageView ivStudioLogoHomeFragment;
    @BindView(R.id.tv_studio_name_home_fragment)
    TextView tvStudioNameHomeFragment;
    @BindView(R.id.tv_studio_agree_count_home)
    TextView tvStudioAgreeCountHome;


    @BindView(R.id.home_portal_text1)
    TextView homePortalText1;
    @BindView(R.id.home_portal_text2)
    TextView homePortalText2;
    @BindView(R.id.home_portal_text3)
    TextView homePortalText3;
    @BindView(R.id.home_portal_text4)
    TextView homePortalText4;

    @BindView(R.id.home_portal_image3)
    ImageView homePortalImage3;
    @BindView(R.id.home_portal_image4)
    ImageView homePortalImage4;

    @BindView(R.id.imageView0)
    ImageView imageView0;


    private ArrayList<HomeData.DataBean.RecommendBean> recommendBeans = new ArrayList<>();
    private ArrayList<HomeData.DataBean.DietitianBean> dietitianBeans = new ArrayList<>();
    private ArrayList<HomeData.DataBean.BannerBean> bannerBeans = new ArrayList<>();

    private HomeHealthArticlesAdapter homeVideoAdapter;
    private HomeDietitianAdapter dietitianAdapter;
    private String areaName;
    private boolean hasStudioOK;//我的工作室是否处于申请成功状态
    private boolean astatusOK;//高级营养师是否处于申请成功状态
    private String studioId;
    private HomeData.DataBean.StudioBean studioBean;

    public Fragment_home() {
    }


    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mPresenter.homeGetData();
        areaName = LocationUtil.getInstance(getActivity()).getAreaName(activity);
        if (!TextUtils.isEmpty(MyApplication.globalData.getAreaName())
                && !TextUtils.isEmpty(MyApplication.globalData.getAreaId())) {
            tvCitySiteHome.setText(MyApplication.globalData.getAreaName());
        } else if (!TextUtils.isEmpty(areaName)) {
            tvCitySiteHome.setText(areaName);
            mPresenter.sendAreaName(areaName);
        } else {
            Toast.makeText(activity, "城市定位失败,请手动选择城市", Toast.LENGTH_SHORT).show();
            JumpUtil.overlay(activity, SiteActivity.class);
        }
        Glide.with(this)
                .asDrawable()
                .load(R.drawable.yuan)
                .into(imageView0);
    }


    @Override
    protected void initUI() {
        //创建健康视频适配器
        homeVideoAdapter = new HomeHealthArticlesAdapter(R.layout.item_health_advisory
                , recommendBeans, getContext());
        rcv1VideoHomeFragment.setNestedScrollingEnabled(false);
        rcv1VideoHomeFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv1VideoHomeFragment.setAdapter(homeVideoAdapter);
        //设置条目点击事件
        homeVideoAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            HomeData.DataBean.RecommendBean recommendBean = recommendBeans.get(i);
//            JumpUtil.jumpLocalVideo(getActivity(),recommendBean.getCTIF_URL());
            JumpUtil.jumpSimpleWebActivity(getActivity(), recommendBean.getUrl(), recommendBean.getAbstractX(), recommendBean.getId());
        });


        //创建营养师适配器
        dietitianAdapter = new HomeDietitianAdapter(R.layout.item_dietitian_home, dietitianBeans, getContext());
        //设置条目点击事件
        dietitianAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            Bundle bundle = new Bundle();
            bundle.putString("dietitianName", dietitianBeans.get(i).getNickname());
            bundle.putString("id", dietitianBeans.get(i).getDC_ID());
            JumpUtil.overlay(activity, More_DetailsActivity.class, bundle);
        });
        rcvDietitianHome.setNestedScrollingEnabled(false);
        rcvDietitianHome.setLayoutManager(new GridLayoutManager(activity, 5));
        rcvDietitianHome.setAdapter(dietitianAdapter);
    }


    @OnClick({R.id.iv_scan_home, R.id.home_portal_image4, R.id.more_studio_home,
            R.id.home_portal_image1, R.id.home_portal_text3, R.id.home_portal_image2,
            R.id.home_portal_text2, R.id.tv_nutritionist_more_home, R.id.tv_city_site_home,
            R.id.edt_search_home, R.id.home_portal_image3, R.id.iv_studio_logo_home_fragment, R.id.cl_customization_home, R.id.tv_video_more_home})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            //头部轮播框的一些点击
            case R.id.tv_city_site_home://跳转到定位
                bundle.putString("areaName", areaName);
                JumpUtil.startForResult(this, SiteActivity.class
                        , Constant.SITE_REQUEST_CODE, bundle);
                break;
            case R.id.edt_search_home://搜索框
                JumpUtil.overlay(getContext(), SeekActivity.class);
                getActivity().overridePendingTransition(R.anim.below_in, R.anim.immobility_out);
                break;
            case R.id.iv_scan_home://扫码

                break;
            //下方四个图标入口点击
            case R.id.home_portal_image1:
                bundle.putString("title", homePortalText1.getText().toString());
                JumpUtil.overlay(getContext(), ActHealthPark.class, bundle);
                break;
            case R.id.home_portal_image2:
                bundle.putString("title", homePortalText2.getText().toString());
                startActivity(new Intent(getContext(), ExperienceActivity.class));
                break;
            case R.id.home_portal_image3:
                if (myApplication.globalData.isNutritionist()) {
                    if (!hasStudioOK) {
                        mPresenter.getHasStudio();
                    } else {
                        bundle.putString("id", studioId);
                        JumpUtil.overlay(getContext(), ActMyStudio.class, bundle);//我的工作室
                    }
                } else {
                    JumpUtil.overlay(getContext(), ReportActivity.class, bundle);//我的报告
                }
                break;
            case R.id.home_portal_image4:
                bundle.putString("title", homePortalText4.getText().toString());
                if (myApplication.globalData.isNutritionist()) {
                    if (!astatusOK) {
                        mPresenter.getAstatus();
                    } else {
                        JumpUtil.overlay(getContext(), ActAddSeniorNutritionist.class);//高级营养师展示
                    }
                } else {
                    JumpUtil.overlay(getContext(), MyAssessActivity.class);//我的评估
                }
                break;

            case R.id.tv_nutritionist_more_home://更多营养师
                Intent intent = new Intent(getContext(), MoreActivity.class);
                intent.putExtra("isCustomizedService", false);
                startActivity(intent);
                break;


            case R.id.iv_studio_logo_home_fragment://大图工作室
                bundle.putString("title", studioBean.getName());
                bundle.putString("id", studioBean.getId());
                JumpUtil.overlay(getContext(), ShopActivity.class,bundle);
                break;
            case R.id.more_studio_home://更多工作室
                JumpUtil.overlay(getContext(), StudioActivity.class);
                break;

            case R.id.cl_customization_home://高级营养师定制化服务
//                Intent intent2 = new Intent(getContext(), MoreActivity.class);
//                intent2.putExtra("isCustomizedService", true);
//                startActivity(intent2);
                break;
            case R.id.tv_video_more_home://更多视频
                JumpUtil.overlay(getContext(), HealthArticlesActivity.class);
                break;
        }
    }


    @Override
    public void homeSucess(HomeData homeData) {
        if (myApplication.globalData.isNutritionist()) {
            homePortalImage3.setImageResource(R.drawable.nv5);
            homePortalText3.setText("我的工作室");
            homePortalImage4.setImageResource(R.drawable.nv6);
            homePortalText4.setText("高级营养师");
        } else {
            homePortalImage3.setImageResource(R.drawable.nv3);
            homePortalText3.setText("我的报告");
            homePortalImage4.setImageResource(R.drawable.nv4);
            homePortalText4.setText("我的评估");
        }
        HomeData.DataBean data = homeData.getData();
        recommendBeans.addAll(data.getRecommend());
        dietitianBeans.addAll(data.getDietitian());
        bannerBeans.addAll(data.getBanner());
        //刷新适配器
        homeVideoAdapter.notifyDataSetChanged();
        dietitianAdapter.notifyDataSetChanged();
        mPresenter.setBanner(bannerBeans, imageBanan);

        if (data.getStudio() != null && data.getStudio().size() > 0) {
            studioBean = data.getStudio().get(0);
            tvStudioNameHomeFragment.setText(data.getStudio().get(0).getName());

            Glide.with(this)
                    .asDrawable()
                    .load(data.getStudio().get(0).getLogo())
                    .error(R.drawable.studio_image)
                    .into(ivStudioLogoHomeFragment);

            tvStudioAgreeCountHome.setText(data.getStudio().get(0).getAgree_count());
        }
    }

    @Override
    public void homeErr(String msg) {

    }


    @Override
    public void bannerOnclick(HomeData.DataBean.BannerBean bannerBean) {
        JumpUtil.jumpSimpleWebActivity(getContext(), bannerBean.getAD_TITLE(), bannerBean.getAD_ID(), bannerBean.getAD_URL());
    }

    @Override
    public void areaNameError(String message) {

    }

    @Override
    public void areaNameOK(BaseBean message) {
        areaName = areaName;
    }

    @Override
    public void getHasStudioOK(HasStudioBean hasStudio) {
        Bundle bundle = new Bundle();
        if (hasStudio.getData().isHasStudio()) {
            MyApplication.globalData.setStudioInvitationCode(hasStudio.getData().getSpCode());
            hasStudioOK = true;
            studioId = hasStudio.getData().getSpId();
            bundle.putString("id", studioId);
            MyApplication.globalData.setStudioInvitationCode(hasStudio.getData().getSpCode());
            JumpUtil.overlay(getContext(), ActMyStudio.class, bundle);//我的工作室
        } else {
            bundle.putString("title", "注册工作室");
            JumpUtil.overlay(getContext(), ActShopRegistration.class, bundle);//没有工作室,注册
        }
    }

    @Override
    public void getAstatusOK(AstatusBean astatusBean) {
        Bundle bundle = new Bundle();
        int type = astatusBean.getData().getAStatus();
        if (type == 2) {
            astatusOK = true;
            JumpUtil.overlay(getContext(), ActAddSeniorNutritionist.class);//高级营养师
        } else {
            bundle.putInt("astatus", type);
            JumpUtil.overlay(getContext(), ActSeniorNutritionist.class, bundle);//申请高级营养师
        }
    }

    @Override
    public void getAstatusError(String message) {
        ToastUtil.showLong(getContext(), message + ",无法进入高级营养师");
    }

    @Override
    public void getHasStudioError(String message) {
        ToastUtil.showLong(getContext(), message + ",无法进入我的工作室");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constant.SITE_REQUEST_CODE && data != null) {
            areaName = data.getStringExtra("areaName");
            if (!TextUtils.isEmpty(this.areaName)) {
                tvCitySiteHome.setText(this.areaName);
            }
        }
    }
}
