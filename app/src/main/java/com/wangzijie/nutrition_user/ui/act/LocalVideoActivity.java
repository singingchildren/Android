package com.wangzijie.nutrition_user.ui.act;

import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

public class LocalVideoActivity extends BaseActivity {

    private VideoView videoView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_local_video;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String url = getIntent().getExtras().getString("url");
        String path = getIntent().getExtras().getString("path");
        Uri uri=null;
        String videoUrl1;
        String videoUrl2;
        if (!TextUtils.isEmpty(url)){
            //网络视频
            videoUrl1 = url;
            uri = Uri.parse(videoUrl1);
        }else if (!TextUtils.isEmpty(path)){
            //本地视频
            videoUrl2 = path;
            uri = Uri.parse(videoUrl2);
        }else {
            return;
        }


        videoView = (VideoView) this.findViewById(R.id.vdv_local_video_act);

        //设置视频控制器
        videoView.setMediaController(new MediaController(this));

        //播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

        //设置视频路径
        videoView.setVideoURI(uri);

        //开始播放视频
        videoView.start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            finish();
            Toast.makeText(LocalVideoActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
