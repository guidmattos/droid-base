package com.guilhermeduartemattos.droidbase.service;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by guilhermeduartemattos on 6/4/15.
 */
public class RestClient {

    private static final long HTTP_TIMEOUT_MILI = 20000;
    private static final String END_POINT_URL = "http://tmp.eidoscode.com/cipher";
    private static API api;
    private static RestClient instance;
    private static Context context;

    public static RestClient getInstance(Context context){
        if (instance == null) {
            instance = new RestClient();
            instance.context = context;
            setupEndPoint();
        }
        return instance;
    }

    private RestClient(){}

    private static void setupEndPoint() {

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(HTTP_TIMEOUT_MILI, TimeUnit.MILLISECONDS);

        RestAdapter restAdapter =  new RestAdapter.Builder()
                .setEndpoint(END_POINT_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(client))
                .build();
        api = restAdapter.create(API.class);
    }

    public void getFruits(Callback callback) {
        api.getFruits(callback);
    }
}
