package com.example.bloomi.Detail.auth_controller;

public class Infor {
    private String emailOrPhone;
    private String accountId;
    private String jwt;

    public Infor(){}
    public Infor(String emailOrPhone, String accountId, String jwt) {
        this.emailOrPhone = emailOrPhone;
        this.accountId = accountId;
        this.jwt = jwt;
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
