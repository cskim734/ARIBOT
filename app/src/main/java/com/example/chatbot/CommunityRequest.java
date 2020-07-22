package com.example.chatbot;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CommunityRequest extends StringRequest {


    final static private String URL = "http://jongsu7906.cafe24.com/Communityplus.php";
    private Map<String, String> parameters;

    public CommunityRequest(String CommunityContent, String CommunityName, String CommunityDate, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("CommunityContent", CommunityContent);
        parameters.put("CommunityName", CommunityName);
        parameters.put("CommunityDate", CommunityDate);
    }


    @Override
    public Map<String, String> getParams()  {
        return parameters;
    }
}
