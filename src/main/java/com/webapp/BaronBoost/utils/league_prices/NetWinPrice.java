package com.webapp.BaronBoost.utils.league_prices;

/**
 * Utility class for calculating the price for net win services.
 * This class provides a method to calculate the total price based
 * on the current league rank and the number of games.
 */
public class NetWinPrice {
    
    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated.
     */
    private NetWinPrice() {}

    /**
     * Calculates the price for net win services based on the current league rank
     * and the number of games.
     *
     * @param currentRank the current league rank of the player.
     * @param numberOfGame the number of games for which the net win price is to be calculated.
     *                     Must be a positive integer.
     * @return the total price for the specified number of net win games.
     */
    public static double getNetWinPrice(LeagueRank currentRank, int numberOfGame) {
        double finalPrice = 0.0;
        int threshold = getThreshold(currentRank);

        // Cap the number of games at the threshold
        numberOfGame = Math.min(numberOfGame, threshold);
        switch (currentRank) {
            case IRON:
                finalPrice = 4.0 * numberOfGame;
                break;
            case BRONZE:
                finalPrice = 6.0 * numberOfGame;
                break;
            case SILVER:
                finalPrice = 8.0 * numberOfGame;
                break;
            case GOLD:
                finalPrice = 20.0 * numberOfGame;
                break;
            case PLATINUM:
                finalPrice = 32.0 * numberOfGame;
                break;
            case EMERALD:
                finalPrice = 57.0 * numberOfGame;
                break;
            case DIAMOND:
                finalPrice = 70.0 * numberOfGame;
                break;
            case MASTER:
                finalPrice = 110.0 * numberOfGame;
                break;
            default:
                break;
        }
        return roundToTwoDecimal(finalPrice);
    }

     /**
     * Calculates the threshhold for each rank in netwin
     *
     * @param rank the current league rank of the player.
     * 
     * @return the threshold.
     */
    private static int getThreshold(LeagueRank rank) {
        switch (rank) {
            case IRON:
            case BRONZE:
            case SILVER:
            case GOLD:
            case PLATINUM:
            case EMERALD:
            case DIAMOND:
                return 5;  
            case MASTER:
                return 3;  
            default:
                return 0; 
        }
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
