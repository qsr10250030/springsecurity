package com.example.springsecurity.domain;

import java.io.Serializable;


/**
 * users
 * @author 
 */

public class Users implements Serializable {
    private String username;

    private String password;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}