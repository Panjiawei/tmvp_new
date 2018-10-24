package com.cheng.simplemvp.activity.model;

import android.util.Log;

import com.cheng.simplemvp.MainBaseModel;
import com.cheng.simplemvp.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.internal.schedulers.IoScheduler;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainBaseModelImpl implements MainBaseModel {
    interface GitHubService {
        @GET("user.json")
        Observable<List<User>> getUser();
    }

    @Override
    public Observable<List<User>> getDataFromNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.icandemy.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(new IoScheduler()))
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        return gitHubService.getUser();
    }

    @Override
    public String getDataFromString() {
        return "string data";
    }

    @Override
    public void stopRequest() {
        Log.i("model-stopped", "MainBaseModelImpl stop request...");
    }
}
