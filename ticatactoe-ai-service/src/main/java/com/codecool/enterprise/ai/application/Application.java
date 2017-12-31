package com.codecool.enterprise.ai.application;

import com.codecool.enterprise.ai.exception.AIException;
import com.codecool.enterprise.ai.service.AIService;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        port(54442);
        get("/:board/:symbol", Application::getAi);
    }

    private static String getAi(Request req, Response res) throws AIException, IOException {
        AIService AIervice = new AIService();
        return AIervice.getStep(req.params("board"), req.params("symbol"));
    }


}
