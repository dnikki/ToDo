package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText fullname,username;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        fullname=findViewById(R.id.fullname);
        username=findViewById(R.id.username);
        login=findViewById(R.id.submit);
        sharedPreferences =getSharedPreferences(Pref_Constant.PREF_NAME,MODE_PRIVATE);
    }

    public void login(View view) {
        String fname=fullname.getText().toString();
        String uname=username.getText().toString();

        if(TextUtils.isEmpty(fname) || TextUtils.isEmpty(uname)){
            Toast.makeText(this,"Fullname and Username must be filled.",Toast.LENGTH_SHORT).show();

        }
        else{
            Intent intent=new Intent(this,Profile.class);
            intent.putExtra(Pref_Constant.FULL_NAME,fullname.getText().toString());
            saveLoginStatus(fname);
            startActivity(intent);

        }
    }

    private void saveLoginStatus(String fname) {
        editor=sharedPreferences.edit();
        editor.putBoolean(Pref_Constant.IS_LOGGED_IN,true);
        editor.putString(Pref_Constant.FULL_NAME,fname);
        editor.apply();
    }
}