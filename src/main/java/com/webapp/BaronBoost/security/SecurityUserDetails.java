package com.webapp.BaronBoost.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.webapp.BaronBoost.users.models.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Custom UserDetails implementation for Spring Security.
 * This class represents the details of a user required by Spring Security for authentication and authorization.
 * It implements the UserDetails interface.
 * 
 * <p>
 * It contains information such as username, password, authorities, and user status.
 * </p>
 * 
 */
public class SecurityUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    private User user;

    /**
     * Constructor to create SecurityUserDetails from a User entity.
     * 
     * @param user the User entity containing user details
     */
    public SecurityUserDetails(User user) {
        name=user.getUsername();
        password=user.getPassword();
        authorities= Arrays.stream(user.getRole().name().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}