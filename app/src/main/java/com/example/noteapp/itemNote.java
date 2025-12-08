package com.example.noteapp;

import java.io.Serializable;

public class itemNote implements Serializable {
    String title, content;
    int ID;

    public itemNote(int ID,String title, String content){
        this.ID = ID;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
