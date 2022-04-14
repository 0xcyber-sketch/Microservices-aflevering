package com.lange.resources.login.dto;

public class LoggedinDTO {
    private final boolean loggedIn;
    private final String userName;

    public LoggedinDTO (boolean loggedIn, String userName) {
        this.loggedIn = loggedIn;
        this.userName = userName;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}
