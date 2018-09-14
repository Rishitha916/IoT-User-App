//package com.dushan.rishitha.iotuserapplication;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
//
//import com.dushan.rishitha.iotuserapplication.model.sendLoc;
//
//
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by Rishitha on 1/27/2018.
// */
//
//public class trackLocation extends AppCompatActivity {
//    public static double lat;
//    public static  double log;
//    static  final int REQUEST_LOCATION = 1;
//    public Location location;
//
//    LocationManager locationManager =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
////    String lat1 = Double.toString(lat);
////    String log1= Double.toString(log);
//
//
//    public void getLocation(){
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
//        }
//        else if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30000, 10, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    lat = location.getLatitude();
//                    log = location.getLongitude();
//                    senLoc(lat,log);
//
//                    // AddData();
//                    //((EditText)findViewById(R.id.editText_lat)).setText("Latitude :" + lat);
//                    //((EditText)findViewById(R.id.editText_log)).setText("Longitude :" + log);
//
//                }
//
//                @Override
//                public void onStatusChanged(String s, int i, Bundle bundle) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String s) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String s) {
//
//                }
//            });
//        }
//
//        else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 10, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//
//                    lat = location.getLatitude();
//                    log = location.getLongitude();
//                    senLoc(lat,log);
//
//                    // AddData();
//                    // ((EditText)findViewById(R.id.editText_lat)).setText("Latitude :" + lat);
//                    //((EditText)findViewById(R.id.editText_log)).setText("Longitude :" + log);
//                }
//
//                @Override
//                public void onStatusChanged(String s, int i, Bundle bundle) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String s) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String s) {
//
//                }
//            });
//
//        }}
//        public void senLoc(double lat, double log ) {
//        SessionHandler session = new SessionHandler(getApplicationContext());
////        String lat1 = Double.toString(lat);
////            String log1 = Double.toString(log);
//            sendLoc sendLoc1 = new sendLoc(userId, lat, log);
//            sendLoc1.setUserId(session.getuserid());
//            sendLoc1.setLat(lat);
//            sendLoc1.setLog(log);
//            ApiInterface apiInterface;
//
//            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//            Call<ResponseBody> call = apiInterface.sendLoc(sendLoc1);
//
//            call.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                }
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                }
//            });
//
//        }
//    }
//
