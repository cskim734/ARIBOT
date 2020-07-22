package com.example.chatbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Adapter2 extends PagerAdapter {

    private int[] images = {R.drawable.e0, R.drawable.jeongmun, R.drawable.kisuksa};
    private LayoutInflater inflater2;
    private Context context2;

    public Adapter2(Context context){
        this.context2 = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView5 = new ImageView(context2);
        imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView5.setImageResource(images[position]);
        container.addView(imageView5, 0);
        return imageView5;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();

    }
}