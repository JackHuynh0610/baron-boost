package com.webapp.BaronBoost.utils.league_prices;

/**
 * Enum representing the divisions within a league rank.
 * Each division is associated with a specific value.
 */
public enum LeagueDivision {
    IV(0),
    III(1),
    II(2),
    I(3);

    private final int value;

    /**
     * Constructor for the enum, associating each division with a specific value.
     *
     * @param value the value associated with the division.
     */
    LeagueDivision(int value) {
        this.value = value;
    }

    /**
     * Gets the value associated with the division.
     *
     * @return the value of the division.
     */
    public int getValue() {
        return value;
    }
}
