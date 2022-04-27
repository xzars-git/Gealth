package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public class StringToNumber {


        String[] number = {"1234", "605", "1405", "-7"};
        int [] intNumber = new int[3];

        public void stringToNumber () {
            for(int i=0; i < number.length; i++){
                intNumber [i] = Integer.parseInt(number[i]);
                System.out.println(number[i] + " --> " + intNumber[i]);
            }
        }

    }
}