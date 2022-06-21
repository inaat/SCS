package com.scs.edu.pk.scs.networking;

import com.scs.edu.pk.scs.model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //String BASE_URL = "https://simplifiedcoding.net/demos/";
    String BASE_URL = "http://192.168.1.25/hrm/public/api/";
    @GET("roles")
    Call<List<Results>> getsuperHeroes();
}

    //String BASE_URL = "http://192.168.1.25/hrm/public/api/";
//@GET("roles")