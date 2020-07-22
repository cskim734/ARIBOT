package com.example.chatbot;

public class Msg {
    public final static int ID_BOT = 0;
    public final static int ID_USER = 1;
    public final static int ID_ADD_Q = 2;
    int id;
    String text;

    public Msg(int id, String text){
        this.id = id;
        this.text = text;
    }
}
