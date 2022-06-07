package com.example.bloomi.Detail.auth_controller;

public class Account {
    protected String status;
    protected Object x ;


    public Account(){}
    public Account(String status, Object x) {
        this.status = status;
        this.x = x;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }
}
