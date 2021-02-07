package com.example.instantexg.webservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface api {
    @GET("json/all/{typeCoin}")
    Call<ResponseBody> typeCoinAll(@Path("typeCoin") String typeCoin);
}

