package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new FragmentBeranda());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.beranda:
                    replaceFragment(new FragmentBeranda());
                    break;
                case R.id.aplikasi:
                    replaceFragment(new FragmentAplikasi());
                    break;
                case R.id.terapi:
                    replaceFragment(new FragmentTerapi());
                    break;
                case R.id.artikel:
                    replaceFragment(new FragmentArtikel());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}