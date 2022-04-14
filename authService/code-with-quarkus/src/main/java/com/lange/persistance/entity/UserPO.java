package com.lange.persistance.entity;

import com.lange.domain.Users.*;
import com.lange.domain.exception.DomainValidation;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USER_INFO")
@NamedQueries({
        @NamedQuery(name = "UserPO.findAll", query = "Select u FROM UserPO u"),
        @NamedQuery(name = "UserPO.findByEmail", query = "Select u FROM UserPO u where u.email=:email"),
        @NamedQuery(name = "UserPO.findByUsername", query = "Select u FROM UserPO u where u.userName=:username")
})
public class UserPO {
    public static final String FIND_ALL = "UserPO.findAll";
    public static final String FIND_BY_EMAIL = "UserPO.findByEmail";
    public static final String FIND_BY_EMAIL_PARAMETER = "email";
    public static final String FIND_BY_USERNAME = "UserPO.findByUsername";
    public static final String FIND_BY_USERNAME_PARAMETER = "username";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)")
    private UUID id;

    @Column(name = "USERNAME", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String email;

    @Column(name = "ROLE", columnDefinition = "varchar(100)", nullable = false)
    private String role;

    public UserPO() {
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public UserPO(Credentials credentials, com.lange.domain.Users.Role role) {
        this.email = credentials.getEmail().getValue();
        this.password = credentials.getPassword().getValue();
        this.userName = credentials.getUserName().getValue();
        this.role = role.name();

    }

    public User toUser() {
        try {
            return new User(
                    new ID(id),
                    new Credentials(new Username(userName), new Email(email), new Password(password)),
                    Role.USER
            );
        } catch (DomainValidation e) {
            throw new RuntimeException("");
        }
    }
}
