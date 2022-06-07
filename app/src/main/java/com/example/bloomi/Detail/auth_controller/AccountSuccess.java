package com.example.bloomi.Detail.auth_controller;

public class AccountSuccess {
    private Infor data;

    public AccountSuccess(){}
    public AccountSuccess(Infor data) {
        this.data = data;
    }

    public Infor getData() {
        return data;
    }

    public void setData(Infor data) {
        this.data = data;
    }
}
