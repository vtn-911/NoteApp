package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReadScreen extends AppCompatActivity {
    TextView tvTitle2, tvContent2;
    EditText edtTitle2, edtContent2;
    Button btnBack, btnChange, btnSave;
    View includeChange, includeSave;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_screen);

        btnBack = findViewById(R.id.btnback);

        includeChange = findViewById(R.id.includechange);
        btnChange = includeChange.findViewById(R.id.btnchange);
        includeSave = findViewById(R.id.includesave);
        btnSave = includeSave.findViewById(R.id.btnsave);

        tvTitle2 = findViewById(R.id.tvTitle2);
        tvContent2 = findViewById(R.id.tvContent2);
        edtTitle2 = findViewById(R.id.edtTitle2);
        edtContent2 = findViewById(R.id.edtContent2);

        includeSave.setVisibility(View.GONE);
        btnSave.setVisibility(View.GONE);
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
            includeChange.setVisibility(View.GONE);
            btnChange.setVisibility(View.GONE);

            // Hiện btnSave và edittext để tiến hành chỉnh sửa và lưu
            includeSave.setVisibility(View.VISIBLE);
            btnSave.setVisibility(View.VISIBLE);
            edtTitle2.setVisibility(View.VISIBLE);
            edtContent2.setVisibility(View.VISIBLE);

            edtTitle2.setText(title);
            edtContent2.setText(content);
        });
        // Lấy data từ edittext truyền qua MainActivity để xử lý tiếp
        btnSave.setOnClickListener(v ->{
            String responeTitle = edtTitle2.getText().toString();
            String responeContent = edtContent2.getText().toString();
            Intent intentRespone = new Intent();
            intentRespone.putExtra("id", ID);
            intentRespone.putExtra("responetitle", responeTitle);
            intentRespone.putExtra("responeContent", responeContent);
            setResult(RESULT_OK,intentRespone);
            finish();
        });

    }
}