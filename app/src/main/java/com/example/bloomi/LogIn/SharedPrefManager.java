package com.example.bloomi.LogIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.bloomi.Detail.auth_controller.Account;
import com.example.bloomi.LogIn.LogIn;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "dataLogIn";
    private static final String KEY_phoneOrEmail = "keyusername";
    private static final String KEY_password = "keypassword";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_jwt = "jwt";
    private static final String KEY_ID = "keyid";
    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will store the user data in shared preferences
    public void userLogin(Account user) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_phoneOrEmail, user.getEmailOrPhone());
        editor.putString(KEY_password, user.getPassword());
        editor.putString(KEY_jwt,user.getJwt());
        editor.putInt(KEY_ID, user.getAccountId());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_phoneOrEmail, null) != null;
    }

    //this method will give the logged in user
    public Account getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Account(
                sharedPreferences.getString(KEY_phoneOrEmail, null),
                sharedPreferences.getString(KEY_password, null),
                sharedPreferences.getString(KEY_jwt, null),
                sharedPreferences.getInt(KEY_ID, -1)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LogIn.class));
    }
}