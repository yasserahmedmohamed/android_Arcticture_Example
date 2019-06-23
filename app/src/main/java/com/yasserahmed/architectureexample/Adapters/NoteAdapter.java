package com.yasserahmed.architectureexample.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.yasserahmed.architectureexample.Model.Note;
import com.yasserahmed.architectureexample.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    public  void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    public  Note getNoteAt(int position){
        return  notes.get(position);
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);
        return  new NoteHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        Note currentNote = notes.get(position);
        holder.txtViewTitle.setText(currentNote.getTitle());
        holder.txtViewDescription.setText(currentNote.getDescriotion());
        holder.txtViewPriorty.setText(String.valueOf(currentNote.getPreiority()));


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends  RecyclerView.ViewHolder{
        private TextView txtViewTitle;
        private TextView txtViewDescription;
        private TextView txtViewPriorty;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            txtViewTitle = itemView.findViewById(R.id.text_view_title);
            txtViewPriorty = itemView.findViewById(R.id.text_view_priority);
            txtViewDescription = itemView.findViewById(R.id.text_view_description);

        }
    }
    public interface onitemClickListener{
        void onItemClick(Note note);
    }
}
