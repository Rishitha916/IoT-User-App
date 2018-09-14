package com.dushan.rishitha.iotuserapplication;

import com.dushan.rishitha.iotuserapplication.model.LoginModel;
import com.dushan.rishitha.iotuserapplication.model.UserLoginModel;
import com.dushan.rishitha.iotuserapplication.model.deviceData;
import com.dushan.rishitha.iotuserapplication.model.getMemberLocModel;
import com.dushan.rishitha.iotuserapplication.model.sendLoc;
import com.dushan.rishitha.iotuserapplication.model.changePw;
import java.util.List;

import retrofit2.Call;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.dushan.rishitha.iotuserapplication.model.userId;

/**
 * Created by Rishitha on 1/27/2018.
 */

public interface ApiInterface {
    //@POST("api/UserAppLogin")

    @POST("api/userlogin")
    Call<LoginModel> getLogin(@Body UserLoginModel userLoginModel);
    @POST("api/memberLoc")
    Call<List<getMemberLocModel>> getMemberLoc(@Query("userId") String id);
    @POST("api/getcomponents")
  //  Call<List<deviceData>> getDeviceData(@Query("userId") String id);
    Call<deviceData> getDeviceData(@Body userId UserId);
    @POST("api/reset")
    Call<ResponseBody> changePw(@Body changePw changePw);
    @POST("api/location")
    Call<ResponseBody> sendLoc(@Body sendLoc sendLoc);

}
//    @GET("api/UserAppLogin")
//    Call<LoginModel> getLogin(@Query("email") String email, @Query("password") String password);
//    @GET("api/memberLoc")
//    Call<List<getMemberLocModel>> getMemberLoc(@Query("userId") String id);
//    @GET("api/getComponent")
//    Call<List<deviceData>> getDeviceData(@Query("userId") String id);
//    @POST("api/changePw")
//    Call<ResponseBody> changePw(@Body changePw changePw);
//    @POST("api/addLocation")
//    Call<ResponseBody> sendLoc(@Body sendLoc sendLoc);
