package com.lange.service;

import com.lange.domain.Users.Credentials;
import com.lange.domain.Users.Role;
import com.lange.domain.Users.User;
import com.lange.domain.security.JWTToken;
import com.lange.persistance.Rep;
import com.lange.service.requests.LoginRequest;
import com.lange.service.requests.SignupRequest;
import com.lange.service.responses.LoginResponse;
import com.lange.service.responses.SignupResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class AuthService {

    private final Rep repository;
    private final JWTService jwtService;
    private final UserService userService;

    @Inject
    public AuthService(Rep rep, JWTService jwtService, UserService userService) {
        repository = rep;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public SignupResponse signup(SignupRequest request) {
        if (this.repository.UserExists(request.getUserName(), request.getEmail())) {
            throw new IllegalArgumentException("fejl");

        }
        Role role = Role.USER;
        Credentials c = new Credentials(request.getUserName(), request.getEmail(), request.getPassword());
        User u = userService.createUser(c, role);



        return new SignupResponse(u);
    }

    public LoginResponse login(LoginRequest request) {
        User u = userService.findUser(request.getUserName(), request.getPassword());
        System.out.println(u);
        if (u == null) {
            // Should be a better execption
            throw new IllegalArgumentException("Fejl");
        }
        JWTToken token = jwtService.createJWT(u);
        return new LoginResponse(token);
    }
}
