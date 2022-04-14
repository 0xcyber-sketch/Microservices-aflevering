package com.lange.service;

import com.lange.domain.Users.*;
import com.lange.persistance.Rep;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional
public class UserService {
    private final Rep repository;

    @Inject
    public UserService(Rep repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers () {
        return repository.getUsers();
    }

    public User createUser(Credentials credentials, Role role) {
        return repository.createUser(credentials, role);
    }

    public User findUser(Username username, Password password) {
        return repository.findUser(username, password);
    }
}
