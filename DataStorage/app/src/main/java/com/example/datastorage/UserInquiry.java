package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.datastorage.model.User;
import com.example.datastorage.Adapter.UserAdapter;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserInquiry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inquiry);

        //tarik data dari database
        Realm realm = Realm.getDefaultInstance();
        //penarikan data.
        RealmResults<User> users = realm.where(User.class).findAll();
        //data sudah taruk dan sdh di realm result.
        //menampilkan data.
        ArrayList<User> arrayofuser = new ArrayList<User>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        UserAdapter userAdapter = new UserAdapter(this, arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listviewuser);
        listView.setAdapter(userAdapter);

    }
}