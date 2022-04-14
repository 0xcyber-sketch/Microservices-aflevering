package com.lange.domain.Users;

import java.util.UUID;

public class ID {
    private UUID userID;

    public ID(String id) {
        userID = UUID.fromString(id);
    }

    public ID(UUID id) {
        userID =  id;
    }

    public UUID getUserID() {
        return userID;
    }

}
