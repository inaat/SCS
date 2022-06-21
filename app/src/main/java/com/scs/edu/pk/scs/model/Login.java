package com.scs.edu.pk.scs.model;

import com.google.gson.annotations.SerializedName;

public class Login {


    @SerializedName("token")
    private String token;


    public Login(String token) {
        this.token = token;

    }

    public String getToken() {
        return token;
    }
}
