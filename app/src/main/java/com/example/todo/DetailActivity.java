package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindView();
        getIntentData();
    }

    private void getIntentData() {
        Intent intent=getIntent();
        title.setText(intent.getStringExtra(Pref_Constant.TITLE));
        description.setText(intent.getStringExtra(Pref_Constant.DESCRIPTION));
    }

    private void bindView() {
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
    }
}