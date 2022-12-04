package com.github.chinyangatl.redfox.model.beans;

public class Actor {
    private int id;
    private String email, password;

    public Actor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Actor(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
