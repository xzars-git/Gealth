package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Terapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terapi);
    }

    public void btnMulaiMata(View view) {
        Intent mulaiMata = new Intent(this, TerapiMata.class);
        startActivity(mulaiMata);
    }

    public void btnMulaiTangan(View view) {
        Intent mulaiTangan = new Intent(this, TerapiTangan.class);
        startActivity(mulaiTangan);
    }
}