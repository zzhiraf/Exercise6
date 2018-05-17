package com.example.exercise6;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import java.util.List;

@Database(entities = {Note.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
        private static AppDatabase singleton;
        private static final String DATABASE_NAME = "NoteDb.db";
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
}
