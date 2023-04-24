package com.example.restaurantforusers.model;

import com.example.restaurantforusers.config.Auth;

public class User {
    private int id;
    private String nick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String password;

    public User() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = Auth.hashPassword(password);
        this.password = password;
    }

    public User(int id,String nick, String password) {
        this.nick = nick;
        this.password = password;
        this.id = id;
    }
}
