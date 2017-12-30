package com.codecool.enterprise.funfact.service;


import com.codecool.enterprise.funfact.utilities.HttpClient;

import java.io.IOException;
import java.net.URL;

public class FunFactService {
    public String getFunFact() throws IOException {
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        String funFact = HttpClient.get(url).getString("value");
        return funFact;

    }
}
