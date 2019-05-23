package com.wangzijie.nutrition_user.model.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.model.api.cookie.CookiesManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wangzijie.nutrition_user.model.api.ApiService.BASE_URL2;

/**
 * api retrofit工具类
 */
public class ApiStore {

    private final static String baseUrl = BASE_URL2;

//    static{
//        createProxy();
//    }

    private static Retrofit retrofit;
    private static volatile ApiService mService;

    //    public static <T> T createApi(Class<T> service) {
//        return retrofit.create(service);
//    }


    public static synchronized ApiService getService() {
        if (mService == null) {
            synchronized (ApiStore.class) {
                if (mService == null) {
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                            .connectTimeout(Constant.HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(Constant.HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(Constant.HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(new HttpLoggingInterceptor())
                            .cookieJar(new CookiesManager());

                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                    mService = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(builder.build())
                            .build().create(ApiService.class);
                }
            }
        }
        return mService;
    }


    /**
     * 创建 retrofit客户端
     */
//    private static void createProxy() {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//
//        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request original = chain.request();
//                        Request.Builder requestBuilder = original.newBuilder();
//                        Request request = requestBuilder.build();
//                        return chain.proceed(request);
//                    }
//                })
//                .addInterceptor(new HttpLoggingInterceptor())
//                .cookieJar(new CookiesManager());
///*        SSLSocketFactory sslSocketFactory = getSSLSocketFactory(new Buffer().writeUtf8(Constant.SSL_KEY).inputStream(),
//                new Buffer().writeUtf8(Constant.MIDDLE_KEY).inputStream());
//        if (sslSocketFactory != null){
//
//        }*/
//        retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(builder.build())
//                .build();
//    }

    /**
     * ssl 工厂类
     *
     * @param certificates certificates
     * @return SSLSocketFactory
     */
//    private static SSLSocketFactory getSSLSocketFactory(InputStream... certificates) {
//        try {
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(null);
//            int index = 0;
//            for (InputStream certificate : certificates) {
//                String certificateAlias = Integer.toString(index++);
//                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
//
//                try {
//                    if (certificate != null) {
//                        certificate.close();
//                    }
//                } catch (IOException e) {
//                }
//            }
//
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//
//            TrustManagerFactory trustManagerFactory =
//                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//
//            trustManagerFactory.init(keyStore);
//            sslContext.init
//                    (
//                            null,
//                            trustManagerFactory.getTrustManagers(),
//                            new SecureRandom()
//                    );
//            return sslContext.getSocketFactory();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
