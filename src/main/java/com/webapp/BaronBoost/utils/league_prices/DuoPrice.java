package com.webapp.BaronBoost.utils.league_prices;

/**
 * Utility class for calculating the price for duo boosting services.
 * This class provides a method to calculate the total price based
 * on the current and desired ranks, divisions, and LP per game.
 */
public class DuoPrice {
    
    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated.
     */
    private DuoPrice() {}

    /**
     * Calculates the price for duo boosting services based on the current and desired ranks,
     * divisions, and LP (League Points) per game.
     * The price is calculated as 70% more than the solo boosting price.
     *
     * @param cLeagueRank the current league rank of the player.
     * @param leagueCurrentDivision the current division of the player within their league rank.
     * @param currentLp the current LP of the player.
     * @param dLeagueRank the desired league rank of the player.
     * @param leagueDesiredDivision the desired division of the player within their desired league rank.
     * @param lpPerGame the LP per game that the player typically earns.
     * @return the total price for the specified duo boosting service.
     */
    public static double getDuoPrice(LeagueRank cLeagueRank, LeagueDivision leagueCurrentDivision, int currentLp, LeagueRank dLeagueRank, LeagueDivision leagueDesiredDivision, int lpPerGame) {
        double soloPrice = SoloPrice.getSoloPrice(cLeagueRank, leagueCurrentDivision, currentLp, dLeagueRank, leagueDesiredDivision, lpPerGame);
        double duoPrice = commissionForBooster(soloPrice, 0.5);
        return roundToOneDecimal(duoPrice);
    }

    /**
     * Calculates the commission for the booster, which is an additional percentage
     * of the solo boosting price.
     *
     * @param soloPrice the price for solo boosting.
     * @param percent the percentage to be added as commission.
     * @return the total price including the commission for the booster.
     */
    private static double commissionForBooster(double soloPrice, double percent) {
        return soloPrice + (soloPrice * percent);
    }

    /**
     * Rounds a double value to one decimal place and ensures trailing zeros are displayed.
     *
     * @param value The double value to be rounded.
     * @return The rounded double value with one decimal place.
     */
    private static double roundToOneDecimal(double value) {
        // Format the value to one decimal place and parse it back to double
        return Double.parseDouble(String.format("%.1f", value));
    }
}
