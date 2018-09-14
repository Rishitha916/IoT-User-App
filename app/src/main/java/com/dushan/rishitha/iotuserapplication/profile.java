package com.dushan.rishitha.iotuserapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.location.Location;


import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class profile extends AppCompatActivity{

    private TextView text1,text2,text3;
    Button btnmembers, btndevices, btnchangepw, btnlogout;
    SessionHandler session;
    //trackLocation tloc = new trackLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        text1 = (TextView) findViewById(R.id.username1);
        text2 = (TextView) findViewById(R.id.textView32);
        text3 = (TextView) findViewById(R.id.textView33);
        session = new SessionHandler(getApplicationContext());

        btnmembers = (Button) findViewById(R.id.bmembers);
        btndevices = (Button) findViewById(R.id.bdevices);
        btnchangepw = (Button) findViewById(R.id.button2);
        btnlogout = (Button) findViewById(R.id.button);
        text1.setText(session.getuseremail());
        GPSTracker tloc = new GPSTracker(getApplicationContext());
        tloc.getLocation();
        Double lat=tloc.getLatitude();
        Double log=tloc.getLongitude();
        text2.setText(Double.toString(lat));
        text3.setText(Double.toString(log));

        btnmembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, members.class);
                startActivity(intent);
            }
        });

        btndevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, devices.class);
                startActivity(intent);
            }
        });
        btnchangepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, changePassword.class);
                startActivity(intent);
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });


    }





    /* class BackgroundTask extends AsyncTask<Void,Void,String> {
        String json_url;
        String JSON_STRING1;

        @Override
        protected void onPreExecute() {
            json_url ="http://10.0.2.2/devices.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING1 = bufferedReader.readLine()) != null){


                    stringBuilder.append(JSON_STRING1+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string = result;
        }
    }
    //getlocation method


// send location data to backend
   /* public void sendLocData(String id,String lat,String log){
        Background background = new Background();
        background.execute(id,lat,log);
        finish();
    }
    */
    /*class Background extends AsyncTask<String,Void,Void>{
        String add_loc_url;
        @Override
        protected void  onPreExecute(){
           add_loc_url = "http://10.0.2.2/add_loc.php" ;
        }
        @Override
        protected Void doInBackground(String...args){
            String id, lat, log;
            id = args[0];
            lat = args[1];
            log = args[2];
            try {
                URL url = new URL(add_loc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_string = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("lat","UTF-8")+"="+URLEncoder.encode(lat,"UTF-8")+"&"+
                        URLEncoder.encode("log","UTF-8")+"="+URLEncoder.encode(log,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }
        @Override
        protected void  onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }
        @Override
        protected  void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        }
    }
    */




}

