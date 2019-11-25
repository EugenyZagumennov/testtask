package com.testtask.task.core.entities;

import com.testtask.task.core.entities.enums.UserRole;
import com.testtask.task.core.entities.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

/**
 * Entity class for table 'User'
 *
 * @author Evgeniy Zagumennov
 */

@Data
@NoArgsConstructor
@Entity
@Table(schema = "testdb", name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @NotNull
    @Size(max = 200)
    @Column(name = "firstName", length = 200, nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 200)
    @Column(name = "lastName", length = 200, nullable = false)
    private String lastName;


    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.CREATED;

    public User(String username, String password, String firstName, String lastName, UserRole role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == UserStatus.ACTIVE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == UserStatus.ACTIVE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == UserStatus.ACTIVE;
    }
}
