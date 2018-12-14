package com.adorkable.acientdict.apis;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.adorkable.acientdict.apis.ApiConstants.DEFAULT_DOMAIN_NAME;


public class RetrofitClient {
    private Map<String, Retrofit> retrofitMap = new HashMap<>();
    private Map<String, OkHttpClient> clientMap = new HashMap<>();

    private static final long connectTimeoutMills = 10 * 1000L;
    private static final long readTimeoutMills = 10 * 1000L;

    private static RetrofitClient instance;

    private RetrofitClient() {

    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    /**
     * Author: liuqiang
     * Time: 2018-12-13 18:05
     * Description: 项目小,就一个域名
     */
    public static <S> S getService(Class<S> service) {
        return getInstance().getRetrofit(DEFAULT_DOMAIN_NAME, true).create(service);
    }

    public static <S> S getService(String baseUrl, Class<S> service) {
        return getInstance().getRetrofit(baseUrl, true).create(service);
    }

    private Retrofit getRetrofit(String baseUrl, boolean useRx) {
        if (TextUtils.isEmpty(baseUrl)) {
            throw new IllegalStateException("baseUrl can not be null");
        }
        if (retrofitMap.get(baseUrl) != null) return retrofitMap.get(baseUrl);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getClient(baseUrl))
                .addConverterFactory(GsonConverterFactory.create());
        if (useRx) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        }

        Retrofit retrofit = builder.build();
        retrofitMap.put(baseUrl, retrofit);
        return retrofit;
    }

    private OkHttpClient getClient(String baseUrl) {
        if (TextUtils.isEmpty(baseUrl)) {
            throw new IllegalStateException("baseUrl can not be null");
        }
        if (clientMap.get(baseUrl) != null) return clientMap.get(baseUrl);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(connectTimeoutMills, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeoutMills, TimeUnit.MILLISECONDS);

//        builder.cookieJar(cookieJar);

        OkHttpClient client = builder.build();
        clientMap.put(baseUrl, client);

        return client;
    }


    public static void clearCache() {
        getInstance().retrofitMap.clear();
        getInstance().clientMap.clear();
    }

}
