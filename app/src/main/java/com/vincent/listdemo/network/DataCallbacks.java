package com.vincent.listdemo.network;

import android.util.Log;

import com.vincent.listdemo.callbacks.OnDataGetCallback;
import com.vincent.listdemo.model.ApiUrls;
import com.vincent.listdemo.model.ItemsUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class DataCallbacks implements ApiUrls {

    private static final String TAG = "DataCallbacks";

    private static ApiInterface getApiInterface(String baseUrl) {
        return WebAgent.getRetrofit(baseUrl).create(ApiInterface.class);
    }

    private static<Item> void enqueue(Call<Item> call, final OnDataGetCallback<Item> callback) {
        Log.i(TAG, "Call URL: " + call.request().url().toString());

        call.enqueue(new Callback<Item>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Log.d(TAG, "Call onResponse!!! "
                        + "\nMessage: " + response.message()
                        + " IsSuccessful: " + response.isSuccessful());

                if (response.isSuccessful()) {
                    callback.onDataGet(response.body());
                }
                else {
                    callback.onDataGetFailed(response.message());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e(TAG, "Call onFailure!!!\n" + t.getMessage());
                callback.onDataGetFailed(t.getMessage());
            }
        });
    }

    public static void getUserData(int page, OnDataGetCallback<ItemsUser> callback) {
        Call<ItemsUser> call = getApiInterface(API_BASE).getUserList(page);

        enqueue(call, callback);
    }
}
