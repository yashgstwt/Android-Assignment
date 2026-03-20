package com.theo.androidAssi;


import com.theo.androidAssi.model.Root;
import com.theo.androidAssi.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
        @GET("users")
        Single<Root> getUsers();
    }

