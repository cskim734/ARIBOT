package com.example.chatbot;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends AppCompatActivity {

    public void onClick1(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anyang.ac.kr/"));
        startActivity(intent);
    }
    public void onClickplus(View v)
    {
        Intent intetn2 = new Intent(this, CommunityPlus.class);
        startActivity(intetn2);
    }

    private ListView communityListView;
    private CommunityListAdapter adapter;
    private List<Community> communityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        communityListView = (ListView) findViewById(R.id.noticeListView);
        communityList = new ArrayList<Community>();

        adapter = new CommunityListAdapter(getApplicationContext(), communityList);
        communityListView.setAdapter(adapter);

        new BackgroundTask().execute();
    }


    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute(){
            target = "http://jongsu7906.cafe24.com/CommunityList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count=0;
                String communityContent, communityName, communityDate;
                while(count < jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    communityContent = object.getString("communityContent");
                    communityName = object.getString("communityName");
                    communityDate = object.getString("communityDate");
                    Community community = new Community(communityContent, communityName, communityDate);
                    communityList.add(community);
                    adapter.notifyDataSetChanged();
                    count++;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
