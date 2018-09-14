package com.dushan.rishitha.iotuserapplication;

/**
 * Created by Rishitha on 1/27/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.dushan.rishitha.iotuserapplication.model.LoginModel;

public class SessionHandler {
    SharedPreferences pref; // Shared Preferences
    Editor editor;  // Editor for Shared preferences
    Context _context;   // Context
    int PRIVATE_MODE = 0;   // Shared pref modeprivate static final String PREF_NAME = "Login";   // Sharedpref file name
    private static final String PREF_NAME = "Login";
    private static final String IS_LOGIN = "IsLoggedIn";    // All Shared Preferences Keys
    public static final String KEY_EMAIL = "email";   // User email (make variable public to access from outside)
    public static final String KEY_USERID = "userId"; // userid (make variable public to access from outside)
    public static final String IS_ONCLICK = "Isonclicked";

    // Constructor
    public SessionHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    /**
     * Create onclick method
     */
    public void createOnclickSession(boolean onclick){
        editor.putBoolean(IS_ONCLICK, onclick);
        editor.commit();}

    public boolean isOnclicked(){
        return pref.getBoolean(IS_ONCLICK, false);
    }

    public void createLoginSession(String email, LoginModel respons){

        editor.putBoolean(IS_LOGIN, true);  // Storing login value as TRUE
        editor.putString(KEY_USERID, respons.getUserId());   // Storing id in pref
        editor.putString(KEY_EMAIL, email);

        editor.commit();    // commit changes
    }
    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */

    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){

            Intent i = new Intent(_context, loginpage.class);   // user is not logged in redirect him to Login Activity
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Closing all the Activities
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  // Add new Flag to start new Activity
            _context.startActivity(i);  // Staring Login Activity
        }
    }
    /**
     * Get stored session data
     * */

    public LoginModel getUserDetails() {
        LoginModel loginModel = new LoginModel(pref.getString(KEY_USERID, null),getuseremail());
        loginModel.setUserId(pref.getString(KEY_USERID, null));

        return loginModel;
    }

        /**
         * Clear session details
         * */

        public void logoutUser(){
            // Clearing all data from Shared Preferences
            editor.clear();
            editor.commit();

            Intent i = new Intent(_context, loginpage.class);   // After logout redirect user to Login Activity
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Closing all the Activities
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  // Add new Flag to start new Activity
            _context.startActivity(i);  // Staring Login Activity
        }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
    public String getuserid(){return pref.getString(KEY_USERID,"userId");}
    public String getuseremail(){return pref.getString(KEY_EMAIL,"email");}

}

