package com.example.bloomi.Detail.auth_controller;

import java.io.Serializable;

public class Account implements Serializable {
    private String emailOrPhone;
    private String password;
    private String jwt;
    private int accountId;

    public Account(){}
    public Account(String emailOrPhone, String password, String jwt,int accountId) {
        this.emailOrPhone = emailOrPhone;
        this.password = password;
        this.jwt = jwt;
        this.accountId = accountId;
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
