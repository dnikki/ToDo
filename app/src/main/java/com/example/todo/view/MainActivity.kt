package com.example.todo.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R
import com.example.todo.constatnts.Pref_Constant

class MainActivity : AppCompatActivity() {
    var fullname: EditText? = null
    var username: EditText? = null
    var login: Button? = null
    var sharedPreferences: SharedPreferences? = null
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        fullname = findViewById(R.id.fullname)
        username = findViewById(R.id.username)
        login = findViewById(R.id.submit)
        sharedPreferences = getSharedPreferences(Pref_Constant.PREF_NAME, MODE_PRIVATE)
    }

    fun login(view: View?) {
        val fname = fullname!!.text.toString()
        val uname = username!!.text.toString()
        if (TextUtils.isEmpty(fname) || TextUtils.isEmpty(uname)) {
            Toast.makeText(this, "Fullname and Username must be filled.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra(Pref_Constant.FULL_NAME, fullname!!.text.toString())
            saveLoginStatus(fname)
            startActivity(intent)
        }
    }

    private fun saveLoginStatus(fname: String) {
        editor = sharedPreferences!!.edit()
        editor.putBoolean(Pref_Constant.IS_LOGGED_IN, true)
        editor.putString(Pref_Constant.FULL_NAME, fname)
        editor.apply()
    }
}