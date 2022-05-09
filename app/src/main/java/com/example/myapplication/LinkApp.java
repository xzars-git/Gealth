package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LinkApp extends AppCompatActivity {


    AppCompatImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.linkapp_confirmation);

        btn_back = findViewById(R.id.backBtn);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LinkApp.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}