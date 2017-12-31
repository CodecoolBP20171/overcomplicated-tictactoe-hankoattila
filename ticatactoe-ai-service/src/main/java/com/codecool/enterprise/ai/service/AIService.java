package com.codecool.enterprise.ai.service;


import com.codecool.enterprise.ai.utilities.HttpClient;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class AIService {
    public String getStep(String board, String symbol) throws IOException {
        URL url = new URL("http://tttapi.herokuapp.com/api/v1/" + board + "/" + symbol);
        System.out.println("sajt");
        JSONObject jsonObject= HttpClient.get(url);
        return jsonObject.toString();

    }
}
