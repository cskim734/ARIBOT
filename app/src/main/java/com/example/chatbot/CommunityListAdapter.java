package com.example.chatbot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CommunityListAdapter extends BaseAdapter {

    private Context context;
    private List<Community> communityList;

    public CommunityListAdapter(Context context, List<Community> communityList) {
        this.context = context;
        this.communityList = communityList;
    }

    @Override
    public int getCount() {
        return communityList.size();
    }

    @Override
    public Object getItem(int i) {
        return communityList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.community, null);
        TextView communityContent = (TextView) v.findViewById(R.id.communityContent);
        TextView communityName = (TextView) v.findViewById(R.id.communityName);
        TextView communityDate = (TextView) v.findViewById(R.id.communityDate);

        communityContent.setText(communityList.get(i).getCommunityContent());
        communityName.setText(communityList.get(i).getCommunityName());
        communityDate.setText(communityList.get(i).getCommunityDate());

        v.setTag(communityList.get(i).getCommunityContent());
        return v;
    }

}
