package com.dushan.rishitha.iotuserapplication.model;

import com.google.gson.annotations.SerializedName;

public class sendLoc {

    @SerializedName("userid")
    private String userId;
    @SerializedName("Latitude")
    private double lat;
    @SerializedName("Longitude")
    private double log;


    public sendLoc(String userId, double lat, double log) {
        this.userId = userId;
        this.lat = lat;
        this.log = log;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }
}
