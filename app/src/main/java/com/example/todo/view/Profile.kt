package com.example.todo.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.adapter.NotesAdapter
import com.example.todo.constatnts.Pref_Constant
import com.example.todo.interfaces.ItemClickListner
import com.example.todo.model.Notes
import java.util.*

class Profile : AppCompatActivity() {
    var notesArrayList = ArrayList<Notes>()
    var recyclerView: RecyclerView? = null
    var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        setActionbartitle()
    }

    private fun setActionbartitle() {
        if (!TextUtils.isEmpty(sharedPreferences!!.getString(Pref_Constant.FULL_NAME, null))) {
            supportActionBar!!.title = sharedPreferences!!.getString(Pref_Constant.FULL_NAME, null)
        } else {
            val name = intent.getStringExtra(Pref_Constant.FULL_NAME)
            supportActionBar!!.title = name
        }
    }

    private fun init() {
        recyclerView = findViewById(R.id.recyclerView)
        sharedPreferences = getSharedPreferences(Pref_Constant.PREF_NAME, MODE_PRIVATE)
    }

    fun add(view: View?) {
        val view2 = LayoutInflater.from(this@Profile).inflate(R.layout.add_notes_layout_dialog, null)
        val titled = view2.findViewById<EditText>(R.id.texttitle)
        val descriptiond = view2.findViewById<EditText>(R.id.textdescription)
        val submit = view2.findViewById<Button>(R.id.submit)
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setView(view2)
        alertDialog.setCancelable(false)
        val dialog = alertDialog.create()
        dialog.show()
        submit.setOnClickListener {
            val title = titled.text.toString()
            val description = descriptiond.text.toString()
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)) {
                val notes = Notes()
                notes.title = title
                notes.description = description
                notesArrayList.add(notes)
            } else {
                Toast.makeText(this@Profile, "Title and Desription cannot be empty.", Toast.LENGTH_SHORT).show()
            }
            setupRecyclerView()
            dialog.hide()
        }
    }

    private fun setupRecyclerView() {
        val itemClickListner: ItemClickListner = object : ItemClickListner {
            override fun onClick(notes: Notes?) {
                val intent = Intent(this@Profile, DetailActivity::class.java)
                intent.putExtra(Pref_Constant.TITLE, notes!!.title)
                intent.putExtra(Pref_Constant.DESCRIPTION, notes.description)
                startActivity(intent)
            }
        }
        val notesAdapter = NotesAdapter(notesArrayList, itemClickListner)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.adapter = notesAdapter
    }
}