package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences=getSharedPreferences(Pref_Constant.PREF_NAME,MODE_PRIVATE);

        checkLoginStatus();
    }

    private void checkLoginStatus() {
        Boolean loginStatus=sharedPreferences.getBoolean(Pref_Constant.IS_LOGGED_IN,false);
        if(loginStatus){
            Intent intent=new Intent(this,Profile.class);
            startActivity(intent);
        }
        else{
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}