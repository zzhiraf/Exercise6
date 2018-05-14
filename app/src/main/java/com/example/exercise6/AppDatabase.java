package com.example.exercise6;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

@Database(entities = {Note.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
        private static AppDatabase singleton;
        private static final String DATABASE_NAME = "FilmDb.db";
        public abstract NoteDao noteDao();
        public static AppDatabase getAppDatabase(Context context) {
            if (singleton == null) {
                synchronized (AppDatabase.class) {
                    if (singleton == null) {
                        singleton = Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class,
                                DATABASE_NAME)
                                .allowMainThreadQueries()
                                .build();
                    }
                }
            }
            return singleton;

        }


    /*private void saveData(List<Note> filmList) {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        db.noteDao().deleteAll();
        db.noteDao().insertAll(filmList.toArray(new Note[filmList.size()]));
    }

    private void restoreData() {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        List<Note> filmList = db.noteDao().getAll();
        if (filmList != null && filmList.size() > 0) {
            //updateUI(filmList);
        }
    }
    */

}
