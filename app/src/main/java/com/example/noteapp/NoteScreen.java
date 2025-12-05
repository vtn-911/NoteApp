package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class NoteScreen extends AppCompatActivity {
    Button btnBack, btnCheck;
    EditText edtTitle, edtContent;
    ArrayList<itemNote> arrNote;
    Intent intent;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_screen);
        btnBack = findViewById(R.id.btnback);
        btnCheck = findViewById(R.id.btncheck);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        Random random = new Random();
        btnBack.setOnClickListener(v -> {
            finish();
        });
        btnCheck.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String content = edtContent.getText().toString();
            intent = new Intent();
            id = random.nextInt(1000);
            arrNote = new ArrayList<>();
            arrNote.add(new itemNote(id,title, content));
            intent.putExtra("list",arrNote);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}

