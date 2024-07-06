package com.webapp.BaronBoost.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Base64;

/**
 * JWT Service for handling JSON Web Tokens (JWT) operations.
 * This service provides methods for generating, validating, and extracting information from JWT tokens.
 * 
 * <p>
 * It uses the io.jsonwebtoken library for JWT processing and Spring's Component annotation for dependency injection.
 * </p>
 * 
 */
@Component
public class JwtService {

    /**
     * The secret key used for JWT token generation and validation.
     */
    public static final String SECRET = generateRandomBase64(32);

    /**
     * Generates a random Base64 encoded string of the specified length.
     * 
     * @param length the length of the random string
     * @return the random Base64 encoded string
     */
    private static String generateRandomBase64(int length) {
        byte[] randomBytes = new byte[length];
        new SecureRandom().nextBytes(randomBytes); 

        return Base64.getEncoder().encodeToString(randomBytes); 
    }

    /**
     * Extracts the username from a JWT token.
     * 
     * @param token the JWT token
     * @return the username extracted from the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the expiration date from a JWT token.
     * 
     * @param token the JWT token
     * @return the expiration date extracted from the token
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts a claim from a JWT token using a specified claims resolver function.
     * 
     * @param token the JWT token
     * @param claimsResolver the claims resolver function
     * @return the claim extracted from the token using the resolver function
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all claims from a JWT token.
     * 
     * @param token the JWT token
     * @return all claims extracted from the token
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Checks if a JWT token is expired.
     * 
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Validates a JWT token against a UserDetails object.
     * 
     * @param token the JWT token
     * @param userDetails the UserDetails object to validate against
     * @return true if the token is valid for the user details, false otherwise
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * Generates a JWT token for the specified username.
     * 
     * @param userName the username for which the token is generated
     * @return the generated JWT token
     */
    public String generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userName);
    }

    /**
     * Creates a JWT token with the specified claims and username.
     * 
     * @param claims the claims to include in the token
     * @param userName the username for which the token is created
     * @return the created JWT token
     */
    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    /**
     * Gets the signing key used for JWT token generation and validation.
     * 
     * @return the signing key as a Key object
     */
    private Key getSignKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}