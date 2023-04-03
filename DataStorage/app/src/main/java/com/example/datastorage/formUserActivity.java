package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.StateSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorage.model.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class formUserActivity extends AppCompatActivity {
    EditText edtNama, edtTipe, edtPanjang, edtStatus;
    Button btnSimpanUser;
    String Nama = "";
    String Tipe="";
    String Panjang="";
    String Status="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtTipe = (EditText) findViewById(R.id.edtTipeData);
        edtPanjang = (EditText) findViewById(R.id.edtPanjang);
        edtStatus = (EditText) findViewById(R.id.edtStatus);

        btnSimpanUser = (Button) findViewById(R.id.btnSimpanUser);



        btnSimpanUser.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Nama = edtNama.getText().toString();
                  Tipe = edtTipe.getText().toString();
                  Panjang = edtPanjang.getText().toString();
                  Status = edtStatus.getText().toString();

                  Toast.makeText(formUserActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();

                  tambahDataUser(Nama, Tipe, Panjang, Status);
              }
          }
        );

    }

    public void tambahDataUser(String Nama, String Tipe, String Panjang, String Status){
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {

                                             Log.d("TAG", "Nama" + Nama + "Tipe: " + Tipe + "Panjang: " + Panjang + "Status" + Status);
                                             User user1 = realm.createObject(User.class, Nama);
                                             user1.setTipe(Tipe);
                                             user1.setPanjang(Panjang);
                                             user1.setStatus(Status);

                                         }
                                         catch (RealmPrimaryKeyConstraintException e){
                                             Log.d("TAG" ,"Primary Key Sudah Ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }


}