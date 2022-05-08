package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentBeranda extends Fragment {

    TextView user_name;
    FirebaseUser firebaseUser;
    AppCompatButton notification_btn;
    Button logOut_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        user_name = view.findViewById(R.id.user_name);
        notification_btn = view.findViewById(R.id.btn_notif);
        logOut_btn = view.findViewById(R.id.btn_logOut);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            user_name.setText(firebaseUser.getDisplayName());
        }else {
            user_name.setText("Login Gagal!");
        }

        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),Notification.class);
                startActivity(notif);
            }
        });

        logOut_btn.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getActivity(), Login.class));
        });

        return view;
    }
}