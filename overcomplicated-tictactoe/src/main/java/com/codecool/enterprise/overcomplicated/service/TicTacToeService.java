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
        JSONObject avatarUrl = HttpClient.get(url);
        return avatarUrl.getString("avatar_uri");
    }

    public String getFunFact() throws IOException {
        URL url = new URL("http://localhost:54448/");
        JSONObject avatarUrl = HttpClient.get(url);
        return avatarUrl.getString("funfact");
    }

    public String getComics() throws IOException {
        URL url = new URL("http://localhost:54446/");
        JSONObject avatarUrl = HttpClient.get(url);
        return avatarUrl.getString("comic_uri");
    }

}
