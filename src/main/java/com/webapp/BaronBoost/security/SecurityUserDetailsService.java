package com.webapp.BaronBoost.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.repositories.UserRepository;

import java.util.Optional;

/**
 * Custom implementation of UserDetailsService for Spring Security.
 * This class is responsible for loading user-specific data during authentication.
 * It implements the UserDetailsService interface provided by Spring Security.
 * 
 * <p>
 * It retrieves user details from the UserRepository based on the username provided during authentication.
 * </p>
 * 
 */
@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    /**
     * Loads user-specific data based on the given username.
     * 
     * @param username the username for which user details are to be loaded
     * @return UserDetails object containing user-specific details
     * @throws UsernameNotFoundException if the user with the given username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByUsername(username);
        return userInfo.map(SecurityUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}