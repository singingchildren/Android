package com.wangzijie.nutrition_user.model.api;

import android.content.Context;
import android.util.Log;

import com.wangzijie.nutrition_user.MyApplication;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * @author WangZequan
 * @time 2019/5/3  19:30
 * @describe okhttp 拦截器
 */
public class HttpLoggingInterceptor implements Interceptor {

    private final Charset UTF8 = Charset.forName("UTF-8");
    private Context context = null;

    public HttpLoggingInterceptor(Context context) {
        this.context = context;
    }

    public HttpLoggingInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();
//        Headers headers = request.headers();
//        for (String name : headers.names()) {
//            request.newBuilder().addHeader(name, headers.get(name));
//        }
        Request request1 = request.newBuilder().addHeader("Content-Type",
                "application/json")
//                .addHeader("Accept"," application/json")
                .addHeader("token", MyApplication.globalData.getToken())
                .addHeader("appId", MyApplication.globalData.getDeviceUuid())
                .addHeader("appType", "android").build();
        Log.v("OKHttp拦截器ljq,headers:", request1.headers().toString());
        Log.d("OKHttp拦截器ljq,url:", request.url().toString());
        if (requestBody != null) {
            String body = null;
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            body = buffer.readString(UTF8);
            buffer.clone();
            Log.w("OKHttp拦截器ljq,请求体:", body);
        }

        Response response = chain.proceed(request1);
        String responseBody = response.body().string();

        e("OKHttp拦截器,响应体ljq:", responseBody);
        return  response
                .newBuilder()
                .request(request1)
                .body(ResponseBody.create(MediaType.parse("UTF-8"), responseBody))
                .build();
    }

    public static void e(String tag, String msg) {  //信息太长,分段打印
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.e(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.e(tag, msg);
    }

}
