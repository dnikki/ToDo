package com.example.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.interfaces.ItemClickListner
import com.example.todo.model.Notes

class NotesAdapter(var noteslist: List<Notes>, var itemClickListner: ItemClickListner) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notes = noteslist[position]
        holder.titleView.text = notes.title
        holder.descriptionView.text = notes.description
        holder.itemView.setOnClickListener { itemClickListner.onClick(notes) }
    }

    override fun getItemCount(): Int {
        return noteslist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView: TextView
        var descriptionView: TextView

        init {
            titleView = itemView.findViewById(R.id.textViewtitle)
            descriptionView = itemView.findViewById(R.id.textViewdescription)
        }
    }
}