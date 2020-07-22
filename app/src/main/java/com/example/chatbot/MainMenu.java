package com.example.chatbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void onClickplusquestion(View view) {
        Intent intent = new Intent(this, QuestionPlus.class);
        startActivity(intent);
    }
    public void onClickquestion(View v)
    {
        Intent intent = new Intent(this, GoodQuestionActivity.class);
        startActivity(intent);
    }
    public void onClickcall(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9273-7906"));
        startActivity(intent);
    }
}