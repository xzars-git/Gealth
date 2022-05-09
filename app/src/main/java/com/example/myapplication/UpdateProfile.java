package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class UpdateProfile extends AppCompatActivity {

    EditText edittext_namalengkap /*, editText_email, editText_pastemail*/;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button btn_simpan;
/*
    TextInputEditText editText_password;*/
    AppCompatImageButton btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_update_profile);
        edittext_namalengkap = findViewById(R.id.edittext_namalengkap);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_back = findViewById(R.id.btn_back);
/*
        editText_email = findViewById(R.id.editText_email);
        editText_password = findViewById(R.id.editText_password);
        editText_pastemail = findViewById(R.id.editText_pastemail);
        String tempEmail = editText_email.getText().toString();
        String tempPassword = editText_password.getText().toString();
        String tempPastEmail = editText_pastemail.getText().toString();*/

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateProfile.this,Profile.class);
                startActivity(i);
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edittext_namalengkap.getText().length() > 0){
                    String tempNamaLengkap = edittext_namalengkap.getText().toString();

                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(tempNamaLengkap)
                            .build();

                    user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "User profile updated.");
                                    }
                                }
                            });

                    /*user.updateEmail(tempEmail)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "User email address updated.");
                                        Toast.makeText(getApplicationContext(), "Pergantian Email Akun Berhasil!!!", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });*/

                    // Get auth credentials from the user for re-authentication. The example below shows
                    // email and password credentials but there are multiple possible providers,
                    // such as GoogleAuthProvider or FacebookAuthProvider.
                    /*AuthCredential credential = EmailAuthProvider
                            .getCredential(tempPastEmail, tempPassword);

                    // Prompt the user to re-provide their sign-in credentials
                    user.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.d(TAG, "User re-authenticated.");
                                }
                            });*/

                    Toast.makeText(getApplicationContext(), "Perubahan Akun Berhasil!!!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(UpdateProfile.this,Profile.class);
                    startActivity(i);
                    FirebaseAuth.getInstance().getCurrentUser().reload();
                }else {
                    Toast.makeText(getApplicationContext(), "Silahkan masukan nama pengguna baru!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}