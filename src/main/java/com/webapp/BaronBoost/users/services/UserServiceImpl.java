package com.webapp.BaronBoost.users.services;

import com.webapp.BaronBoost.users.models.BoostStatus;
import com.webapp.BaronBoost.users.models.Role;
import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.repositories.UserRepository;
import com.webapp.BaronBoost.utils.html_css_converter.HTMLCSSToStringUtil;
import com.webapp.BaronBoost.utils.password_utils.PasswordEncoderUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.EntityNotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface that provides methods for managing user-related operations.
 * This service class handles user creation, retrieval, update, deletion, password management, and email verification.
 *
 * <p>Key functionalities include:</p>
 * <ul>
 *     <li>Creating a new user account</li>
 *     <li>Verifying user accounts via email</li>
 *     <li>Finding users by ID or username</li>
 *     <li>Updating user information, boost status, and password</li>
 *     <li>Deleting users by ID or username</li>
 *     <li>Generating and managing reset password tokens</li>
 * </ul>
 *
 * @see UserService
 * @see UserRepository
 * @see User
 * @see Role
 * @see BoostStatus
 * @see JavaMailSender
 * @see MimeMessageHelper
 * @see MessagingException
 * @see EntityNotFoundException
 * @see UsernameNotFoundException
 * @see PasswordEncoderUtil
 * @see RandomString
 * @see HTMLCSSToStringUtil
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final int MAX_ADMINS = 2;

    private JavaMailSender mailSender;

    public UserServiceImpl(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public User saveUser(User user, String siteURL) throws MessagingException, IOException {
        long adminCount = userRepository.countAdminUsers();

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (user.getRole().name().equals(Role.ADMIN.name()) && adminCount >= MAX_ADMINS) {
            throw new RuntimeException("Cannot create more than " + MAX_ADMINS + " admin users");
        }
        String passwordEncoded = PasswordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(passwordEncoded);
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);
        sendVerificationEmail(user, siteURL);
        return userRepository.save(user);
    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);
        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);
            return true;
        }
    }

    private void sendVerificationEmail(User user, String siteURL) throws MessagingException, IOException {
        System.out.println("Sending verification email to: " + user.getEmail() + " with siteURL: " + siteURL);
        String toAddress = user.getEmail();
        String fromAddress = "baronboostservice@gmail.com";
        String senderName = "Baron Boost";
        String subject = "Please verify your registration (DO NOT REPLY)";

        System.out.println("SiteURL incoming: " + siteURL);
        String content = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Verify Email</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #1a1a1a;
                            margin: 0;
                            padding: 0;
                            color: #d3d3d3;
                        }
                        .container {
                            width: 90%;
                            max-width: 600px;
                            margin: 20px auto;
                            background-color: #2e2e2e;
                            border-radius: 8px;
                            padding: 20px;
                            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
                            border: 1px solid #4b0082;
                        }
                        p {
                            color: #d3d3d3;
                            line-height: 1.6;
                            margin-bottom: 10px;
                        }
                        h3 {
                            color: #d3d3d3;
                            text-align: center;
                            margin-top: 20px;
                            margin-bottom: 20px;
                        }
                        a {
                            color: #000000;
                            background-color: #f4f1f7;
                            border: 1px solid #4b0082;
                            padding: 10px 20px;
                            text-decoration: none;
                            border-radius: 5px;
                            display: inline-block;
                            transition: background-color 0.3s ease;
                        }
                        .footer {
                            text-align: center;
                            margin-top: 20px;
                            font-size: 0.9em;
                            color: #a9a9a9;
                        }
                        a:hover {
                            background-color: #6a0dad;
                            border-color: #6a0dad;
                        }
                        /* Media Queries */
                        @media only screen and (max-width: 600px) {
                            .container {
                                padding: 10px;
                            }
                            a {
                                padding: 8px 16px;
                            }
                            h3 {
                                font-size: 1.2em;
                            }
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <p>Dear %user_name,</p>
                        <p>Welcome to Baron Boost!</p>
                        <p>First, we want to say thank you for signing up and choosing our services!</p>
                        <p>Please take a moment to verify your registration by clicking:</p>
                        <h3><a href="%verification_link">VERIFY YOUR ACCOUNT</a></h3>
                        <p>Again, thank you for choosing Baron Boost.</p>
                        <p>Sincerely,<br>Baron Boost Team</p>
                        <div class="footer">
                            &copy; <span id="current-year"></span> Baron Boost. All rights reserved.
                        </div>
                        <script>
                            document.getElementById("current-year").textContent = new Date().getFullYear();
                        </script>
                    </div>
                </body>
                </html>
                """.replace("%user_name", user.getUsername()).replace("%verification_link", siteURL + "/authenticate/verify?code=" + user.getVerificationCode());


        System.out.println("Verification code: " + user.getVerificationCode());
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);
        System.out.println("Sending email to: " + user.getEmail());
        mailSender.send(message);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        String message = "User with id: " + id + " deleted successfully";
        return message;
    }

    @Override
    public String deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "User with username: " + username + " deleted successfully";
        } else {
            throw new EntityNotFoundException("Can't find user with username: " + username);
        }
    }

    @Override
    public User updateUserById(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (updatedUser.getUsername() != null) {
                user.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getBoostStatus() != null) {
                user.setBoostStatus(updatedUser.getBoostStatus());
            }
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public User updateUserByUsername(String username, User updatedUser) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (updatedUser.getUsername() != null) {
                user.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getBoostStatus() != null) {
                user.setBoostStatus(updatedUser.getBoostStatus());
            }
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public User updateUserBoostStatusById(Long id, BoostStatus status) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBoostStatus(status);
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    @Override
    public User updateUserBoostStatusByUsername(String username, BoostStatus status) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBoostStatus(status);
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with username: " + username);
        }
    }

    @Override
    public void updateResetPasswordToken(String token, String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("Could not find any customer with the username " + username);
        }
    }

    @Override
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        String passwordEncoded = PasswordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(passwordEncoded);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}