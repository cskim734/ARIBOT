package com.example.chatbot;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class CampusIMG extends AppCompatActivity {

    Adapter adapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusimg);
        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new Adapter(this);
        viewPager.setAdapter(adapter);
    }
}
