package com.example.chatbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ari);
        Button b1 =(Button)findViewById(R.id.button);
    }
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onClick1(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anyang.ac.kr/main.do"));
        startActivity(intent);
    }
    public void onClick2(View v)
    {
        Intent intent = new Intent(this, GongjiActivity.class);
        startActivity(intent);
    }
    public void onClick3(View v)
    {
        Intent intent = new Intent(this, AnyangMap.class);
        startActivity(intent);
    }
    public void onClick4(View v)
    {
        Intent intent = new Intent(this, Pop.class);
        startActivity(intent);
    }
    public void onClick5(View v)
    {
        Intent intent = new Intent(this, Campusvideo.class);
        startActivity(intent);
    }
    public void onClick6(View v)
    {
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }
    public void onClick7(View v)
    {
        Intent intent = new Intent(this, CampusButton.class);
        startActivity(intent);
    }
    public void onClick8(View v)
    {
        Intent intent = new Intent(this, CampusInfo.class);
        startActivity(intent);
    }
    public void onClick9(View v)
    {
        Intent intent = new Intent(this, Ricemenu.class);
        startActivity(intent);
    }


}
