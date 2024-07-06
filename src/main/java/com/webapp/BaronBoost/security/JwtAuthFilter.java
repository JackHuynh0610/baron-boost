package com.webapp.BaronBoost.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT Authentication Filter for handling JWT token authentication.
 * This filter intercepts incoming requests, extracts JWT tokens, and validates them.
 * If a valid token is found, it sets the authentication in the SecurityContext.
 * 
 * <p>
 * This filter extends {@link OncePerRequestFilter} to ensure it is executed once per request.
 * </p>
 * 
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private SecurityUserDetailsService userDetailsService;

    /**
     * Constructor for JwtAuthFilter.
     * 
     * @param jwtService the JwtService instance for token operations
     * @param userDetailsService the SecurityUserDetailsService instance for user details
     */
    public JwtAuthFilter(JwtService jwtService, SecurityUserDetailsService userDetailsService){
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Filters incoming requests to authenticate JWT tokens.
     * 
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @param filterChain the FilterChain for handling the request
     * @throws ServletException if an error occurs during filtering
     * @throws IOException if an error occurs during I/O operations
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}