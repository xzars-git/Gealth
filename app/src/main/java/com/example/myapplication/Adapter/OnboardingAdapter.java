package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;

public class OnboardingAdapter extends PagerAdapter {

    Context context;

    int image[] = {
            R.drawable.image_onboardingone,
            R.drawable.image_onboardingtwo,
            R.drawable.image_onboardingthree,
    };

    int description[] = {
            R.string.onboardingDescriptionText1,
            R.string.onboardingDescriptionText2,
            R.string.onboardingDescriptionText3
    };

    int headings[] = {
            R.string.onboardingHeadingText1,
            R.string.onboardingHeadingText2,
            R.string.onboardingHeadingText3
    };

    public OnboardingAdapter (Context context){

        this.context = context;
    }
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboardingsliderlayout, container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.imageViewOnboarding);
        TextView slideHeading = (TextView) view.findViewById(R.id.onboardingTitle);
        TextView slideDescription = (TextView) view.findViewById(R.id.onboardingDescription);

        slidetitleimage.setImageResource(image[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
