package com.dtstack.alter.dome;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.util.concurrent.TimeUnit;

public class HttpUtil {

    private static OkHttpClient client;

    private static final int CONNECT_TIMEOUT = 5;

    private static final int READ_TIMEOUT = 7;

    /**
     * 单例模式  获取类实例
     *
     * @return client
     */
    private static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return client;
    }

    public static String doGet(String url) {

        try {
            long startTime = System.currentTimeMillis();

            Request request = new Request.Builder().url(url).build();
            // 创建一个请求
            Response response = getInstance().newCall(request).execute();
            int httpCode = response.code();
            String result;
            ResponseBody body = response.body();
            if (body != null) {
                result = body.string();
            } else {
                throw new RuntimeException("exception in OkHttpUtil,response body is null");
            }
            return handleHttpResponse(httpCode, result);
        } catch (Exception ex) {
            return "";
        }
    }

    private static String handleHttpResponse(int httpCode, String result){
        if (httpCode == 200) {
            return result;
        }
        return "错误拉";
    }


}



