package com.example.datastorage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.datastorage.MainActivity;
import com.example.datastorage.R;
import com.example.datastorage.crud.userCRUD;
import com.example.datastorage.formUserActivity;
import com.example.datastorage.model.User;
import com.example.datastorage.userEditFormActivity;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_listviewuser,parent,false);
        }
        TextView txvNamaUser = (TextView) convertView.findViewById(R.id.txvNama);
        TextView txvTipe= (TextView) convertView.findViewById(R.id.txvTipe);
        TextView txvPanjang = (TextView) convertView.findViewById(R.id.txvPanjang);
        TextView txvStatus = (TextView) convertView.findViewById(R.id.txvStatus);

        txvNamaUser.setText(user.getNama());
        txvTipe.setText(user.getTipe());
        txvPanjang.setText(user.getPanjang());
        txvStatus.setText(user.getStatus());


        ImageButton btnEdit = (ImageButton) convertView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent = new Intent(getContext(), userEditFormActivity.class);
                     intent.putExtra("nama", user.getNama());
                     intent.putExtra("tipe", user.getTipe());
                     intent.putExtra("panjang", user.getPanjang());
                     intent.putExtra("status", user.getStatus());

                     getContext().startActivity(intent);
                 }
             }
        );

        ImageButton btnDelete = (ImageButton)  convertView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCRUD usercrud = new userCRUD();
                usercrud.deleteDataUser(user.getNama());
                notifyDataSetChanged();
            }
        });

        return convertView;


    }
}
