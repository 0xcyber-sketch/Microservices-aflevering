package com.lange.service.responses;

import com.lange.domain.security.JWTToken;

public class LoginResponse {

    private final JWTToken token;

    public LoginResponse(JWTToken token) {
        this.token = token;
    }

    public JWTToken getToken() {
        return token;
    }
}
