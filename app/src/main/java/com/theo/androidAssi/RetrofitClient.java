package com.theo.androidAssi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;

    private static final String URL = "https://dummyjson.com/";

    public static ApiService getRetrofit (){
        if(retrofit == null){
              retrofit = new Retrofit.Builder()
                      .baseUrl(URL)
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                      .build();
        }

        return retrofit.create(ApiService.class);

    }



}
