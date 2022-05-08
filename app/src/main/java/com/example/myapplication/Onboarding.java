package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.OnboardingAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Onboarding  extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotLayout;
    Button skipBtn, daftarBtn;
    TextView txtMasuk;
    private FirebaseAuth mAuth;

    AppCompatImageButton nextBtn;

    TextView [] dots;
    OnboardingAdapter viewPagerAdapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        isLogin();
        setContentView(R.layout.onboarding);

        nextBtn = findViewById(R.id.nextbtnOnboarding);
        daftarBtn = findViewById(R.id.btn_daftar);
        skipBtn = findViewById(R.id.onboardingSkipButton);
        txtMasuk = findViewById(R.id.textViewMasuk);



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0)<2){
                    slideViewPager.setCurrentItem(getItem(1),true);
                }else {
                    Intent i = new Intent(Onboarding.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Onboarding.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        txtMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Onboarding.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        daftarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Onboarding.this, Registration.class);
                startActivity(i);
                finish();
            }
        });

        slideViewPager = (ViewPager) findViewById(R.id.onboardingViewPager);
        dotLayout = (LinearLayout) findViewById(R.id.indicator_dot);

        viewPagerAdapter = new OnboardingAdapter(this);

        slideViewPager.setAdapter(viewPagerAdapter);

        setUpIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpIndicator(int position){
        dots = new TextView[3];
        dotLayout.removeAllViews();

        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.softGrey, getApplicationContext().getTheme()));
            dotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.darkGrey, getApplicationContext().getTheme()));
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
            if(position == 2){
                daftarBtn.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.INVISIBLE);
                txtMasuk.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i){
        return slideViewPager.getCurrentItem() + i;
    }

    void isLogin(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            // Start home activity
            startActivity(new Intent(Onboarding.this, MainActivity.class));
        }
    }
}
