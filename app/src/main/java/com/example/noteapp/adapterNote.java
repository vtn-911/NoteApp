package com.example.noteapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class adapterNote extends ArrayAdapter<itemNote> {
    Activity context;
    ArrayList<itemNote> itemNotes;
    int layoutID;

    Button btnDel;
    public adapterNote (Activity context, int layoutID, ArrayList<itemNote> itemNotes){
        super(context,layoutID,itemNotes);
        this.context = context;
        this.layoutID = layoutID;
        this.itemNotes = itemNotes;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layoutID, null);
        TextView tvTitle = row.findViewById(R.id.tvTitle);
        TextView tvContent = row.findViewById(R.id.tvContent);
        btnDel = row.findViewById(R.id.btndelete);
        itemNote n = itemNotes.get(position);
        tvTitle.setText(n.getTitle());
        tvContent.setText(n.getContent());

        // Sự kiện xóa item
        btnDel.setOnClickListener(v -> {
            itemNotes.remove(position);
            notifyDataSetChanged();
        });
        return row;
    }
}
