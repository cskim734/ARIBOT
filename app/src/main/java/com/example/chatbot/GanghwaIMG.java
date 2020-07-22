package com.example.chatbot;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class GanghwaIMG extends AppCompatActivity {

    Adapter2 adapter2;
    ViewPager viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganghwaimg);
        viewPager2 = (ViewPager) findViewById(R.id.view2);
        adapter2 = new Adapter2(this);
        viewPager2.setAdapter(adapter2);
    }
}
