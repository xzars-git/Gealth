package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    TextView  textView_namalengkap,textView_email;
    AppCompatImageButton btn_back;
    Button btn_update, btn_ubahKataSandi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getSupportActionBar().hide();

        textView_namalengkap = findViewById(R.id.textView_namalengkap);
        textView_email = findViewById(R.id.textView_email);
        btn_back = findViewById(R.id.btn_back);
        btn_update = findViewById(R.id.btn_update);
        btn_ubahKataSandi = findViewById(R.id.btn_ubahKataSandi);

        FirebaseAuth.getInstance().getCurrentUser().reload();

        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();

            textView_namalengkap.setText(name);
            textView_email.setText(email);
        }
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this,MainActivity.class);
                startActivity(i);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, UpdateProfile.class);
                startActivity(i);
            }
        });

        btn_ubahKataSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, BuatKataSandiBaru.class);
                startActivity(i);
            }
        });
    }
}