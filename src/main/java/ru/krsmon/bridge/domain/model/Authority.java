package ru.krsmon.bridge.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import java.io.Serial;

@Getter
@Setter
@Entity
@Table(name = "authorities", schema = "public",
        indexes = {@Index(name = "idx_authority", columnList = "authority")})
public class Authority extends AbstractEntity implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 872535425170367453L;

    @Column(unique = true, nullable = false, length = 30)
    private String authority;

}
