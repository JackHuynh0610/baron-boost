package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class EmeraldToMaster {
    public static double getEmeraldToMasterPrice(LeagueRank cLeagueRank,
                                              LeagueDivision leagueCurrentDivision,
                                              LeagueRank dLeagueRank,
                                              LeagueDivision leagueDesiredDivision) {
        double finalPrice = 0.0;

        if (cLeagueRank.equals(LeagueRank.EMERALD) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: Emerald IV

            // To: Emerald III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 27.4;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 55.7;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 87.6;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 119.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 159.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 217.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 289.1;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 381.9;}
        }

        if (cLeagueRank.equals(LeagueRank.EMERALD) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: Emerald III

            // To: Emerald II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 29.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 57.3;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 92.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 136.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 194.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 264.7;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 359.7;}
        }

        if (cLeagueRank.equals(LeagueRank.EMERALD) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: Emerald II

            // To: Emerald I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 29.8;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 61.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 107.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 164.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 234.6;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 329.99;}
        }

        if (cLeagueRank.equals(LeagueRank.EMERALD) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: Emerald I

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 31.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 78.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 130.8;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 202.4;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 298.5;}
        }
        
        return finalPrice;
    }
}
