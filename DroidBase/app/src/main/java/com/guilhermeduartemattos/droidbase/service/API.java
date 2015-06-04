package com.guilhermeduartemattos.droidbase.service;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by guilhermeduartemattos on 6/4/15.
 */
public interface API {

    @GET("/ws.json")
    public void getFruits(Callback<JsonObject> callback);
}
