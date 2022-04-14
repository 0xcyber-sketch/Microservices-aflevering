package com.lange.domain.security;

public class JWTToken {
        private final String token;
        private final String userName;

        public JWTToken(String token, String userName) {
            this.token = token;
            this.userName = userName;

        }

        public String getToken() {
            return token;
        }

        public String getUserName() {
            return userName;
        }

    }

