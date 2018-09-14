package com.dushan.rishitha.iotuserapplication.model;

/**
 * Created by Rishitha on 1/27/2018.
 */

import com.google.gson.annotations.SerializedName;

public class LoginModel {
//    @SerializedName("email")
//    private String email;
//    @SerializedName("password")
//    private String password;
    @SerializedName("userid")
    private String userId;
    @SerializedName("status")
    private String Status;

    public LoginModel(String userId, String Status){
        this.userId=userId;
        this.Status=Status;
    }

//    public String getEmail() {return email;}
//    public void setEmail(String email) {this.email = email;}
//
//    public String getPassword() {return password;}
//    public void setPassword(String password) {this.password = password;}

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public String getStatus(){return Status;}
    public void setStatus(String Status){this.Status = Status;}

}