package com.scs.edu.pk.scs.model;

import java.io.Serializable;

public class Login implements Serializable {


    private String token;

    private String studentId ;

    private String fullName ;
    private  String userEmail;
    private  String userImage;

    public Login(String token, String studentId, String fullName, String userEmail, String userImage) {
        this.token = token;
        this.studentId = studentId;
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.userImage = userImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
