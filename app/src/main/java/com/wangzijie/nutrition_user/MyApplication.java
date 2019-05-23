package com.wangzijie.nutrition_user;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.lzy.imagepicker.ImagePicker;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.wangzijie.nutrition_user.chatui.DemoHelper;
import com.wangzijie.nutrition_user.model.bean.UserInfo;
import com.wangzijie.nutrition_user.utils.DeviceUuidutil;
import com.wangzijie.nutrition_user.utils.Log.CrashHandler2;
import com.wangzijie.nutrition_user.utils.Log.LogcatHelper;
import com.wangzijie.nutrition_user.utils.glide.GlideImageLoader;
import com.wangzijie.nutrition_user.utils.oss.OssServiceUtil;

import java.util.Iterator;
import java.util.List;

public class MyApplication extends Application {
    public static UserInfo.DataBean userInfo;//我的fragment页面需要的数据

    public static GlobalData globalData = new GlobalData();;//应用全局数据

    private static MyApplication myApplication;
    private static Thread mMainThread;//主线程
    private static long mMainThreadId;//主线程id
    private static Looper mMainLooper;//循环队列
    private static Handler mHandler;//主线程Handler
    private boolean isInit = false;
    public static String currentUserNick = "";

    /**
     * 重启当前应用
     */
    public static void restart() {
        Intent intent = myApplication.getPackageManager().getLaunchIntentForPackage(myApplication.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myApplication.startActivity(intent);
    }

    public static Context getContext() {
        return myApplication;
    }

    public static void setContext(Context mContext) {
        MyApplication.myApplication = myApplication;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static void setMainThread(Thread mMainThread) {
        MyApplication.mMainThread = mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        MyApplication.mMainThreadId = mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static void setMainThreadLooper(Looper mMainLooper) {
        MyApplication.mMainLooper = mMainLooper;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static void setMainHandler(Handler mHandler) {
        MyApplication.mHandler = mHandler;
    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication = this;
        LogcatHelper.getInstance(this).start();
        CrashHandler2.getInstance().init(this);
        mMainThread = Thread.currentThread();
        mMainThreadId = Process.myTid();
        mHandler = new Handler();



        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(false);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素


        UMConfigure.setLogEnabled(true);
        //初始化接口
        UMConfigure.init(this, Constant.UMENG_APPKEY
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

        //UM
        //微信
        PlatformConfig.setWeixin(Constant.WX_APPID, Constant.WX_APPSECRET);
        //豆瓣RENREN平台目前只能在服务器端配置
        //新浪
        PlatformConfig.setSinaWeibo("1896814987", "3f8945e37a1608b33f06003e33d81d06", "http://sns.whalecloud.com");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        PlatformConfig.setQQZone("101553247", "087f5d77a353832843e61cd07451f459");

        initEasemob();

        try {
            String version = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES).versionName;
            globalData.setVersion(version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        globalData.setDeviceUuid(DeviceUuidutil.getUniquePsuedoID());
        //初始化OSS
        OssServiceUtil.initOss(this);
    }

    /**
     *
     */
    private void initEasemob() {
        DemoHelper.getInstance().init(getApplicationContext());
        // 获取当前进程 id 并取得进程名
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        /**
         * 如果app启用了远程的service，此application:onCreate会被调用2次
         * 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
         * 默认的app会在以包名为默认的process name下运行，如果查到的process name不是app的process name就立即返回
         */
        if (processAppName == null || !processAppName.equalsIgnoreCase(myApplication.getPackageName())) {
            // 则此application的onCreate 是被service 调用的，直接返回
            return;
        }
        if (isInit) {
            return;
        }
        /**
         * SDK初始化的一些配置
         * 关于 EMOptions 可以参考官方的 API user_profiles1
         * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1chat_1_1_e_m_options.html
         */

        EMOptions options = new EMOptions();
        // 收到好友申请是否自动同意，如果是自动同意就不会收到好友请求的回调，因为sdk会自动处理，默认为true
        options.setAcceptInvitationAlways(true);
        // 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.setAutoTransferMessageAttachments(true);
        // 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true);
        // 设置自动登录
        options.setAutoLogin(false);//不要开启
        // 设置是否需要发送已读回执
        options.setRequireAck(true);
        // 设置是否需要发送回执，TODO 这个暂时有bug，上层收不到发送回执
        options.setRequireDeliveryAck(true);
        // 设置是否需要服务器收到消息确认
//        options.setRequireServerAck(true);

        // 设置是否自动接收加群邀请，如果设置了当收到群邀请会自动同意加入
        options.setAutoAcceptGroupInvitation(false);
        // 设置（主动或被动）退出群组时，是否删除群聊聊天记录
        options.setDeleteMessagesAsExitGroup(false);
        // 设置是否允许聊天室的Owner 离开并删除聊天室的会话
        options.allowChatroomOwnerLeave(true);

        //设置服务器ip
//        options.setIMServer();;
        //设置服务器端口号
//        options.setImPort();
        //设置其他服务器
//        options.setRestServer();

        //初始化
        EMClient.getInstance().init(myApplication, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
        EaseUI.getInstance().init(getApplicationContext(), options);
        // 设置初始化已经完成
        isInit = true;
    }

    /**
     * 根据Pid获取当前进程的名字，一般就是当前app的包名
     *
     * @param pID 进程的id
     * @return 返回进程的名字
     */
    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();

        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }




}
