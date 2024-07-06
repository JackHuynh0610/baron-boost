package com.webapp.BaronBoost.users.models;

/**
 * Enum representing the boost status of a user.
 * 
 * <p>
 * The BoostStatus enum defines three possible boost statuses:
 * <ul>
 *   <li>BOOSTING: Indicates that the user is currently in a boosting process.</li>
 *   <li>NOT_BOOSTING: Indicates that the user is not currently in a boosting process.</li>
 *   <li>NONE: Indicates that no boost status is specified or available.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * This enum is used to track the boosting status of users in the application.
 * </p>
 * 
 */
public enum BoostStatus {
    BOOSTING,
    NOT_BOOSTING,
    NONE
}
