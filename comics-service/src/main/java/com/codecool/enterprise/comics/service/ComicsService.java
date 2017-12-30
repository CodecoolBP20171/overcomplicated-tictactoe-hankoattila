package com.codecool.enterprise.comics.service;


import com.codecool.enterprise.comics.utilities.HttpClient;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class ComicsService {
    public String getComicsUri() throws IOException {
        Random rnd = new Random();
        int number = rnd.nextInt(1929) + 1;
        URL url = new URL("https://xkcd.com/" + number + "/info.0.json");
        String picture = HttpClient.get(url).getString("img");
        return picture;

    }
}
