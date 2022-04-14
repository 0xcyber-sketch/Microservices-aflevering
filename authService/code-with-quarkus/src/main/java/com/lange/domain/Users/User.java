package com.lange.domain.Users;


public class User {
    private Name name;
    private ID id;
    private Password password;
    private Username userName;
    private Email email;
    private Credentials credentials;
    private Role role;

    public User(Name name, Password password, Username userName, Email email, ID id, Role role) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.id = id;
        this.email = email;
        this.role = role;

    }

    public User( Password password, Username userName, Email email, ID id, Role role) {
        this.name = null;
        this.password = password;
        this.userName = userName;
        this.id = id;
        this.email = email;
        this.role = role;

    }

    public User(ID id, Credentials credentials, Role role) {
        this.name = null;
        this.id = id;
        this.credentials = credentials;
        this.password = this.credentials.getPassword();
        this.userName = this.credentials.getUserName();
        this.email = this.credentials.getEmail();
        this.role = role;
    }



    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public Username getUserName() {
        return userName;
    }

    public ID getUserID() {
        return this.id;
    }

    public Email getEmail() {
        return email;
    }

    public String toString() {
        return this.getUserName().getValue();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Role getRole() {
        return role;
    }

}
