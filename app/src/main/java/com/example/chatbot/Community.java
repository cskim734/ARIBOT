package com.example.chatbot;

public class Community {

    String communityContent;
    String communityName;
    String communityDate;

    public Community(String communityContent, String communityName, String communityDate) {
        this.communityContent = communityContent;
        this.communityName = communityName;
        this.communityDate = communityDate;
    }

    public String getCommunityContent() {
        return communityContent;
    }

    public void setCommunityContent(String communityContent) {
        this.communityContent = communityContent;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityDate() {
        return communityDate;
    }

    public void setCommunityDate(String communityDate) {
        this.communityDate = communityDate;
    }
}
