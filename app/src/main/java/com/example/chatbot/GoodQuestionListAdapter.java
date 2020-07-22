package com.example.chatbot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GoodQuestionListAdapter extends BaseAdapter {
    private Context context;
    private List<GoodQuestion> goodquestionList;

    public GoodQuestionListAdapter(Context context, List<GoodQuestion> goodquestionList) {
        this.context = context;
        this.goodquestionList = goodquestionList;

    }

    @Override
    public int getCount() {
        return goodquestionList.size();
    }

    @Override
    public Object getItem(int i) {
        return goodquestionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.goodquestion, null);
        TextView questionq = (TextView) v.findViewById(R.id.questionq);
        TextView questiona = (TextView) v.findViewById(R.id.questiona);

        questionq.setText(goodquestionList.get(i).getQuestionQ());
        questiona.setText(goodquestionList.get(i).getQuestionA());

        v.setTag(goodquestionList.get(i).getQuestionQ());
        return v;
    }
}
