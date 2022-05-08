package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTerapi extends Fragment {

    Button btnTerapiMata, btnTerapiTangan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terapi, container, false);
        btnTerapiMata = view.findViewById(R.id.btnTerapiMata);
        btnTerapiTangan = view.findViewById(R.id.btnTerapiTangan);

        btnTerapiMata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),TerapiMata.class);
                startActivity(notif);
            }
        });


        btnTerapiTangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),TerapiTangan.class);
                startActivity(notif);
            }
        });

        return view;
    }
}