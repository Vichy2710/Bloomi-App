package com.example.bloomi.API;

import com.example.bloomi.Detail.auth_controller.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IAPIService {
    // url: https://bloomi.herokuapp.com/api/v1/auth/signin

    IAPIService apiService = new Retrofit.Builder()
            .baseUrl("https://bloomi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IAPIService.class);
    @FormUrlEncoded
    @POST("api/v1/auth/signin")
    Call<Account> postAccountSignIn(
            @Field("emailOrPhone") String emailOrPhone,
            @Field("password") String password
    );
}
