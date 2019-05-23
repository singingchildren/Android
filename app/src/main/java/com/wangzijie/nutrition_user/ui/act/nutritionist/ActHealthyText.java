package com.wangzijie.nutrition_user.ui.act.nutritionist;

import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.model.bean.HealthyTextBean;
import com.wangzijie.nutrition_user.contract.HeathyTextContract;
import com.wangzijie.nutrition_user.presenter.HeathyTextPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author fanjiangpeng
 * 健康乐园正文
 */
public class ActHealthyText extends BaseActivity<HeathyTextPresenter> implements HeathyTextContract.View {

    @BindView(R.id.web)
    WebView webview;
    @BindView(R.id.title)
    TextView title;
    private HeathyTextPresenter presenter;

    private int contentId;
    private String titleStr;

    @Override
    protected int getLayoutId() {
        return R.layout.act_health_text;
    }

    @Override
    protected void initView() {
        titleStr = getIntent().getStringExtra("name");
        title.setText(titleStr);
        contentId = getIntent().getIntExtra("id", 0);
        presenter.getData(contentId);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected HeathyTextPresenter createPresenter() {
        return new HeathyTextPresenter();
    }

    @Override
    public void DataSuss(HealthyTextBean bean) {
        setWebView(bean.getData().getData().get(0).getContent());
    }

    @Override
    public void DataErr(String err) {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }

    private void setWebView(String content) {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setDefaultTextEncodingName("UTF-8");
        webview.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webview.getSettings();
            webview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE); //注意安卓5.0以上的权限
        }
        webview.loadDataWithBaseURL(null, getNewContent(content), "text/html", "UTF-8", null);
    }

    private String getNewContent(String htmltext) {

        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            if (element.className() != null && element.className().length() > 0)
                element.attr("width", "100%").attr("height", "auto");

        }

        return doc.toString();
    }

}
