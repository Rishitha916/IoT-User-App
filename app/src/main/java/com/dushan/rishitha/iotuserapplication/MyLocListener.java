package com.dushan.rishitha.iotuserapplication;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Rishitha on 1/19/2018.
 */

public class MyLocListener implements LocationListener{

    @Override
    public void onLocationChanged(Location location){

        if (location !=null){

            Log.e("Latitude :", "" + location.getLatitude());
            Log.e("Longitude :", "" + location.getLongitude());
        }


    }
    @Override
    public void onProviderEnabled(String provider){

    }

    @Override
    public void onProviderDisabled(String provider){

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }

}
