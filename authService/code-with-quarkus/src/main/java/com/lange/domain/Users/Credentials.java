package com.lange.domain.Users;

public class Credentials {
    private final Username userName;
    private final Email email;
    private final Password password;

    public Credentials(Username userName, Email email, Password password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Username getUserName() {
        return userName;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }
}