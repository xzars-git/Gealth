package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    TextView user_name;
    FirebaseUser firebaseUser;
    Button btn_logOut;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        user_name = findViewById(R.id.user_name);
        btn_logOut = findViewById(R.id.btn_logOut);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            user_name.setText(firebaseUser.getDisplayName());
        }else {
            user_name.setText("Login Gagal!");
        }
        btn_logOut.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(Home.this, Login.class);
            startActivity(i);
            finish();
        });
    }
}