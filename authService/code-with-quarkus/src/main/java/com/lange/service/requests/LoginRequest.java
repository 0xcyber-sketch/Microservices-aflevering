package com.lange.service.requests;

import com.lange.domain.Users.Email;
import com.lange.domain.Users.Password;
import com.lange.domain.Users.Username;
import com.lange.domain.exception.DomainValidation;

public class LoginRequest {
    private final Email email;
    private final Username userName;
    private final Password password;

    public LoginRequest(String credential, String password) {
        try {
            if (credential.contains("@")) {
                this.email = new Email(credential);
                this.userName = null;
            } else {
                this.userName = new Username(credential);
                this.email = null;
            }

            this.password = new Password(password);
        }
        catch (DomainValidation e) {

            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public Email getEmail() {
        return email;
    }

    public Username getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public boolean containsEmail() {
        return getEmail() != null;
    }

}
