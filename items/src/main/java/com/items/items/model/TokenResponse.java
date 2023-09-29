package com.items.items.model;

public class TokenResponse {
    private String token;
    private String username;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TokenResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }
    public TokenResponse(String token, String username, String message){
        this.token = token;
        this.username = username;
        this.message = message;
    }
}
