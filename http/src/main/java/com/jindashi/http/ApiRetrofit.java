package com.jindashi.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * API请求接口管理
 *
 * @author zhang.zheng
 * @version 2018-01-05
 */
public class ApiRetrofit {

    private static final String TAG = ApiRetrofit.class.getSimpleName();

    private OkHttpClient mOkHttpClient;

    private static volatile ApiRetrofit mApiRetrofit;

    private static String mVersion;
    private static String mChannel;

    private ApiRetrofit() {

    }

    public static void init(String version, String channel) {
        mVersion = version;
        mChannel = channel;
    }

    public static ApiRetrofit getInstance() {
        if (mApiRetrofit == null) {
            synchronized (ApiRetrofit.class) {
                if (mApiRetrofit == null) {
                    mApiRetrofit = new ApiRetrofit();
                }
            }
        }
        return mApiRetrofit;
    }

//    public Retrofit getRetrofit(String baseUrl) {
////        return new Retrofit.Builder()
////                .baseUrl(baseUrl)
////                .addConverterFactory(GsonConverterFactory.create())      //json
////                //.addConverterFactory(ProtoConverterFactory.create())   //proto
////                //.addConverterFactory(ScalarsConverterFactory.create()) //字符串
////                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
////                .client(getOkHttpClient())
////                .build();
//    }

    public OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = createHttpClient();
        }
        return mOkHttpClient;
    }


    private OkHttpClient createHttpClient() {
        // 日志拦截器
//        HttpLoggingInterceptor mLogInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//
//            @Override
//            public void log(@NonNull String message) {
//                LogUtils.d(TAG, "request result: = " + message);
//            }
//        });
//        if (AppConfig.DEBUG) {
//            mLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        } else {
//            mLogInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
//        }

        // SSL无证书校验，全信任
        HttpSSLUtils.SSLParams sslParams = HttpSSLUtils.getSslSocketFactory(null, null, null);

        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .connectTimeout(20, TimeUnit.SECONDS) //15
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
//                .addInterceptor(new CommonInterceptor(HttpURL.getCmsBaseURL(), mVersion, mChannel))
                .addInterceptor(new LogInterceptor())
//                .addInterceptor(new QuoteTokenInterceptor())
                .hostnameVerifier(sslParams.getUnSafeHostnameVerifier())
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
    }

}
