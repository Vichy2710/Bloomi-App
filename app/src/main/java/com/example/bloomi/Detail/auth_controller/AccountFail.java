package com.example.bloomi.Detail.auth_controller;

public class AccountFail extends Account{

    private String userMessage;

    public AccountFail(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
