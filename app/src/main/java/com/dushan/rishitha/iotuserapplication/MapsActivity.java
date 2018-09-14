package com.dushan.rishitha.iotuserapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle extras = getIntent().getExtras();
        double lat1 = extras.getDouble("lat");
        double log1 = extras.getDouble("log");

        SharedPreferences sp = getSharedPreferences("loc",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sp.edit();
        editor.putString("lat",Double.toString(lat1));
        editor.putString("log",Double.toString(log1));
        editor.commit();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        SharedPreferences sp = getSharedPreferences("loc",Context.MODE_PRIVATE);

        double lat = Double.parseDouble(sp.getString("lat", ""));
        double log = Double.parseDouble(sp.getString("log", ""));

        // Add a marker in Sydney and move the camera
        LatLng loc = new LatLng(lat, log);
        mMap.addMarker(new MarkerOptions().position(loc).title("Marker in loc"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}
