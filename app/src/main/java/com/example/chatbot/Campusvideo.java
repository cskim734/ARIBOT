package com.example.chatbot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class Campusvideo extends AppCompatActivity {
    //recycler view field
    RecyclerView recyclerView;
    //vector video url
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //load video list
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/MxU12BzxkEw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2cg_F9ZOeDQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/O_D72PlqtAI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/QlqIXQHq1go\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CyMOPfLin7A\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9hIDH3442UQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
}
