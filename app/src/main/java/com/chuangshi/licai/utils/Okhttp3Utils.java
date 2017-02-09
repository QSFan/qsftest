package com.chuangshi.licai.utils;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/7.
 */
public class Okhttp3Utils {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 使用post请求，返回Json字符串
     *
     * @param url  访问的url
     * @param json 需要解析的json
     * @return
     * @throws IOException
     */
    public static void post(String url, String json, Callback callback){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
       okHttpClient.newCall(request).enqueue(callback);
    }


    /**
     * 同步请求方法
     *
     * @return
     */
    public static String getSync(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            // 响应码 = 200
            if (response.isSuccessful()) {
                return response.body().string();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get异步请求
     * @param callback
     * @param url
     */
    public static void getASync(Callback callback, String url) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
