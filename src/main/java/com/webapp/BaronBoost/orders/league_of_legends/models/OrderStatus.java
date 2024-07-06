package com.webapp.BaronBoost.orders.league_of_legends.models;

/**
 * Enumeration representing the status of an order in the League of Legends boosting service.
 * 
 * <p>OrderStatus can have one of the following values:</p>
 * <ul>
 *     <li>{@link #TAKEN} - Indicates that the order has been taken by a booster</li>
 *     <li>{@link #NOT_TAKEN} - Indicates that the order has not been taken yet</li>
 *     <li>{@link #COMPLETE} - Indicates that the order has been completed</li>
 * </ul>
 */
public enum OrderStatus {
    /**
     * Indicates that the order has been taken by a booster.
     */
    TAKEN,

    /**
     * Indicates that the order has not been taken yet.
     */
    NOT_TAKEN,

    /**
     * Indicates that the order has been completed.
     */
    COMPLETE
}
