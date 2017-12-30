package com.codecool.enterprise.avatar.service;

public class AvatarService {
    public String getAvatar(String userName) {
        return "https://robohash.org/" + userName;
    }
}
