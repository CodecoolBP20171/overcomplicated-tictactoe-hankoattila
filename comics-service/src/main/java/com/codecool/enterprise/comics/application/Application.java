package com.codecool.enterprise.comics.application;

import com.codecool.enterprise.comics.exception.ComicsException;
import com.codecool.enterprise.comics.service.ComicsService;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        port(54446);
        get("/",((request, response) -> getComics(request,response)));
    }

    private static JSONObject getComics(Request req, Response res) throws ComicsException, IOException {
        ComicsService comicsService = new ComicsService();
        JSONObject response = new JSONObject();
        response.put("comic_uri", comicsService.getComicsUri());
        return response;
    }


}
