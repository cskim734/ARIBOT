package com.example.chatbot;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class CampusInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusinfo);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.9), (int)(height * 0.85));
    }
}
