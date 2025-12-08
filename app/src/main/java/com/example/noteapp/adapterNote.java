package com.example.noteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class adapterNote extends ArrayAdapter<itemNote> {
    Activity context;
    ArrayList<itemNote> itemNotes;
    int layoutID;

    Button btnDel;
    Intent intent;
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
        // Sự kiện khi chọn vào 1 item trong listview
        row.setOnClickListener(v->{
            intent = new Intent(adapterNote.this.getContext(), ReadScreen.class);
            String title = tvTitle.getText().toString();
            String content = tvContent.getText().toString();
            intent.putExtra("id", n.getID());
            intent.putExtra("title", title);
            intent.putExtra("content",content);
            ((MainActivity) context).launcherUpdate.launch(intent);
        });
        return row;
    }
    public void updateData(int id, String newTitle, String newContent) {
        for (itemNote n : itemNotes){
            // Nếu id của item trùng với id của item được chọn để chỉnh sửa thì set nội dung
            if (n.getID() == id){
                n.setTitle(newTitle);
                n.setContent(newContent);
                break;
            }
        }
        notifyDataSetChanged();
    }

}
