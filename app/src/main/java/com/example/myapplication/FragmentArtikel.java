package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication.databinding.FragmentArtikelBinding;

public class FragmentArtikel extends Fragment {

    LinearLayout artikel_1, artikel_2, artikel_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artikel, container, false);
        artikel_1 = view.findViewById(R.id.artikel_1);
        artikel_2 = view.findViewById(R.id.artikel_2);
        artikel_3 = view.findViewById(R.id.artikel_3);

        artikel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),DetailArtikel.class);
                startActivity(notif);
            }
        });

        artikel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),DetailArtikel.class);
                startActivity(notif);
            }
        });

        artikel_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notif = new Intent(getActivity(),DetailArtikel.class);
                startActivity(notif);
            }
        });

        return view;
    }
}