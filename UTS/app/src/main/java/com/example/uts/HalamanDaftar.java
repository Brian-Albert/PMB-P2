package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class HalamanDaftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_daftar);
        Button btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtUsername = findViewById(R.id.username);
                String username = edtUsername.getText().toString();

                if (!TextUtils.isEmpty(username)) {
                    Intent intent = new Intent(HalamanDaftar.this, HalamanTampilan.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(HalamanDaftar.this, "Anda Belum Isi Username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}