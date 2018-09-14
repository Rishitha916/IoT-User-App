package com.dushan.rishitha.iotuserapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


import com.dushan.rishitha.iotuserapplication.model.LoginModel;
import com.dushan.rishitha.iotuserapplication.model.deviceData;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import  com.dushan.rishitha.iotuserapplication.model.userId;

public class devices extends Activity {
    TextView tx_device_data;
    String json_string;
    //JSONObject jsonObject;
    //JSONArray jsonArray;
    ListView listView;
    private ApiInterface apiInterface;
    SessionHandler session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);


        session = new SessionHandler(getApplicationContext());
        String userId = session.getuserid();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<deviceData> call = apiInterface.getDeviceData(new userId(userId));
        Log.i("Tag UserId", new userId(userId).getUserId());

        call.enqueue(new Callback <deviceData>() {
            @Override
            public void onResponse(Call<deviceData> call, Response<deviceData> response) {
                    showdata(response.body());
                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<deviceData> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Connection Fail... Try Again", Toast.LENGTH_SHORT).show();
            }
        });}


    public void showdata(deviceData deviceData1){
        TextView a1= (TextView) findViewById(R.id.textView5) ;
        TextView a2= (TextView) findViewById(R.id.textView14) ;
        TextView a3= (TextView) findViewById(R.id.textView15) ;
        TextView a4= (TextView) findViewById(R.id.textView16) ;

        TextView b1= (TextView) findViewById(R.id.textView17) ;
        TextView b2= (TextView) findViewById(R.id.textView18) ;
        TextView b3= (TextView) findViewById(R.id.textView19) ;
        TextView b4= (TextView) findViewById(R.id.textView20) ;

        TextView c1= (TextView) findViewById(R.id.textView21) ;
        TextView c2= (TextView) findViewById(R.id.textView22) ;
        TextView c3= (TextView) findViewById(R.id.textView23) ;
        TextView c4= (TextView) findViewById(R.id.textView24) ;

        TextView d1= (TextView) findViewById(R.id.textView25) ;
        TextView d2= (TextView) findViewById(R.id.textView26) ;
        TextView d3= (TextView) findViewById(R.id.textView27) ;
        TextView d4= (TextView) findViewById(R.id.textView28) ;

        int length= deviceData1.getArray().size();
        switch (length){
            case 1:
                if (deviceData1.getArray().get(0).getName()!= null) {
                    a1.setText( deviceData1.getArray().get(0).getId());
                    a2.setText("device name"+deviceData1.getArray().get(0).getName());
                    a3.setText("current value"+deviceData1.getArray().get(0).getCurrentValue());
                    a4.setText(deviceData1.getArray().get(0).getUnit());
                }
                break;
            case 2:
                if (deviceData1.getArray().get(0).getName()!= null) {
                    a1.setText( deviceData1.getArray().get(0).getId());
                    a2.setText("device name"+deviceData1.getArray().get(0).getName());
                    a3.setText("current value"+deviceData1.getArray().get(0).getCurrentValue());
                    a4.setText(deviceData1.getArray().get(0).getUnit());
                }

                if (deviceData1.getArray().get(1).getName()!= null) {
                    b1.setText(deviceData1.getArray().get(1).getId());
                    b2.setText("device name"+deviceData1.getArray().get(1).getName());
                    b3.setText("current value"+deviceData1.getArray().get(1).getCurrentValue());
                    b4.setText(deviceData1.getArray().get(1).getUnit());
                }
                break;
            default:
                if (deviceData1.getArray().get(0).getName()!= null) {
                    a1.setText( deviceData1.getArray().get(0).getId());
                    a2.setText(deviceData1.getArray().get(0).getName());
                    a3.setText(deviceData1.getArray().get(0).getCurrentValue());
                    a4.setText(deviceData1.getArray().get(0).getUnit());
                }

        }

//
//        if (deviceData1.getArray().get(2).getName()!= null) {
//            c1.setText(deviceData1.getArray().get(2).getId());
//            c2.setText( deviceData1.getArray().get(2).getName());
//            c3.setText(deviceData1.getArray().get(2).getCurrentValue());
//            c4.setText(deviceData1.getArray().get(2).getUnit());
//        }
//
//        if (deviceData1.getArray().get(3).getName()!= null)
//        {
//            d1.setText(deviceData1.getArray().get(3).getId());
//            d2.setText(deviceData1.getArray().get(3).getName());
//            d3.setText(deviceData1.getArray().get(3).getCurrentValue());
//            d4.setText(deviceData1.getArray().get(3).getUnit());
//        }





    }






    //listView.setAdapter(contactAdapter);

       // tx_device_data =(TextView) findViewById(R.id.textView5);

       // json_string = getIntent().getExtras().getString("json_data");
        //tx_device_data.setText(json_string);
    /*try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("device_data");
            int count=0;
            String dev_name, mac_addr, data;
            while(count<jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject((count));
                dev_name = JO.getString("dev_name");
                mac_addr = JO.getString("mac_addr");
                data = JO.getString("data");

                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        */


    }





