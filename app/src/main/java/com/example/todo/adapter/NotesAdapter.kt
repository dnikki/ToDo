package com.example.todo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.Profile;
import com.example.todo.R;
import com.example.todo.interfaces.ItemClickListner;
import com.example.todo.model.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    List<Notes> noteslist;
    ItemClickListner itemClickListner;
    public NotesAdapter(List<Notes> notes,ItemClickListner itemClickListner){
        this.noteslist=notes;
        this.itemClickListner=itemClickListner;

    }


    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_adapter_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( NotesAdapter.ViewHolder holder, int position) {
        final Notes notes= noteslist.get(position);
        holder.titleView.setText(notes.getTitle());
        holder.descriptionView.setText(notes.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onClick(notes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteslist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleView,descriptionView;

        public ViewHolder( View itemView) {
            super(itemView);
            titleView=itemView.findViewById(R.id.textViewtitle);
            descriptionView=itemView.findViewById(R.id.textViewdescription);
        }
    }
}
