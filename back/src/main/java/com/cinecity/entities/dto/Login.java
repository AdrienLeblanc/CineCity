package com.cinecity.entities.dto;

import java.io.Serializable;

public class Login implements Serializable {

    private String login;
    private String password;

    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
