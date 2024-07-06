package com.webapp.BaronBoost.orders.league_of_legends.models;

/**
 * Enumeration representing the OrderType of an order in the League of Legends boosting service.
 * 
 * <p>OrderTypecan have one of the following values:</p>
 * <ul>
 *     <li>{@link #SOLO} - Indicates that the SOLO order r</li>
 *     <li>{@link #DUO} - Indicates that the DUO order</li>
 *     <li>{@link #COACH} - Indicates that the COACH order</li>
 *     <li>{@link #NETWIN} - Indicates that the NETWIN order</li>
 * </ul>
 */
public enum OrderType {
    SOLO,
    DUO,
    COACH,
    NETWIN
}
