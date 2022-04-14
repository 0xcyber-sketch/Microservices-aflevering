package com.lange.resources.login.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpDTO {
    private final String email;
    private final String userName;
    private final String password;

    @JsonCreator
    public SignUpDTO(@JsonProperty("email") String email, @JsonProperty("userName") String userName,@JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}