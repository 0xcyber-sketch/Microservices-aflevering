package com.lange.resources.login.dto;

import com.lange.domain.Users.User;

public class UserDTO {
    private final String id;
    private final  String email;
    private final String firstName;
    private final String lastName;

    public UserDTO(User user) {
        this.id =  "" + user.getUserID();
        this.email = user.getEmail().getValue();
        this.firstName = user.getName().getFirstName();
        this.lastName = user.getName().getLastName();

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
