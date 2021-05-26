package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText fullname,username;
    Button login;

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
    }

    public void login(View view) {
        Intent intent=new Intent(this,Profile.class);
        startActivity(intent);
    }
}