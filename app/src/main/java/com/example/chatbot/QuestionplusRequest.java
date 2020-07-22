package com.example.chatbot;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class QuestionplusRequest extends StringRequest {


    final static private String URL = "http://jongsu7906.cafe24.com/Questionplus.php";
    private Map<String, String> parameters;

    public QuestionplusRequest(String Questionplus, String Answerplus,  Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("Questionplus", Questionplus);
        parameters.put("Answerplus", Answerplus);
    }


    @Override
    public Map<String, String> getParams()  {
        return parameters;
    }
}
