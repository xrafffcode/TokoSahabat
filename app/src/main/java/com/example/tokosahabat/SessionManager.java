package com.example.tokosahabat;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.tokosahabat.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "id_user";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String NAMA = "nama";
    public static final String TELEPON = "telepon";
    public static final String PASSWORD = "password";


    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getIdUser());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAMA, user.getNama());
        editor.putString(TELEPON, user.getTelepon());
        editor.putString(PASSWORD, user.getPassword());

        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(NAMA, sharedPreferences.getString(NAMA,null));
        user.put(TELEPON, sharedPreferences.getString(TELEPON,null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD,null));

        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}