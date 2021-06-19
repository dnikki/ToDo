package com.example.todo

import android.app.Application
import com.example.todo.db.NotesDatabase

class NotesApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }

    fun getNotesDb():NotesDatabase{
        return NotesDatabase.getInstance(this)
    }
}