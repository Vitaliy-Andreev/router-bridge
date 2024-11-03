package ru.krsmon.bridge.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serial;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public", indexes = {@Index(name = "idx_username", columnList = "username")})
public class User extends AbstractEntity implements UserDetails {

    @Serial
    private static final long serialVersionUID = 3117347793805813801L;

    @Column(unique = true, nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    private Integer telegramId;

    @OneToMany(orphanRemoval = true, fetch = EAGER, cascade = ALL)
    private Set<Authority> authorities;

}
