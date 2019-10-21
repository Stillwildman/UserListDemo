package com.vincent.listdemo.network;

import com.vincent.listdemo.model.ApiUrls;
import com.vincent.listdemo.model.ItemsUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(ApiUrls.API_USER)
    Call<ItemsUser> getUserList(@Query("page") int page);

}
