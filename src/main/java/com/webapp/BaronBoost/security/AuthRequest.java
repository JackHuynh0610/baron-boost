package com.webapp.BaronBoost.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an authentication request containing user credentials.
 * This class is used for transferring user authentication data between client and server.
 * 
 * <p>
 * Example usage:
 * <pre>
 *     AuthRequest authRequest = new AuthRequest("username", "password");
 * </pre>
 * </p>
 * 
 * <p>
 * This class is annotated with Lombok annotations for generating getters, setters, constructors, and toString method.
 * </p>
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    /**
     * The username associated with the authentication request.
     */
    private String username;

    /**
     * The password associated with the authentication request.
     */
    private String password;
}