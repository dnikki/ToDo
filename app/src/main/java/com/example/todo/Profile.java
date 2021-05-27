package com.example.todo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name= getIntent().getStringExtra("fullname");
        getSupportActionBar().setTitle(name);
    }

    public void add(View view) {

        Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show();
        /*View view2= LayoutInflater.from(Profile.this).inflate(R.layout.add_notes_layout_dialog,null);
        EditText title=view2.findViewById(R.id.texttitle);
        EditText description=view2.findViewById(R.id.textdescription);
        EditText submit=view2.findViewById(R.id.submit);

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setView(view2);
        alertDialog.setCancelable(false);
        alertDialog.create();
        alertDialog.show();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.setCancelable(true);

            }
        });*/



    }
}