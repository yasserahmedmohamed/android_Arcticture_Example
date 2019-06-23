package com.yasserahmed.architectureexample.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.yasserahmed.architectureexample.Model.Note;
import com.yasserahmed.architectureexample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class NoteAdapter extends ListAdapter<Note , NoteAdapter.NoteHolder> {


    private onitemClickListener listener;

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }
private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
    @Override
    public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return oldItem.getDescriotion().equals(newItem.getDescriotion())
                &&oldItem.getTitle().equals(newItem.getTitle())
                &&oldItem.getPreiority()==newItem.getPreiority();
    }
};



    public  Note getNoteAt(int position){
        return  getItem(position);
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

        Note currentNote = getItem(position);
        holder.txtViewTitle.setText(currentNote.getTitle());
        holder.txtViewDescription.setText(currentNote.getDescriotion());
        holder.txtViewPriorty.setText(String.valueOf(currentNote.getPreiority()));


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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null&& position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }
    public interface onitemClickListener{
        void onItemClick(Note note);
    }
    public  void setonitemclickListener(onitemClickListener listener){
        this.listener = listener;
    }
}
