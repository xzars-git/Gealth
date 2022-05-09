package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class BuatKataSandiBaru extends AppCompatActivity {

    AppCompatImageButton backBtn;
    TextInputEditText editText_email;
    Button btn_simpan;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lupapassword_input_email);

        editText_email = (TextInputEditText) findViewById(R.id.editText_email);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);
        backBtn = (AppCompatImageButton) findViewById(R.id.backBtn);

        auth = FirebaseAuth.getInstance();

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BuatKataSandiBaru.this, Login.class);
                startActivity(i);
                finish();
            }
        });
        getSupportActionBar().hide();
    }

    private void resetPassword(){
        String email = editText_email.getText().toString().trim();

        if(email.isEmpty()){
            editText_email.setError("Masukan E-mail Kamu !!!");
            editText_email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editText_email.setError("Masukan E-mail Yang Cocok !!!");
            editText_email.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(BuatKataSandiBaru.this,"Silahkan cek e-mail anda, untuk mengganti password !!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(BuatKataSandiBaru.this, "Silahkan ulangi !!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}