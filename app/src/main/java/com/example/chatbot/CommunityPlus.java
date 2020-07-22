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

public class CommunityPlus extends AppCompatActivity {

    private String CommunityContent;
    private String CommunityName;
    private String CommunityDate;
    private String comtext;
    private String comname;
    private String comdate;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communityplus);

        final EditText comtext = (EditText) findViewById(R.id.comtext);
        final EditText comname = (EditText) findViewById(R.id.comname);
        final EditText comdate = (EditText) findViewById(R.id.comdate);



        Button communitybutton = (Button) findViewById(R.id.communitybutton);
        communitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CommunityContent = comtext.getText().toString();
                String CommunityName = comname.getText().toString();
                String CommunityDate = comdate.getText().toString();


                if(CommunityContent.equals("") || CommunityName.equals("") || CommunityDate.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CommunityPlus.this);
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
                                AlertDialog.Builder builder = new AlertDialog.Builder(CommunityPlus.this);
                                dialog = builder.setMessage("글 등록에 성공했습니다")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                finish();
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CommunityPlus.this);
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
                CommunityRequest communityRequest = new CommunityRequest(CommunityContent, CommunityName, CommunityDate, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CommunityPlus.this);
                queue.add(communityRequest);
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
