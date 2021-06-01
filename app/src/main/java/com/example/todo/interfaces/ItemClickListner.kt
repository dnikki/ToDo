package com.example.todo.interfaces

import com.example.todo.model.Notes

interface ItemClickListner {
    fun onClick(notes: Notes?)
}