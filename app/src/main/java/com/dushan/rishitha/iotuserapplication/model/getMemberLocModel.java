package com.dushan.rishitha.iotuserapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rishitha on 1/27/2018.
 */

public class getMemberLocModel {
    @SerializedName("userId")
    private String userId;
    @SerializedName("email")
    private String email;
    @SerializedName("lat")
    private String lat;
    @SerializedName("log")
    private String log;

    public getMemberLocModel(){}

    public getMemberLocModel(String userId, String email, String lat, String log){
        this.userId = userId;
        this.email = email;
        this.lat = lat;
        this.log = log;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }
    public void setLog(String log) {
        this.log = log;
    }

}
