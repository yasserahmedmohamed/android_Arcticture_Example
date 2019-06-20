package com.yasserahmed.architectureexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yasserahmed.architectureexample.Model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void  insert(Note note);

    @Update
    void  Update(Note note);

    @Delete
    void  delete(Note note);

    @Query("DELETE FROM note_table")
    void  deleAllNotes();

    @Query("select * from note_table order by preiority desc")
    LiveData<List<Note>> getAllNotes();
}
