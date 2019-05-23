package com.wangzijie.nutrition_user.ui.find;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.NewsDetail;
import com.wangzijie.nutrition_user.utils.glide.GlideImageLoader;
import com.wangzijie.nutrition_user.utils.TimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailHeaderView extends FrameLayout {

    private static final String NICK = "chaychan";

    @BindView(R.id.tvTitle)
    TextView mTvTitle;

    @BindView(R.id.ll_info)
    public LinearLayout mLlInfo;

    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;

    @BindView(R.id.tv_author)
    TextView mTvAuthor;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.wv_content)
    WebView mWvContent;

    private Context mContext;

    public NewsDetailHeaderView(Context context) {
        this(context, null);
    }

    public NewsDetailHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewsDetailHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.header_news_detail, this);
        ButterKnife.bind(this, this);
    }

    public void setDetail(NewsDetail detail) {

        mTvTitle.setText(detail.title);

        if (detail.media_user == null) {
            //如果没有用户信息
            mLlInfo.setVisibility(GONE);
        } else {
            if (!TextUtils.isEmpty(detail.media_user.avatar_url)){
                GlideImageLoader glideImageLoader = new GlideImageLoader();
                glideImageLoader.displayImage(mContext,detail.media_user.avatar_url, mIvAvatar);
            }
            mTvAuthor.setText(detail.media_user.screen_name);
            mTvTime.setText(TimeUtils.getShortTime(detail.publish_time * 1000L));
        }

        if (TextUtils.isEmpty(detail.content))
            mWvContent.setVisibility(GONE);

        mWvContent.getSettings().setJavaScriptEnabled(true);//设置JS可用
        mWvContent.addJavascriptInterface(new ShowPicRelation(mContext),NICK);//绑定JS和Java的联系类，以及使用到的昵称

        String htmlPart1 = "<!DOCTYPE HTML html>\n" +
                "<head><meta charset=\"utf-8\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<style> \n" +
                "img{width:100%!important;height:auto!important}\n" +
                " </style>";
        String htmlPart2 = "</body></html>";

        String html = htmlPart1 + detail.content + htmlPart2;


        mWvContent.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                addJs(view);//添加多JS代码，为图片绑定点击函数
                if (mWebListener != null){
                    mWebListener.onLoadFinished();
                }
            }
        });
    }

    /**添加JS代码，获取所有图片的链接以及为图片设置点击事件*/
    private void addJs(WebView wv) {
        wv.loadUrl("javascript:(function  pic(){"+
                "var imgList = \"\";"+
                "var imgs = document.getElementsByTagName(\"img\");"+
                "for(var i=0;i<imgs.length;i++){"+
                "var img = imgs[i];"+
                "imgList = imgList + img.src +\";\";"+
                "img.onclick = function(){"+
                "window.chaychan.openImg(this.src);"+
                "}"+
                "}"+
                "window.chaychan.getImgArray(imgList);"+
                "})()");
    }

    private LoadWebListener mWebListener;

    /**页面加载的回调*/
    public interface LoadWebListener{
        void onLoadFinished();
    }
}
