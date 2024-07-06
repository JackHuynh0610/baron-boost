package com.webapp.BaronBoost.users.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a user in the application.
 * 
 * <p>
 * The User class defines attributes such as id, username, password, email, role, boost status, 
 * verification code, enabled status, and reset password token for a user.
 * </p>
 * 
 * <p>
 * This class is annotated with JPA annotations to define its mapping to the database. It uses Lombok annotations
 * for generating getters, setters, constructors, and other boilerplate code.
 * </p>
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 64)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 80)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BoostStatus boostStatus;

    @Column(length = 64)
    private String verificationCode;
     
    @Column
    private boolean enabled;

    @Column
    private String resetPasswordToken;
}
