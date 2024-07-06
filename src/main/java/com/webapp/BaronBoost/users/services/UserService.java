package com.webapp.BaronBoost.users.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webapp.BaronBoost.users.models.BoostStatus;
import com.webapp.BaronBoost.users.models.User;

import jakarta.mail.MessagingException;

/**
 * Interface defining operations for managing user-related functionalities.
 * 
 * <p>
 * The UserService interface provides methods for performing CRUD operations on users, 
 * verifying user accounts, updating user information, managing user boost status, 
 * handling password reset functionalities, and other user-related operations.
 * </p>
 * 
 * <p>
 * Implementations of this interface handle the business logic for interacting with 
 * the user repository and performing necessary operations.
 * </p>
 * 
 */
public interface UserService {
    List<User> findAllUser();
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);

    User saveUser(User user, String siteURL) throws IOException, MessagingException;
    boolean verify(String verificationCode);

    String deleteUserById(Long id);
    String deleteUserByUsername(String username);

    User updateUserById(Long id, User user);
    User updateUserByUsername(String username, User user);
    User updateUserBoostStatusById(Long id, BoostStatus status);
    User updateUserBoostStatusByUsername(String username, BoostStatus status);

    void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException;
    User getByResetPasswordToken(String token);
    void updatePassword(User user, String newPassword);
}
