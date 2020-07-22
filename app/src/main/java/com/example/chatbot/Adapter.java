package com.example.chatbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Adapter extends PagerAdapter {

    private int[] images = {R.drawable.arigwan, R.drawable.doseogwan, R.drawable.daesingwan, R.drawable.munhwagwan, R.drawable.sanhakgwan, R.drawable.subongwan, R.drawable.visongwan, R.drawable.humun};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context = context;
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
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(images[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();

    }
}
