package com.codecool.enterprise.overcomplicated.model;

import org.springframework.stereotype.Component;

@Component
public class Player {
    String userName = "Anonymous";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
