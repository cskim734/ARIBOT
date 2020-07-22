package com.example.chatbot;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public final static String SPLIT_STR = ":::";
    private EditText inputForm;
    private TextView result;
    private Button send;
    private RecyclerView mRecyclerView;
    private String mAnswer;
    private ArrayList<Msg> mMsg;
    private RecyclerViewAdapter mAdapter;

    public void onclickmic(View v)
    {
        Intent intetn2 = new Intent(this, MIC.class);
        startActivity(intetn2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        inputForm = findViewById(R.id.editText_inputForm);
        result = findViewById(R.id.textView_result);
        send = findViewById(R.id.button_send);
        mRecyclerView = findViewById(R.id.rv_msg);
        mMsg = new ArrayList<>();
        mAdapter = new RecyclerViewAdapter(this, mMsg);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mAdapter);

        buttonAction();

    }

    private void buttonAction() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result.setText("");
                String question = inputForm.getText().toString();
                mMsg.add(new Msg(Msg.ID_USER,question));
                inputForm.setText("");
                mAdapter.notifyDataSetChanged();

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

                                mMsg.add(new Msg(Msg.ID_BOT,answer));
                                // 파싱
                                if(addAnswer!= null && !addAnswer.equals("")) {
                                    String[] parsedStrArray = addAnswer.split(SPLIT_STR);
                                    for(int i = 0; i < parsedStrArray.length;i++){
                                        mMsg.add(new Msg(Msg.ID_ADD_Q,parsedStrArray[i]));
                                    }
                                }
                                mAdapter.notifyDataSetChanged();
                                Log.d("test","add_answer = " + addAnswer);

                            }

                            else {
                                String error = "잘 모르겠습니다.";
                                mMsg.add(new Msg(Msg.ID_BOT,error));
                                mAdapter.notifyDataSetChanged();
                            }

                        }

                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                };

                SearchRequest searchRequest = new SearchRequest(question, responseLister);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(searchRequest);


            }
        });
    }

    public void plusquestion(View v)
    {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}