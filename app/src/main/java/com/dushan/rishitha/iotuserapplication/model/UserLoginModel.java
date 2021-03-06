package com.dushan.rishitha.iotuserapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Rishitha on 2/13/2018.
 */

public class UserLoginModel implements Serializable {
    @SerializedName("email")
    @Expose
    private
    String email;
    @SerializedName("password")
    @Expose
    private
    String password;

    public UserLoginModel(String email,String password){
        this.email=email;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
