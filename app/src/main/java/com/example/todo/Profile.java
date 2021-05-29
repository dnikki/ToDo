package com.example.todo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    TextView title,description;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        setActionbartitle();

    }

    private void setActionbartitle() {
        if(!TextUtils.isEmpty(sharedPreferences.getString(Pref_Constant.FULL_NAME,null))){
            getSupportActionBar().setTitle(sharedPreferences.getString(Pref_Constant.FULL_NAME,null));
        }
        else{
            String name= getIntent().getStringExtra(Pref_Constant.FULL_NAME);
            getSupportActionBar().setTitle(name);
        }

    }

    private void init() {
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);

        sharedPreferences=getSharedPreferences(Pref_Constant.PREF_NAME,MODE_PRIVATE);
    }

    public void add(View view) {

        View view2= LayoutInflater.from(Profile.this).inflate(R.layout.add_notes_layout_dialog,null);
        EditText titled=view2.findViewById(R.id.texttitle);
        EditText descriptiond=view2.findViewById(R.id.textdescription);
        Button submit=view2.findViewById(R.id.submit);

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setView(view2);
        alertDialog.setCancelable(false);
        AlertDialog dialog = alertDialog.create();
        dialog.show();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText(titled.getText().toString());
                description.setText(descriptiond.getText().toString());
                dialog.hide();

            }
        });

    }
}