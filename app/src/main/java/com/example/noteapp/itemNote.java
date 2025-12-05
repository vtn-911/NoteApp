package com.example.noteapp;

public class itemNote {
    String title, content;
    int ID;

    public itemNote(int ID,String title, String content){
        this.title = title;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
