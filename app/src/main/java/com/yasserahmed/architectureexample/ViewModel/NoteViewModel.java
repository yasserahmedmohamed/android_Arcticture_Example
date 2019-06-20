package com.yasserahmed.architectureexample.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yasserahmed.architectureexample.Model.Note;
import com.yasserahmed.architectureexample.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>>allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }
    public void  insertNote(Note note){
        repository.insert(note);
    }
    public void  UpdatetNote(Note note){
        repository.update(note);
    }
    public void  deletetNote(Note note){
        repository.delete(note);
    }
    public void  deleteAlltNote(){
        repository.deleteAllNotes();
    }
    public  LiveData<List<Note>> getAllNotes(){
        return  allNotes;
    }
}
