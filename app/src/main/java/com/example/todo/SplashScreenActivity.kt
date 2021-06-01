package com.example.todo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPreferences = getSharedPreferences(Pref_Constant.PREF_NAME, MODE_PRIVATE)
        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        val loginStatus = sharedPreferences.getBoolean(Pref_Constant.IS_LOGGED_IN, false)
        if (loginStatus) {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}