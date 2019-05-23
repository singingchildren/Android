package com.wangzijie.nutrition_user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.find.Act_Recommend_Details;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import butterknife.BindView;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.BuildConfig;

public class WebActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.web_image)
    ImageView webImage;
    @BindView(R.id.tv_title_web)
    TextView tvTitleWeb;

    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        String name = bundle.getString("name");
        int id = bundle.getInt("id");
        tvTitleWeb.setText(name);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        if (BuildConfig.DEBUG) Log.d("WebActivityLJQ,url", url + "?id=" + id);
//        webView.loadUrl(url+"?id="+id);
        webView.loadUrl(url);
    }

    @Override
    protected void initData() {
        //设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //设置是否出现缩放工具
        webView.getSettings().setBuiltInZoomControls(false);


        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);

        //支持App内部javascript交互
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.addJavascriptInterface(this, "JS");//AndroidtoJS类对象映射到js的test对象
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.web_image, R.id.fl_comment_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.web_image:
                finish();
                break;
            case R.id.fl_comment_icon:
                JumpUtil.overlay(this, Act_Recommend_Details.class, bundle);
                break;

            default:
                break;
        }
    }

//    /**
//     * JS调用Android方法
//     *
//     * @param  s
//     */
//    @JavascriptInterface
//    public void fromJsGetValue(String s) {
//        finish();
//    }
}
