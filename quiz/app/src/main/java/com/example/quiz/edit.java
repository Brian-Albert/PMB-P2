package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class edit extends AppCompatActivity {
    String nama, nim, jurusan, kelas;
    EditText e_nama, e_nim, e_jurusan, e_kelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        e_nama = findViewById(R.id.e_nama);
        e_nim = findViewById(R.id.e_nim);
        e_jurusan = findViewById(R.id.e_jurusan);
        e_kelas = findViewById(R.id.e_kelas);

        Intent data = getIntent();
        nama = data.getStringExtra("nama");
        nim = data.getStringExtra("nim");
        jurusan = data.getStringExtra("jurusan");
        kelas = data.getStringExtra("kelas");

        e_nama.setText(nama);
        e_nim.setText(nim);
        e_jurusan.setText(jurusan);
        e_kelas.setText(kelas);

        Button submit2 = (Button) findViewById(R.id.submit2);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(edit.this, profil.class);
                startActivity(intent);
            }
        });

    }
}