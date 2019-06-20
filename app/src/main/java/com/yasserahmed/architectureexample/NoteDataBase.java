package com.yasserahmed.architectureexample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.yasserahmed.architectureexample.Model.Note;

@Database(entities = Note.class, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    private  static  NoteDataBase instance;
    public  abstract  NoteDao noteDao();
    public  static  synchronized  NoteDataBase getInstance(Context context)
    {
        if ( instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,"note_database")
                    .addCallback(roomcallback)
                    .fallbackToDestructiveMigration().build();
        }

        return  instance;
    }
    private  static  RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private  static  class  PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private  NoteDao noteDao;

        private PopulateDbAsyncTask(NoteDataBase bd) {
            this.noteDao = bd.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("test 1","test",1));
            noteDao.insert(new Note("test 2","test",2));
            noteDao.insert(new Note("test 3","test",3));

            return null;
        }
    }
}
