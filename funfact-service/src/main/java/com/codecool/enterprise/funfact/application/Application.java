package com.codecool.enterprise.funfact.application;

import com.codecool.enterprise.funfact.exception.FunFactException;
import com.codecool.enterprise.funfact.service.FunFactService;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        port(54448);
        get("/", Application::getFunFact);
    }

    private static JSONObject getFunFact(Request req, Response res) throws FunFactException, IOException {
        FunFactService funFactService = new FunFactService();
        JSONObject response = new JSONObject();
        response.put("funfact", funFactService.getFunFact());
        return response;
    }


}
