package com.yasserahmed.architectureexample.Model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    private  String title;

    private String descriotion;

    private int preiority;

    public Note(String title, String descriotion, int preiority) {
        this.title = title;
        this.descriotion = descriotion;
        this.preiority = preiority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public int getPreiority() {
        return preiority;
    }
}
