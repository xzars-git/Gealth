package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelesaiTerapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_terapi);
        getSupportActionBar().hide();
    }

    public void btnLagi(View view) {
        Intent lagi = new Intent(this, Terapi.class);
        startActivity(lagi);
    }

    public void btnKembali(View view) {
        finish();
    }
}