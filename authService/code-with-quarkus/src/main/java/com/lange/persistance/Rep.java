package com.lange.persistance;




import com.lange.domain.Users.*;

import com.lange.persistance.entity.UserPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@Dependent
@Transactional
public class Rep {
    private final EntityManager entityManager;

    @Inject
    public Rep(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Users
    public List<User> getUsers() {
        return entityManager.createNamedQuery(UserPO.FIND_ALL, UserPO.class).getResultList().stream().map(UserPO::toUser).collect(Collectors.toList());
    }

    public boolean UserExists(Username username, Email email) {
        return getUsers().stream().anyMatch(u -> u.getUserName().equals(username) || u.getEmail().equals(email));
    }

    public User getUserByEmail(String email) {
        try {
            return entityManager.createNamedQuery(UserPO.FIND_BY_EMAIL, UserPO.class)
                    .setParameter(UserPO.FIND_BY_EMAIL_PARAMETER, email)
                    .getSingleResult().toUser();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User createUser(Credentials credentials, Role role) {
        UserPO user = new UserPO(credentials, role);
        entityManager.persist(user);
        return user.toUser();
    }


    public User findUser(Username username, Password password) {
        try {
            UserPO user = entityManager.createNamedQuery(UserPO.FIND_BY_USERNAME, UserPO.class)
                    .setParameter(UserPO.FIND_BY_USERNAME_PARAMETER, username.getValue())
                    .getSingleResult();

            if (!password.getValue().equals(user.getPassword())) {
                return null;
            }
            else {
                return  user.toUser();
            }
        } catch (NoResultException e) {
            return null;
        }
    }




}
