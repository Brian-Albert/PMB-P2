package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnEdit = (Button) findViewById(R.id.edit);
        btnEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profil.this, edit.class);
                TextView txtnama = (TextView) findViewById(R.id.nama);
                TextView txtnim = (TextView) findViewById(R.id.nim);
                TextView txtjurusan = (TextView) findViewById(R.id.jurusan);
                TextView txtkelas = (TextView) findViewById(R.id.kelas);

                String msgnama = txtnama.getText().toString();
                String msgnim = txtnim.getText().toString();
                String msgjurusan = txtjurusan.getText().toString();
                String msgkelas = txtkelas.getText().toString();

                intent.putExtra("nama", msgnama);
                intent.putExtra("nim", msgnim);
                intent.putExtra("jurusan", msgjurusan);
                intent.putExtra("kelas", msgkelas);

                startActivity(intent);



            }
        });
    }
}