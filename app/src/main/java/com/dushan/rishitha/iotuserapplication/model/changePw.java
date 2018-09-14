package com.dushan.rishitha.iotuserapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rishitha on 1/28/2018.
 */

public class changePw {
    @SerializedName("currentpw")
    private String currentPw;
    @SerializedName("userid")
    private String userId;
    @SerializedName("newpw")
    private String newPw;

    public  changePw(String currentPw, String userId, String newPw){
        this.userId= userId;
        this.currentPw= currentPw;
        this.newPw= newPw;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrentPw() {
        return currentPw;
    }

    public void setCurrentPw(String currentPw) {
        this.currentPw = currentPw;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }




}
