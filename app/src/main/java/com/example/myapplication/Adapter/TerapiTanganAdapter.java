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

public class TerapiTanganAdapter extends PagerAdapter {
    Context context;

    int[] images = {

            R.drawable.tangan1,
            R.drawable.tangan2,
            R.drawable.tangan3,
            R.drawable.tangan4,
            R.drawable.tangan5,
            R.drawable.tangan6,
            R.drawable.tangan7,
            R.drawable.tangan8,
            R.drawable.tangan9,
            R.drawable.tangan10,
            R.drawable.tangan11,
            R.drawable.tangan12,
            R.drawable.tangan13,
            R.drawable.tangan14,
            R.drawable.tangan15,


    };

    int[] headings = {

            R.string.tanganHeadingText1,
            R.string.tanganHeadingText2,
            R.string.tanganHeadingText3,
            R.string.tanganHeadingText4,
            R.string.tanganHeadingText5,
            R.string.tanganHeadingText6,
            R.string.tanganHeadingText7,
            R.string.tanganHeadingText8,
            R.string.tanganHeadingText9,
            R.string.tanganHeadingText10,
            R.string.tanganHeadingText11,
            R.string.tanganHeadingText12,
            R.string.tanganHeadingText13,
            R.string.tanganHeadingText14,
            R.string.tanganHeadingText15,




    };


    public TerapiTanganAdapter(Context context) {

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
        View view = layoutInflater.inflate(R.layout.slider_terapi_tangan, container, false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.titleText);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);

    }
}

