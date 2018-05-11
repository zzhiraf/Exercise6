package com.example.exercise6;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
        private static AppDatabase singleton;
        private static final String DATABASE_NAME = "FilmDb.db";


    }
