package com.example.todo.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R
import com.example.todo.constatnts.Pref_Constant

class DetailActivity : AppCompatActivity() {
    lateinit var title: TextView
    lateinit var description: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindView()
        intentData()
    }

    private fun intentData(){
            val intent = intent
            title.text = intent.getStringExtra(Pref_Constant.TITLE)
            description.text = intent.getStringExtra(Pref_Constant.DESCRIPTION)
        }

    private fun bindView() {
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
    }
}