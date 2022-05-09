package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentBeranda extends Fragment {

    TextView user_name;
    FirebaseUser firebaseUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        user_name = view.findViewById(R.id.user_name);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            user_name.setText(firebaseUser.getDisplayName());
        }else {
            user_name.setText("Login Gagal!");
        }

        FirebaseAuth.getInstance().getCurrentUser().reload();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.setting_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.notif){
            Intent notif = new Intent(getActivity(),Notification.class);
            startActivity(notif);
        }
        if(id == R.id.profil){
            Intent notif = new Intent(getActivity(),Profile.class);
            startActivity(notif);
        }
        if(id == R.id.log_out){
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getActivity(),Login.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}