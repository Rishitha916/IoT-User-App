package com.dushan.rishitha.iotuserapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dushan.rishitha.iotuserapplication.model.changePw;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class changePassword extends AppCompatActivity {
    EditText currpw, newpw, confirmpw;
    Button update;
    SessionHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        currpw = (EditText) findViewById(R.id.editText1) ;
        newpw =(EditText) findViewById(R.id.editText2);
        confirmpw = (EditText) findViewById(R.id.editText3);
        update = (Button) findViewById(R.id.update);
        session = new SessionHandler(getApplicationContext());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionHandler session = new SessionHandler(getApplicationContext());
                if(newpw != confirmpw) {
                    Toast.makeText(getApplicationContext(), "Error!! confirm password", Toast.LENGTH_LONG).show();
                }
                else {
                    changePw changePw1 = new changePw(currpw.getText().toString().trim(),session.getuserid(),newpw.getText().toString().trim());
                    changePw1.setUserId(session.getuserid());
                    changePw1.setCurrentPw(currpw.getText().toString().trim());
                    changePw1.setNewPw(newpw.getText().toString().trim());

                    ApiInterface apiInterface;

                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    Call<ResponseBody> call = apiInterface.changePw(changePw1);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();

                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                        }
                    });
                }

                }

            });
    }
}
