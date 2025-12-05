package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    ActivityResultLauncher<Intent> launcher;
    Intent intent;

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

        // Để nhận và xử lý kết quả trả về
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
              if(result.getResultCode() == RESULT_OK){
                   Intent data = result.getData();
                   ArrayList<itemNote> list = (ArrayList<itemNote>) data.getSerializableExtra("list");
                   arrNote.addAll(list);
                   adapter.notifyDataSetChanged();
              }
        });
        // Sự kiện thêm ghi chú (create)
        btnCreate.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, NoteScreen.class);
            launcher.launch(intent); // sẽ gửi và chờ dữ liệu từ NoteScreen trả về
        });

    }
}