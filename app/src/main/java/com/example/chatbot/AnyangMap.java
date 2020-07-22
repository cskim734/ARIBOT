package com.example.chatbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.net.Uri.*;

public class AnyangMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyangmap);
    }

    public void onClick(View view) {
        Intent intent = new Intent (Intent.ACTION_VIEW, parse("https://map.naver.com/index.nhn?pinType=site&mapMode=0&pinId=11591601"));
        startActivity(intent);
    }
    public void onClickgangwha(View v)
    {
        Intent intetn1 = new Intent(this, GanghwaMap.class);
        startActivity(intetn1);
    }
}