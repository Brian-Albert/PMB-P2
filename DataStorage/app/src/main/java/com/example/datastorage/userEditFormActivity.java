package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorage.crud.userCRUD;

public class userEditFormActivity extends AppCompatActivity {
    EditText edtTipee, edtPanjange, edtStatuse;
    TextView edtNamae;
    Button btnSimpanUsere;
    String Nama = "";
    String Tipe="";
    String Panjang="";
    String Status="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_form);
        getIntent().getStringExtra("nama");
        getIntent().getStringExtra("tipe");
        getIntent().getStringExtra("panjang");
        getIntent().getStringExtra("status");

        edtNamae = (TextView) findViewById(R.id.edtNamae);
        edtTipee = (EditText) findViewById(R.id.edtTipeDatae);
        edtPanjange = (EditText) findViewById(R.id.edtPanjange);
        edtStatuse = (EditText) findViewById(R.id.edtStatuse);
        edtNamae.setText(getIntent().getStringExtra("nama"));
        edtTipee.setText(getIntent().getStringExtra("tipe"));
        edtPanjange.setText(getIntent().getStringExtra("panjang"));
        edtStatuse.setText(getIntent().getStringExtra("status"));


        btnSimpanUsere = (Button) findViewById(R.id.btnSimpanUsere);



        btnSimpanUsere.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Nama = edtNamae.getText().toString();
                     Tipe = edtTipee.getText().toString();
                     Panjang = edtPanjange.getText().toString();
                     Status = edtStatuse.getText().toString();

                     Toast.makeText(userEditFormActivity.this, "Data Berhasil Terupdate", Toast.LENGTH_LONG).show();
                     userCRUD usercrud = new userCRUD();
                     usercrud.updateDataUser(Nama, Tipe, Panjang, Status);
                     finish();
                 }
             }
        );

    }
}