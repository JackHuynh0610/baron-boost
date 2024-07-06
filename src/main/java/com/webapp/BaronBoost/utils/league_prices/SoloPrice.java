package com.webapp.BaronBoost.utils.league_prices;

import com.webapp.BaronBoost.utils.league_prices.rank_prices.BronzeToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.DiamondToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.EmeraldToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.GoldToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.IronToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.PlatinumToMaster;
import com.webapp.BaronBoost.utils.league_prices.rank_prices.SilverToMaster;

/**
 * Utility class for calculating the price for solo services.
 * This class provides a method to calculate the total price based
 * on Current League Rank, Current Division, Desired League Rank, Desired Division
 * while take current LP and Lp gain per game into account.
 */
public class SoloPrice {
    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated.
     */
    private SoloPrice(){} 

    /**
     * Calculates the price for solo services based on based
     * on Current League Rank, Current Division, Desired League Rank, Desired Division
     * while take current LP and Lp gain per game into account.
     * The price is calculated as 15.5 units per game.
     *
     * @param cLeagueRank The current League Rank for the account.
     *                    Current League Rank must be lower or equal to desire League Rank.
     * 
     * @param leagueCurrentDivision current division of the account.
     * 
     * @param currentLp Current Lp of the account.
     * 
     * @param dLeagueRank The desire League Rank for the account.
     *                    Must be higher or equal to current League Rank, can't be lower.
     * 
     * @param leagueDesiredDivision The desired division of the account.
     * 
     * @param lpPerGame The Lp gain per game.
     *                  Must be POSITIVE.
     * 
     * @return the total price for the solo boost service.
     * @throws IllegalArgumentException if LpPerGame < 0 (NEGATIVE);
     * @throws IllegalArgumentException if currentLp > 100 (NEGATIVE);
     * @throws IllegalArgumentException if cLeagueRank > dLeagueRank;
     * @throws IllegalArgumentException if divisionGap <= 0;
     */
    public static double getSoloPrice(LeagueRank cLeagueRank, LeagueDivision leagueCurrentDivision , int currentLp, LeagueRank dLeagueRank, LeagueDivision leagueDesiredDivision, int lpPerGame){
        double finalPrice = 0.0;

        int divisionGap = calculatedDivisionGap(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);

        if(checkValidLpPerGame(lpPerGame)){
            throw new IllegalArgumentException("Lp per game can't be negative");
        }

        if(checkValidCurrentLp(currentLp)){
            throw new IllegalArgumentException("Current Lp can't exceed 99");
        }

        if(checkValidCurrentRankAndDesireRank(cLeagueRank, dLeagueRank)){
            throw new IllegalArgumentException("Current League Rank can't be higher than Desire League Rank");
        }

        if(divisionGap <= 0){
            throw new IllegalArgumentException("Division gap can't be less than or equal to 0");
        }

        switch (cLeagueRank) {
            case IRON:
                finalPrice = IronToMaster.getIronToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            case BRONZE:
                finalPrice = BronzeToMaster.getBronzeToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            case SILVER:
                finalPrice = SilverToMaster.getSilverToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            case GOLD:
                finalPrice = GoldToMaster.getGoldToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            case PLATINUM:
                finalPrice = PlatinumToMaster.getPlatToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;

            case EMERALD:
                finalPrice = EmeraldToMaster.getEmeraldToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            case DIAMOND:
                finalPrice = DiamondToMaster.getDiamondToMasterPrice(cLeagueRank, leagueCurrentDivision, dLeagueRank, leagueDesiredDivision);
                break;
        
            default:
                break;
        }
        
        double applyDiscountPrice = getFinalPriceWithDiscountOrNot(lpPerGame, currentLp, finalPrice);
        if(applyDiscountPrice < 0){
            throw new IllegalStateException("final price can't be negative");
        }

        return roundToTwoDecimal(applyDiscountPrice);
    }

    /**
     * Calculate the division gap. 
     * If the rank are the same then calculate the different between current division and desire devision.
     * If the rank are noot the same simple return the desired division.
     * 
     * @param cLeagueRank
     * 
     * @param leagueCurrentDivision
     * 
     * @param dLeagueRank
     * 
     * @param leagueDesiredDivision
     * 
     * @return divisionGap or 0 if there is no gap or -1 if sameRank with same division.
     */
    private static int calculatedDivisionGap(LeagueRank cLeagueRank, LeagueDivision leagueCurrentDivision ,LeagueRank dLeagueRank, LeagueDivision leagueDesiredDivision){
        int divisionGap = 0;
        if(cLeagueRank.name().equals(dLeagueRank.name())){ 
            divisionGap = leagueDesiredDivision.getValue() - leagueCurrentDivision.getValue();
            if(divisionGap == 0){
                divisionGap = -1;
            }
        }else{
            int startRankValue = (cLeagueRank.getValue() - 1) * 4 + leagueCurrentDivision.getValue();
            int endRankValue = (dLeagueRank.getValue() - 1) * 4 + leagueDesiredDivision.getValue();
            divisionGap = endRankValue - startRankValue;
        }
        return divisionGap;
    }

    /**
     * Check if the input lpPerGame is valid.
     * 
     * @param lpPerGame
     * 
     * @return true if lpPerGame < 0, false otherwise.
     */
    private static boolean checkValidLpPerGame(int lpPerGame){
        return lpPerGame < 0;
    }

    /**
     * Check if the input Rank by user is valid.
     * This is a helper for function getSoloPrice();
     * 
     * @param cLeagueRank 
     * 
     * @param dLeagueRank 
     * 
     * @return true if current rank is > desire rank, false otherwise.
     */
    private static boolean checkValidCurrentRankAndDesireRank(LeagueRank cLeagueRank, LeagueRank dLeagueRank){
        return cLeagueRank.getValue() > dLeagueRank.getValue();
    }

    /**
     * Apply discount for the final price if applicable.
     * Condition is currentLp > (X) or lpPerGame > (Y)
     * This is a helper for function getSoloPrice();
     * 
     * @param lpPerGame 
     * 
     * @param currentLp 
     * 
     * @param currentPrice 
     * 
     * @param percent 
     * 
     * @return the finalPrice with apply discount if applicable
     */
    private static double getFinalPriceWithDiscountOrNot(int lpPerGame, int currentLp, double currentPrice){
        double finalPrice = currentPrice;
        //currentLp condition
        if(currentLp <= 49){
            finalPrice *= 1.01; //increase
        }else{
            finalPrice *= 0.95; //decrease
        }

        //lpPerGame condition
        if(lpPerGame <= 14){
            finalPrice *= 1.01; //increase
        }else if(lpPerGame <= 17){
            finalPrice *= 1.005; //increase
        }else{
            finalPrice *= 0.95; //decrease
        }
        return finalPrice;
    }

    /**
     * Checking if the input currentLp is valid by the user.
     * This is a helper for function getSoloPrice();
     * 
     * @param currentLp 
     * 
     * @return true if the currentLp is > 100, false otherwise.
     */
    private static boolean checkValidCurrentLp(int currentLp){
        return currentLp > 100;
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
