package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReadScreen extends AppCompatActivity {
    TextView tvTitle2, tvContent2;
    EditText edtTitle2, edtContent2;
    Button btnBack, btnChange, btnCheck;
    View includeChange, includeCheck;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_screen);

        btnBack = findViewById(R.id.btnback);

        includeChange = findViewById(R.id.includechange);
        btnChange = includeChange.findViewById(R.id.btnchange);
        includeCheck = findViewById(R.id.includecheck);
        btnCheck = includeCheck.findViewById(R.id.btncheck);

        tvTitle2 = findViewById(R.id.tvTitle2);
        tvContent2 = findViewById(R.id.tvContent2);
        edtTitle2 = findViewById(R.id.edtTitle2);
        edtContent2 = findViewById(R.id.edtContent2);

        includeCheck.setVisibility(View.GONE);
        btnCheck.setVisibility(View.GONE);
        edtTitle2.setVisibility(View.GONE);
        edtContent2.setVisibility(View.GONE);

        intent = getIntent();
        int ID = intent.getIntExtra("id",0);
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        tvTitle2.setText(title);
        tvContent2.setText(content);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        btnChange.setOnClickListener(v -> {
            // ẩn textview và btnChange để chỉnh sửa
            tvTitle2.setVisibility(View.GONE);
            tvContent2.setVisibility(View.GONE);
            btnChange.setVisibility(View.GONE);

            // Hiện btnCheck và edittext để tiến hành chỉnh sửa
            includeCheck.setVisibility(View.VISIBLE);
            btnCheck.setVisibility(View.VISIBLE);
            edtTitle2.setVisibility(View.VISIBLE);
            edtContent2.setVisibility(View.VISIBLE);

            edtTitle2.setText(title);
            edtContent2.setText(content);
        });

    }
}