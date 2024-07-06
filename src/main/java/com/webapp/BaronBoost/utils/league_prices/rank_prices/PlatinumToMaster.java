package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class PlatinumToMaster {

    private PlatinumToMaster(){}

    public static double getPlatToMasterPrice(LeagueRank cLeagueRank,
                                              LeagueDivision leagueCurrentDivision,
                                              LeagueRank dLeagueRank,
                                              LeagueDivision leagueDesiredDivision) {
        double finalPrice = 0.0;

        if (cLeagueRank.equals(LeagueRank.PLATINUM) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: Platinum IV

            // To: Platinum III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 15.5;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 33.2;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 55.6;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 82.3;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 109.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 139.5;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 169.9;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 200.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 238.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 299.99;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 368.9;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 468.6;}
        }

        if (cLeagueRank.equals(LeagueRank.PLATINUM) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: Platinum III

            // To: Platinum II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 17.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 38.2;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 65.3;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 94.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 119.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 143.2;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 183.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 227.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 281.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 356.6;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 451.3;}
        }

        if (cLeagueRank.equals(LeagueRank.PLATINUM) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: Platinum II

            // To: Platinum II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 18.4;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 47.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 71.93;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 101.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 132.3;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 163.2;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 209.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 262.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 339.2;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 429.4;}
        }

        if (cLeagueRank.equals(LeagueRank.PLATINUM) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: Platinum I

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 26.4;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 52.3;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 81.3;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 110.3;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 141.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 188.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 239.2;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 319.9;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 409.5;}
        }
        
        return finalPrice;
    }
}
