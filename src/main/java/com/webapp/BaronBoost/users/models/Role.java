package com.webapp.BaronBoost.users.models;

/**
 * Enum representing the roles of users in the application.
 * 
 * <p>
 * The Role enum defines three possible roles for users:
 * <ul>
 *   <li>ADMIN: Indicates that the user has administrative privileges.</li>
 *   <li>CUSTOMER: Indicates that the user is a regular customer.</li>
 *   <li>BOOSTER: Indicates that the user is a booster, typically involved in boosting services.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * This enum is used to assign roles to users and determine their permissions within the application.
 * </p>
 * 
 */
public enum Role {
    ADMIN,
    CUSTOMER,
    BOOSTER
}
