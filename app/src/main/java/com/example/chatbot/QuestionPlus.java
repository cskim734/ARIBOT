package com.example.chatbot;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class QuestionPlus extends AppCompatActivity {

    private String Questionplus;
    private String Answerplus;
    private String plusques;
    private String plusanswer;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionplus);

        final EditText plusques = (EditText) findViewById(R.id.plusques);
        final EditText plusanswer = (EditText) findViewById(R.id.plusanswer);



        Button plusquestionbutton = (Button) findViewById(R.id.plusquestionbutton);
        plusquestionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Questionplus = plusques.getText().toString();
                String Answerplus = plusanswer.getText().toString();


                if(Questionplus.equals("") || Answerplus.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuestionPlus.this);
                    dialog = builder.setMessage("빈 칸 없이 입력해주세요")
                            .setNegativeButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionPlus.this);
                                dialog = builder.setMessage("글 등록에 성공했습니다")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                finish();
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionPlus.this);
                                dialog = builder.setMessage("글 등록에 실패했습니다")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                QuestionplusRequest questionplusRequest = new QuestionplusRequest(Questionplus, Answerplus, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionPlus.this);
                queue.add(questionplusRequest);
            }
        });


    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null)
        {
            dialog.dismiss();
            dialog = null;
        }
    }
}
