package com.webapp.BaronBoost.utils.password_utils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Utility class for handling password reset functionalities.
 * This class provides methods to obtain the base URL of the site from an HTTP request.
 * 
 * <p>
 * Example usage:
 * <pre>
 *     HttpServletRequest request = ...;
 *     String siteURL = UtilityPasswordReset.getSiteURL(request);
 * </pre>
 * </p>
 * 
 * <p>
 * This class is designed to be used statically, and should not be instantiated.
 * </p>
 * 
 */
public class UtilityPasswordReset {

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used statically.
     */
    private UtilityPasswordReset() {}

    /**
     * Retrieves the base URL of the site from the given HTTP request.
     * 
     * @param request the HttpServletRequest object from which to extract the base URL
     * @return the base URL of the site as a String
     */
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}