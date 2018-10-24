package com.cheng.simplemvp.Http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andriod_pan on 2018/7/10.
 */

public class RetrofitFactory {

    private static RetrofitFactory mRetrofitFactory;
    private static  ApiService mAPIFunction;
    private RetrofitFactory(){
        OkHttpClient mOkHttpClient=new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)//读取超时
                .readTimeout(40, TimeUnit.SECONDS)//连接超时
                .writeTimeout(40, TimeUnit.SECONDS)//写入超时
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build();
        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
        mAPIFunction=mRetrofit.create(ApiService.class);

    }

    public static RetrofitFactory getInstence(){
        if (mRetrofitFactory==null){
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null)
                    mRetrofitFactory = new RetrofitFactory();
            }

        }
        return mRetrofitFactory;
    }
    public  ApiService API(){
        return mAPIFunction;
    }


    public RequestBody map2RequestBody(HashMap map){
        Log.e("map2request","--------------------------------");
//        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String s_json = gson.toJson(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),s_json);
        return requestBody;
    }

}
