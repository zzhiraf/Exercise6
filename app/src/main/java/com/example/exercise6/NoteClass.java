package com.example.exercise6;

import java.util.ArrayList;
import java.util.List;

public class NoteClass {
        String title;
        String body;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPersons(List<NoteClass> noteClasses) {
        this.noteClasses = noteClasses;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<NoteClass> getNoteClasses() {
        return noteClasses;
    }

    NoteClass(String title, String body) {
            this.title = title;
            this.body = body;
        }

    private List<NoteClass> noteClasses;


}
