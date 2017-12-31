package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.HttpClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class TicTacToeService {

    public String getAvatar(String userName) throws IOException {
        URL url = new URL("http://localhost:54444/" + userName);
        JSONObject jsonObject = HttpClient.get(url);
        return jsonObject.getString("avatar_uri");
    }

    public String getFunFact() throws IOException {
        URL url = new URL("http://localhost:54448/");
        JSONObject jsonObject = HttpClient.get(url);
        return jsonObject.getString("funfact");
    }

    public String getComics() throws IOException {
        URL url = new URL("http://localhost:54446/");
        JSONObject jsonObject = HttpClient.get(url);
        return jsonObject.getString("comic_uri");
    }
    public String getAi(String board, String symbol) throws IOException {
        URL url = new URL("http://localhost:54442/" + board + "/" + symbol);
        JSONObject jsonObject = HttpClient.get(url);
        return jsonObject.toString();
    }

}
