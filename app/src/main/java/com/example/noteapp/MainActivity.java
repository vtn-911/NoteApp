package com.example.noteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    ListView lvNote;
    ArrayList<itemNote> arrNote;
    adapterNote adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvNote = findViewById(R.id.lvNote);
        arrNote = new ArrayList<>();
        arrNote.add(new itemNote(1,"NOTE 1","aaaaaaaaaaaaaaaaaaaa"));
        adapter = new adapterNote(this, R.layout.item_note,arrNote);
        lvNote.setAdapter(adapter);

        btnCreate = findViewById(R.id.btncreate);
        btnCreate.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Tạo thành công!", Toast.LENGTH_SHORT).show();

        });
    }
}