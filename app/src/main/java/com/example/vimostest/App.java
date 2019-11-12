package com.example.vimostest;

import android.app.Application;

import com.example.vimostest.ApiService.ApiService;
import com.example.vimostest.ApiService.RetrofitService;

public class App extends Application {

    private static App instance;
    private ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        apiService = RetrofitService.getClient().create(ApiService.class);
    }

    public static App getInstance() {
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
