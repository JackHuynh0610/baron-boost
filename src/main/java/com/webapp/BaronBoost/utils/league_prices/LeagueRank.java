package com.webapp.BaronBoost.utils.league_prices;

/**
 * Enum representing the ranks within a league.
 * Each rank is associated with a specific value.
 */
public enum LeagueRank {
    IRON(1),
    BRONZE(2),
    SILVER(3),
    GOLD(4),
    PLATINUM(5),
    EMERALD(6),
    DIAMOND(7),
    MASTER(8);

    private final int value;

    /**
     * Constructor for the enum, associating each rank with a specific value.
     *
     * @param value the value associated with the rank.
     */
    LeagueRank(int value) {
        this.value = value;
    }

    /**
     * Gets the value associated with the rank.
     *
     * @return the value of the rank.
     */
    public int getValue() {
        return value;
    }
}
