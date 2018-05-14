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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);
        Log.d("myTag","start");
        initRecyclerView();

     /*   AppDatabase db =  AppDatabase.getAppDatabase(this);
        NoteDao notedao = db.noteDao();

        Note note = new Note();
        //note.setId(2);
        note.setTitle("Title 1");
        note.setBody("Body 1");
        notedao.insert(note);
        note.setTitle("Title 2");
        note.setBody("Body 2");
        notedao.insert(note);*/




    }

    public void onClick(View view) {

        TextView mytitle = findViewById(R.id.editTextTitle);
        TextView mybody = findViewById(R.id.editTextBody);

        Note note = new Note();

        note.setTitle(mytitle.getText().toString());
        note.setBody(mybody.getText().toString());
        //AppDatabase db =  AppDatabase.getAppDatabase(this);
        //NoteDao notedao = db.noteDao();
        //notedao.insert(note);

        AppDatabase.getAppDatabase(this).noteDao().insert(note);

        Log.d("myTag","добавили запись" + mytitle.getText().toString());
    }


    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<NoteClass> myDataset = getNoteList();

        mAdapter = new OurAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<NoteClass> getNoteList() {
        ArrayList<NoteClass> list = new ArrayList<>();
        list.add(createNote("Title 1", "Body 1"));
        list.add(createNote("Title 2", "Body 2"));
        list.add(createNote("Title 3", "Body 3"));
        list.add(createNote("Title 4", "Body 4"));
        list.add(createNote("Title 5", "Body 5"));
        list.add(createNote("Title 6", "Body 6"));
        list.add(createNote("Title 7", "Body 7"));
        list.add(createNote("Title 8", "Body 8"));
        list.add(createNote("Title 9", "Body 9"));
        list.add(createNote("Title 10", "Body 10"));
        return list;
    }
    private NoteClass createNote(String title, String body) {
        NoteClass note = new NoteClass(title,body);
        note.setTitle(title);
        note.setBody(body);
        return note;
    }



}
