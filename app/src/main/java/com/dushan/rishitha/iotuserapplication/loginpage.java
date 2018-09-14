package com.dushan.rishitha.iotuserapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.dushan.rishitha.iotuserapplication.model.LoginModel;
import com.dushan.rishitha.iotuserapplication.model.UserLoginModel;

public class loginpage extends AppCompatActivity {
    private ApiInterface apiInterface;
    private Button btnlogin;
    SessionHandler session;
    public EditText etEmail, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        session = new SessionHandler(getApplicationContext());
        if(session.isLoggedIn()){


            Intent intent = new Intent(getApplicationContext() , profile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        etEmail = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.login);

    }
    public void LoginValidate(View v) {
        Log.i("Tag ", "LoginValidate");
        session = new SessionHandler(getApplicationContext());
        if(session.isOnclicked()){
            Log.i("Tag ", "return");
            return;
        }else {
            session.createOnclickSession(true);
        }
        if(new ConnectionDetector(this).isConnected()) {
            String email = etEmail.getText().toString().trim();
            String password1 = password.getText().toString().trim();

            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<LoginModel> call = apiInterface.getLogin(new UserLoginModel(email, password1));
            Log.i("Tag ", "Call");

            call.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if (response.isSuccessful()) {
                        HomePage(response.body());
                        Toast.makeText(getApplicationContext(), String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    session.createOnclickSession(false);
                    Toast.makeText(getApplicationContext(), "Login Fail 000... Try Again", Toast.LENGTH_SHORT).show();
                }
            });
            }


        else {
            session.createOnclickSession(false);
            Toast.makeText(getApplicationContext(),"Waiting for Network", Toast.LENGTH_SHORT).show();
        }
    }




    public void HomePage(LoginModel results){
        session = new SessionHandler(getApplicationContext());
        session.createOnclickSession(false);

        if (results.getStatus().equals("Failed")){
            etEmail.setText("");
            password.setText("");
            Toast.makeText(getApplicationContext(),"AAAAA Login failed..\", \"Invalid Username or Password\"", Toast.LENGTH_LONG).show();


        }else if (results.getStatus().equals("No Username")){
            etEmail.setText("");
            password.setText("");
            Toast.makeText(getApplicationContext(),"Login failed..\", \"Please enter a valid email\"", Toast.LENGTH_LONG).show();

        }else if(results.getStatus().equals("Success")) {
            session.createLoginSession(etEmail.getText().toString().trim(), results);


            Intent intent = new Intent(getApplicationContext() , profile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        }else {
            etEmail.setText("");
            password.setText("");
            Toast.makeText(getApplicationContext(),"Login failed..\", \"Please enter a valid email\"", Toast.LENGTH_LONG).show();
        }
    }


}
