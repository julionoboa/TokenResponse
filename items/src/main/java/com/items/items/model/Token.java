package com.items.items.model;

import java.time.LocalDateTime;

public class Token {
    private String token;
    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;
    private String username;

    public Token(String token, LocalDateTime creationTime, LocalDateTime expirationTime, String username) {
        this.token = token;
        this.creationTime = creationTime;
        this.expirationTime = expirationTime;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}