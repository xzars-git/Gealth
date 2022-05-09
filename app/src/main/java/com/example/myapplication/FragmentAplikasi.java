package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentAplikasi extends Fragment {

    Button linkApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aplikasi, container, false);

        linkApp = view.findViewById(R.id.linkApp);

        linkApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),LinkApp.class);
                startActivity(notif);
            }
        });
        // Inflate the layout for this fragment
        return view;

    }
}