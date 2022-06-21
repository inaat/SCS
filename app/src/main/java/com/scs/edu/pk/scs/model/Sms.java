package com.scs.edu.pk.scs.model;

import com.google.gson.annotations.SerializedName;

public class Sms {



    @SerializedName("sms_body")
    private String sms_body;
    @SerializedName("mobile")
    private String mobile;

    public Sms(String sms_body) {
        this.sms_body = sms_body;
        this.mobile=mobile;
    }

    public String getSmsBody() {
        return sms_body;
    }


    public String getMobile() {
        return mobile;
    }
}
