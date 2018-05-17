package com.example.exercise6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OurAdapter mNotesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //chrome://inspect
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    //Добавить запись
    public void onClick(View view) {
        TextView mytitle = findViewById(R.id.editTextTitle);
        TextView mybody = findViewById(R.id.editTextBody);

        Note note = new Note();

        note.setTitle(mytitle.getText().toString());
        note.setBody(mybody.getText().toString());
        AppDatabase.getAppDatabase(this).noteDao().insert(note);

        List<Note> updatedList = getNoteList();
        mNotesAdapter.updateList(updatedList);
        Log.d("myTag","добавили запись" + mytitle.getText().toString());
    }

    //Удалить запись
    public void onClickdel(View view) {
        AppDatabase.getAppDatabase(this).noteDao().deleteAll();;
        List<Note> updatedList = getNoteList();
        mNotesAdapter.updateList(updatedList);
        Log.d("myTag","удалили все записи");
    }


    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Note> myDataset = getNoteList();
        mNotesAdapter = new OurAdapter(myDataset);
        mRecyclerView.setAdapter(mNotesAdapter);
    }


    private List<Note> getNoteList() {
        return AppDatabase.getAppDatabase(this).noteDao().getAll();
    }


}
