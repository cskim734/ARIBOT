package com.example.chatbot;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Locale;

public class MIC extends AppCompatActivity {
    private TextView txvResult;
    private TextView tts;
    private TextToSpeech tts1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        txvResult = (TextView) findViewById(R.id.txvResult);
        tts = (TextView) findViewById(R.id.tts);
        tts1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {tts1.setLanguage(Locale.KOREAN);}
        });

        ImageView btnSpeak = (ImageView)findViewById(R.id.btnSpeak);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(btnSpeak);
        Glide.with(this).load(R.raw.mic).into(imageViewTarget); //gif 불러오기

    }

    public void getSpeechInput(View view){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.KOREA);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 10);
        }else{
            Toast.makeText(this, "당신의기기가 연결x", Toast.LENGTH_SHORT).show();
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case 10:
                if(resultCode==RESULT_OK && data != null){

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));

                    Response.Listener<String> responseLister = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try
                            {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if(success)
                                {
                                    String answer = jsonResponse.getString("answer");
                                    String addAnswer = jsonResponse.getString("add_answer");


                                    tts.setText(answer);
                                    tts1.speak(answer,TextToSpeech.QUEUE_FLUSH, null);
                                    // 파싱
                                }

                                    else{

                                        String error = "잘 모르겠습니다.";
                                        tts.setText(error);
                                        tts1.speak(error,TextToSpeech.QUEUE_FLUSH, null);
                                    }

                            }

                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    };
                    SearchRequest searchRequest = new SearchRequest((result.get(0)), responseLister);
                    RequestQueue queue = Volley.newRequestQueue(MIC.this);
                    queue.add(searchRequest);

                }

                break;
        }
    }


}