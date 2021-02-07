package com.example.instantexg.webservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiConfig {
    private static final String urlOrigin = "https://economia.awesomeapi.com.br/";
    private static final OkHttpClient clientTimeoutLimit =
            new OkHttpClient.
                    Builder().
                    connectTimeout(10, TimeUnit.SECONDS).
                    readTimeout(10, TimeUnit.SECONDS).
                    writeTimeout(10, TimeUnit.SECONDS).
                    build();

    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(urlOrigin).client(clientTimeoutLimit).addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);

    }



}