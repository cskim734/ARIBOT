package com.example.chatbot;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest extends StringRequest {
    final static private String URL = "http://jongsu7906.cafe24.com/Search.php";
    private Map<String, String> parameters;

    public SearchRequest(String question, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("question", question);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}

