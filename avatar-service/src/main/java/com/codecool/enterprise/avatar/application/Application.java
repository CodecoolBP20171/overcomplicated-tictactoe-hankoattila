package com.codecool.enterprise.avatar.application;

import com.codecool.enterprise.avatar.exception.AvatarException;
import com.codecool.enterprise.avatar.service.AvatarService;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        port(54444);
        get("/:name", Application::getURL);
    }

    private static JSONObject getURL(Request req, Response res) throws AvatarException {
        AvatarService avatarService = new AvatarService();
        JSONObject response = new JSONObject();
        response.put("avatar_uri",avatarService.getAvatar(req.params("name")));
        return response;
    }



}
