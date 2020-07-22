package com.example.chatbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CampusButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campusbutton);
        Button b1 =(Button)findViewById(R.id.button);
    }

    public void onClick1(View v)
    {
        Intent intent = new Intent(this, CampusIMG.class);
        startActivity(intent);
    }
    public void onClick2(View v)
    {
        Intent intent = new Intent(this, GanghwaIMG.class);
        startActivity(intent);
    }
}
