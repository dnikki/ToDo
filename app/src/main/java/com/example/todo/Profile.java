package com.example.todo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    TextView title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        title=(TextView)findViewById(R.id.title);
        description=(TextView)findViewById(R.id.description);

        String name= getIntent().getStringExtra("fullname");
        getSupportActionBar().setTitle(name);
    }

    public void add(View view) {

       // Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show();
        View view2= LayoutInflater.from(Profile.this).inflate(R.layout.add_notes_layout_dialog,null);
        EditText titled=view2.findViewById(R.id.texttitle);
        EditText descriptiond=view2.findViewById(R.id.textdescription);
        Button submit=view2.findViewById(R.id.submit);





        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        //alertDialog.setTitle("ADD NOTES");
       alertDialog.setView(view2);
       alertDialog.setCancelable(false);
       AlertDialog dialog = alertDialog.create();
       dialog.show();
      // alertDialog.create();
      // alertDialog.show();


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