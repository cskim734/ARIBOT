package com.example.chatbot;

public class YoutubeVideo {
    String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public YoutubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
