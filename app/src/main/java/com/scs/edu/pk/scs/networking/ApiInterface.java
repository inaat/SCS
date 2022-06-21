package com.scs.edu.pk.scs.networking;

import com.scs.edu.pk.scs.Constant;
import com.scs.edu.pk.scs.model.Login;
import com.scs.edu.pk.scs.model.Results;
import com.scs.edu.pk.scs.model.Sms;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    //for login
    @FormUrlEncoded
    @POST("login")
    Call<Login> login(
            @Field(Constant.KEY_EMAIL) String email,
            @Field(Constant.KEY_PASSWORD) String password);


    @GET("sms")
    Call<List<Sms>> getSmsList() ;



}