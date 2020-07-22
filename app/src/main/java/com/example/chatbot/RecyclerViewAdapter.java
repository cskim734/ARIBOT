package com.example.chatbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Msg> comments;
    private Context mCtx;


    public RecyclerViewAdapter(Context ctx, ArrayList<Msg> msg){
        comments = msg;
        mCtx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageViewHolder msgViewHolder = (MessageViewHolder) holder;

        // 내가 보낸 메세지
        if (comments.get(position).id == Msg.ID_USER) {
            msgViewHolder.llMain.setVisibility(View.VISIBLE);
            msgViewHolder.btnAdd.setVisibility(View.GONE);
            msgViewHolder.tvMsg.setBackgroundResource(R.drawable.right_bubb);
            msgViewHolder.llDestination.setVisibility(View.INVISIBLE);
            msgViewHolder.llMain.setGravity(Gravity.RIGHT);

        } else if(comments.get(position).id == Msg.ID_BOT){
            // 상대가 보낸 메세지
            msgViewHolder.llMain.setVisibility(View.VISIBLE);
            msgViewHolder.btnAdd.setVisibility(View.GONE);
            msgViewHolder.ivProfile.setImageResource(R.drawable.logo);
            msgViewHolder.llDestination.setVisibility(View.VISIBLE);
            msgViewHolder.tvMsg.setBackgroundResource(R.drawable.left_bubb);
            msgViewHolder.llMain.setGravity(Gravity.LEFT);
        }else{
            msgViewHolder.llMain.setVisibility(View.GONE);
            msgViewHolder.btnAdd.setVisibility(View.VISIBLE);
            msgViewHolder.btnAdd.setText(comments.get(position).text);
        }
        msgViewHolder.tvMsg.setText(comments.get(position).text);
        msgViewHolder.tvMsg.setTextSize(25);

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    private class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMsg;
        public ImageView ivProfile;
        public LinearLayout llDestination;
        public LinearLayout llMain;
        public Button btnAdd;

        public MessageViewHolder(View view) {
            super(view);
            tvMsg = view.findViewById(R.id.tv_msg_item);
            ivProfile = view.findViewById(R.id.iv_img);
            llDestination = view.findViewById(R.id.ll_destination);
            llMain = view.findViewById(R.id.ll_msg_main);
            btnAdd = view.findViewById(R.id.btn_add);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.add(new Msg(Msg.ID_USER,btnAdd.getText().toString()));
                    notifyDataSetChanged();


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

                                    comments.add(new Msg(Msg.ID_BOT,answer));
                                    // 파싱
                                    if(addAnswer!= null && !addAnswer.equals("")) {
                                        String[] parsedStrArray = addAnswer.split(MainActivity.SPLIT_STR);
                                        for(int i = 0; i < parsedStrArray.length;i++){
                                            comments.add(new Msg(Msg.ID_ADD_Q,parsedStrArray[i]));
                                        }
                                    }
                                    notifyDataSetChanged();
                                    Log.d("test","add_answer = " + addAnswer);
                                }
                                else {
                                    String error = "잘 모르겠습니다.";
                                    comments.add(new Msg(Msg.ID_BOT,error));
                                    notifyDataSetChanged();
                                }
                            }

                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    };

                    SearchRequest searchRequest = new SearchRequest(btnAdd.getText().toString(), responseLister);
                    RequestQueue queue = Volley.newRequestQueue(mCtx);
                    queue.add(searchRequest);
                }
            });
        }
    }


}
