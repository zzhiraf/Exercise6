package com.example.exercise6;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Insert
    void insertAll(Note... notes);

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note")
    void deleteAll();

}
