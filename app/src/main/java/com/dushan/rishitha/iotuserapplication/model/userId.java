package com.dushan.rishitha.iotuserapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rishitha on 2/18/2018.
 */

public class userId {
    @SerializedName("userid")
    private String userId;


    public userId(String userId){
        this.userId=userId;
    }

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

}
