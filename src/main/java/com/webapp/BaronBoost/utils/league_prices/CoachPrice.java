package com.webapp.BaronBoost.utils.league_prices;

/**
 * Utility class for calculating the price for coaching services.
 * This class provides a method to calculate the total price based
 * on the number of games.
 */
public class CoachPrice {
    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated.
     */
    private CoachPrice(){}

    /**
     * Calculates the price for coaching services based on the number of games.
     * The price is calculated as 15.5 units per game.
     *
     * @param numberOfGame the number of games for which the coaching price is to be calculated.
     *                     Must be a non-negative integer.
     * @return the total price for the specified number of games.
     * @throws IllegalArgumentException if {@code numberOfGame} is negative.
     */
    public static double getCoachPrice(int numberOfGame){
        if (numberOfGame < 0) {
            throw new IllegalArgumentException("numberOfGame cannot be negative");
        }
        return roundToTwoDecimal(15.5 * numberOfGame);
    }

    /**
     * Rounds a double value to one decimal place and ensures trailing zeros are displayed.
     *
     * @param value The double value to be rounded.
     * @return The rounded double value with one decimal place.
     */
    private static double roundToTwoDecimal(double value) {
        // Format the value to one decimal place and parse it back to double
        return Double.parseDouble(String.format("%.2f", value));
    }
}