package com.lange.resources.login;

import com.lange.domain.Users.User;
import com.lange.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class LoggedInResource {
    private UserService userService;

    @Inject
    public LoggedInResource (UserService userService) {
        this.userService = userService;
    }

    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // PermitALl
    //@RolesAllowed({"USER, ADMIN, SUPER_USER"})
    public List<User> users() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }
}
