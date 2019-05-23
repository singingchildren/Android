package com.wangzijie.nutrition_user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.contract.SimpleWebContract;
import com.wangzijie.nutrition_user.presenter.SimpleWebPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.BuildConfig;

public class SimpleWebActivity extends BaseActivity<SimpleWebPresenter> implements SimpleWebContract.View {

    @BindView(R.id.wbv_simple_web)
    WebView webView;
    @BindView(R.id.tv_title_simple_web)
    TextView tvTitleWeb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_simple_web;
    }

    @Override
    protected void initView() {
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        String name = bundle.getString("name");
        int id = bundle.getInt("id");
        tvTitleWeb.setText(name);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        if (BuildConfig.DEBUG) Log.d("SimpleWebActLJQ,url", url + "?id=" + id);
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
    protected SimpleWebPresenter createPresenter() {
        return new SimpleWebPresenter();
    }


    @OnClick({R.id.image_back_simple_web, R.id.iv_collect_simple_web, R.id.iv_transmit_simple_web})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back_simple_web:
                finish();
                break;
            case R.id.iv_collect_simple_web:
//                mPresenter
                break;
            case R.id.iv_transmit_simple_web:
//                mPresenter
                break;
        }
    }
}
