package com.dushan.rishitha.iotuserapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.dushan.rishitha.iotuserapplication.model.getMemberLocModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import  com.dushan.rishitha.iotuserapplication.model.getMemberLocModel;

public class members extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        // get member ifo from api
        SessionHandler session = new SessionHandler(getApplicationContext());
        String userId = session.getuserid();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<getMemberLocModel>> call = apiInterface.getMemberLoc(userId);

        call.enqueue(new Callback<List<getMemberLocModel>>() {
            @Override
            public void onResponse(Call<List<getMemberLocModel>> call, Response<List<getMemberLocModel>> response) {
                showdata(response.body());

            }

            @Override
            public void onFailure(Call<List<getMemberLocModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection Fail... Try Again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showdata(final List<getMemberLocModel> getMemberLocModel1) {
        TextView m1 = (TextView) findViewById(R.id.textView6);
        TextView m2 = (TextView) findViewById(R.id.textView7);
        TextView m3 = (TextView) findViewById(R.id.textView8);
        TextView m4 = (TextView) findViewById(R.id.textView12);

        m1.setText(getMemberLocModel1.get(0).getEmail());
        m2.setText(getMemberLocModel1.get(1).getEmail());
        m3.setText(getMemberLocModel1.get(2).getEmail());
        m4.setText(getMemberLocModel1.get(4).getEmail());

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat1 = Double.parseDouble(getMemberLocModel1.get(0).getLat());
                double log1 = Double.parseDouble(getMemberLocModel1.get(0).getLog());
                Intent intent = new Intent(members.this, MapsActivity.class);
                Bundle extras = new Bundle();
                extras.putDouble("lat", lat1);
                extras.putDouble("log", log1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat1 = Double.parseDouble(getMemberLocModel1.get(1).getLat());
                double log1 = Double.parseDouble(getMemberLocModel1.get(1).getLog());
                Intent intent = new Intent(members.this, MapsActivity.class);
                Bundle extras = new Bundle();
                extras.putDouble("lat", lat1);
                extras.putDouble("log", log1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat1 = Double.parseDouble(getMemberLocModel1.get(2).getLat());
                double log1 = Double.parseDouble(getMemberLocModel1.get(2).getLog());
                Intent intent = new Intent(members.this, MapsActivity.class);
                Bundle extras = new Bundle();
                extras.putDouble("lat", lat1);
                extras.putDouble("log", log1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat1 = Double.parseDouble(getMemberLocModel1.get(3).getLat());
                double log1 = Double.parseDouble(getMemberLocModel1.get(3).getLog());
                Intent intent = new Intent(members.this, MapsActivity.class);
                Bundle extras = new Bundle();
                extras.putDouble("lat", lat1);
                extras.putDouble("log", log1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });



    }
}
