package com.webapp.BaronBoost.utils.password_utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Utility class for password encoding and matching using BCrypt.
 * This class provides methods to encode raw passwords and to verify
 * if a raw password matches an encoded password.
 * <p>
 * It uses {@link BCryptPasswordEncoder} from the Spring Security framework.
 * </p>
 * 
 * <p>
 * Example usage:
 * <pre>
 *     String rawPassword = "myPassword123";
 *     String encodedPassword = PasswordEncoderUtil.encodePassword(rawPassword);
 *     boolean matches = PasswordEncoderUtil.matches(rawPassword, encodedPassword);
 * </pre>
 * </p>
 * 
 * <p>
 * This class is designed to be used statically, and should not be instantiated.
 * </p>
 * 
 */
public class PasswordEncoderUtil {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used statically.
     */
    private PasswordEncoderUtil(){}

    /**
     * Encodes a raw password using BCrypt hashing algorithm.
     * 
     * @param rawPassword the raw password to encode
     * @return the encoded password
     */
    public static String encodePassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * Verifies if a raw password matches an encoded password.
     * 
     * @param rawPassword the raw password to check
     * @param encodedPassword the encoded password to compare against
     * @return true if the raw password matches the encoded password, false otherwise
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
