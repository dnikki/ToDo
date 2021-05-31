package com.example.todo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.todo.adapter.NotesAdapter;
import com.example.todo.interfaces.ItemClickListner;
import com.example.todo.model.Notes;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    ArrayList<Notes> notesArrayList=new ArrayList<>();
    RecyclerView recyclerView;
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
        recyclerView=findViewById(R.id.recyclerView);
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
                String title =titled.getText().toString();
                String description=descriptiond.getText().toString();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description) ){
                Notes notes=new Notes();
                notes.setTitle(title);
                notes.setDescription(description);
                notesArrayList.add(notes);
                }
                else{
                    Toast.makeText(Profile.this,"Title and Desription cannot be empty.",Toast.LENGTH_SHORT).show();
                }

                setupRecyclerView();

                dialog.hide();

            }
        });

    }

    private void setupRecyclerView() {

        ItemClickListner itemClickListner=new ItemClickListner() {
            @Override
            public void onClick(Notes notes) {
                Intent intent=new Intent(Profile.this,DetailActivity.class);
                intent.putExtra(Pref_Constant.TITLE,notes.getTitle());
                intent.putExtra(Pref_Constant.DESCRIPTION,notes.getDescription());
                startActivity(intent);

            }
        };
        NotesAdapter notesAdapter=new NotesAdapter(notesArrayList,itemClickListner);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notesAdapter);

    }
}