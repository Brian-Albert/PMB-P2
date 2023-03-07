//Nama: Brian Albert
//NIM: 03081210027
//Kelas: 21SI2
package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class HalamanLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);
        Button btnLogin = (Button) findViewById(R.id.btnMasuk);
        Button btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HalamanLogin.this, HalamanDaftar.class);
                intent.putExtra("message","this is a notification message");
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtUsername = (EditText) findViewById(R.id.editTextUsername);
                String username = edtUsername.getText().toString();

                if (!TextUtils.isEmpty(username)) {
                    Intent intent = new Intent(HalamanLogin.this, HalamanTampilan.class);
                    intent.putExtra("username",username);
                    NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    String CHANNEL_ID ="";
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                        CHANNEL_ID = "my_channel_01";
                        CharSequence name = "my_channel";
                        String Description = "This is my channel";
                        int importance = NotificationManager.IMPORTANCE_HIGH;
                        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
                        mChannel.setDescription(Description);
                        mChannel.enableLights(true);
                        mChannel.setLightColor(Color.RED);
                        mChannel.enableVibration(true);
                        mChannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
                        mChannel.setShowBadge(false);
                        nm.createNotificationChannel(mChannel);
                    }


                    PendingIntent pendingIntent =
                            PendingIntent.getActivity(HalamanLogin.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    EditText textUsername = (EditText) findViewById(R.id.editTextUsername);
                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(HalamanLogin.this, "my_channel_01");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentTitle("Berhasil Login");
                    builder.setContentText("Selamat Datang "+textUsername.getText().toString());
                    builder.setAutoCancel(true);
                    builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    builder.setContentIntent(pendingIntent);
                    nm.notify(234,builder.build());

                    startActivity(intent);
                } else {
                    Toast.makeText(HalamanLogin.this, "Maaf, anda belum mengisi username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}