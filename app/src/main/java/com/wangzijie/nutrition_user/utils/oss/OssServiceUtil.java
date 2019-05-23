package com.wangzijie.nutrition_user.utils.oss;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.lzy.imagepicker.bean.ImageItem;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.OSSBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import se.emilsjolander.stickylistheaders.BuildConfig;

/**
 * @author WangZequan
 * @time 2019/5/4 0:12
 * @describe
 */
public class OssServiceUtil {

    public static final String UPLOAD_FILE_LIST_TYPE1 = "listType1";
    public static final String UPLOAD_FILE_LIST_TYPE2 = "llistType2";
    private static final String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
    public static final int MAX_CONCURRENT_REQUEST=5;
    private static String bucketName;
    private static ExecutorService uploadThreadPool = Executors.newFixedThreadPool(MAX_CONCURRENT_REQUEST);
    private static Application application;
    private static OSSBean ossBean = new OSSBean();
    private static Handler handler = new Handler();

    static {
        System.loadLibrary("native-lib");
    }

    /**
     *  用C获得微秒值数组
     */
    public static native long[] getMicroseconds();

    /**
     * 获得微秒字符串
     *
     * @return
     */
    public static String getMicrosecondsString() {
        long[] microseconds = getMicroseconds();
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < microseconds.length; i++) {
            sbr.append(microseconds[i] + "");
        }
        while (sbr.length() < 16) {
            sbr.append("0");
        }
        return sbr.toString();
//        return System.currentTimeMillis()+"";
    }

    /**
     * @return
     */
    public static OSS init() {
        try {
            OSSBean ossBean = ApiStore.getService()
                    .getOSS().execute().body();
            if (ossBean.getData() != null) {
                MyApplication.globalData.setOssNetworksuccess(true);
                OssServiceUtil.ossBean = ossBean;
            } else {
                MyApplication.globalData.setOssNetworksuccess(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //if null , default will be init
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(5 * 1000); // connction time out default 15s
        conf.setSocketTimeout(5 * 1000); // socket timeout，default 15s
        conf.setMaxConcurrentRequest(MAX_CONCURRENT_REQUEST); // synchronous request number，default 5
        conf.setMaxErrorRetry(1); // retry，default 2
        if (BuildConfig.DEBUG) OSSLog.enableLog(); //write local log file ,path is SDCard_path\OSSLog\logs.csv

        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(ossBean.getData().getAccessKeyId(), ossBean.getData().getAccessKeySecret(), ossBean.getData().getSecurityToken());

        OSS oss = new OSSClient(application, ENDPOINT, credentialProvider, conf);
        OssServiceUtil.bucketName = ossBean.getData().getBucketName();
        return oss;
    }

    public static void initOss(Application application) {
        OssServiceUtil.application = application;
    }

    /**
     * 将文件上传到阿里云OSS服务器
     * 没封住好,先对付着用着
     *
     * @param objectKeySuffix oss上所存储文件的名称后缀 .jpg
     * @param uploadFilePaths 本地存储文件的路径的集合 ArrayList<HashMap<String(列表类型), String(文件path)>>
     * @param callBack        回调
     */
    public static void upload(String objectKeySuffix, ArrayList<HashMap<String, String>> uploadFilePaths, CallBack2 callBack) {
        ArrayList<String> urlList1 = new ArrayList<>();
        ArrayList<String> urlList2 = new ArrayList<>();
        for (HashMap<String, String> uploadFilePath : uploadFilePaths) {
            uploadThreadPool.execute(() -> {
                HashMap<String, String> pathMap = uploadFilePath;
                String type = "";
                String path = "";
                StringBuffer objectKey = new StringBuffer();
                if (MyApplication.globalData.isNutritionist()) {
                    objectKey.append("dietician/");
                } else {
                    objectKey.append("customer/");
                }
                for (String key : uploadFilePath.keySet()) {
                    type = key;
                    path = pathMap.get(key);
                }
                String[] fileName = new File(path).getName().split(".");
                if (fileName != null && fileName.length == 2) {
                    objectKey.append(type)
                            .append(getMicrosecondsString())
                            .append(".")
                            .append(fileName[1]);

                } else {
                    objectKey.append(type)
                            .append(getMicrosecondsString())
                            .append(objectKeySuffix);
                }
                final OSS[] oss = {init()};
                if (oss[0] == null) {
                    handler.post(() -> callBack.ossUploadFailed("OSS参数获取失败,无法上传图片"));
                    return;
                }
                // 构造上传请求
                PutObjectRequest put = new PutObjectRequest(bucketName, objectKey.toString(), path);
                // 异步上传时可以设置进度回调
                put.setProgressCallback((request, currentSize, totalSize) -> Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize));
                OSSAsyncTask task = oss[0].asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                        //http://jzjsclub.oss-cn-beijing.aliyuncs.com/dietician/llistType21557063664780309.jpg
                        //api获取url很麻烦,还不如自己拼接
                        StringBuffer stringBuffer = new StringBuffer();
                        String imageUrl = stringBuffer
                                .append("http://")
                                .append(bucketName)
                                .append(".")
                                .append("oss-cn-beijing.aliyuncs.com/")
                                .append(objectKey.toString())
                                .toString();
                        Log.d("ossUpload,imageUrl:", imageUrl);
                        if (imageUrl.contains(UPLOAD_FILE_LIST_TYPE1)) {
                            urlList1.add(imageUrl);
                        } else if (imageUrl.contains(UPLOAD_FILE_LIST_TYPE2)) {
                            urlList2.add(imageUrl);
                        }
                        if (urlList1.size() + urlList2.size() == uploadFilePaths.size()) {
                            handler.post(() -> callBack.ossUploadSucceed(urlList1, urlList2));
                            Log.d("ossUpload,imageUrl:", "上传文件成功");
                        }
                    }

                    @Override
                    public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                        // 请求异常
                        if (clientExcepion != null) {
                            // 本地异常如网络异常等
                            clientExcepion.printStackTrace();
                            handler.post(() -> callBack.ossUploadFailed("本地异常如网络异常等"));
                            Log.e("ossUpload,Error", "本地异常如网络异常等" + clientExcepion.getMessage());
                        }
                        if (serviceException != null) {
                            // 服务异常
                            handler.post(() -> callBack.ossUploadFailed(serviceException.getRawMessage()));
                        }
                    }
                });
                task.waitUntilFinished(); // 可以等待任务完成
            });
        }

    }


    public static void upload(String objectKeySuffix, ArrayList<ImageItem> imageItemList , CallBack1 callBack){
        ArrayList<HashMap<String, String>> uploadFilePaths=new ArrayList<>();
        for (ImageItem item : imageItemList) {//选填字段不做要求
            if (!TextUtils.isEmpty(item.path)) {
                HashMap<String, String> urlMap = new HashMap();
                urlMap.put(OssServiceUtil.UPLOAD_FILE_LIST_TYPE1, item.path);
                uploadFilePaths.add(urlMap);
            }
        }
        upload(objectKeySuffix,uploadFilePaths, new CallBack2() {
            @Override
            public void ossUploadSucceed(ArrayList<String>... urlList) {
                callBack.ossUploadSucceed(urlList[0]);
            }

            @Override
            public void ossUploadFailed(String error) {
                callBack.ossUploadFailed(error);
            }
        });
    }


    public static void uploadCancel() {
        // task.cancel(); // 可以取消任务
    }

    public interface CallBack2 {
        void ossUploadSucceed(ArrayList<String>... urlList);

        void ossUploadFailed(String error);
    }
    public interface CallBack1 {
        void ossUploadSucceed(ArrayList<String> urlList);

        void ossUploadFailed(String error);
    }
}
