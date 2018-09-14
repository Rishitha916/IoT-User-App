package com.dushan.rishitha.iotuserapplication;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Rishitha on 2/13/2018.
 */

public class ConnectionDetector {
    Context context;
    public  ConnectionDetector(Context context){this.context = context;}
    public boolean isConnected(){
        ConnectivityManager CM = (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(CM != null){
            NetworkInfo info = CM.getActiveNetworkInfo();
            if(info != null){
                if(info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return  false;
    }
}
