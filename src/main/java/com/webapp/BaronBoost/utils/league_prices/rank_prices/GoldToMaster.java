package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class GoldToMaster {

    private GoldToMaster(){}

    public static double getGoldToMasterPrice(LeagueRank cLeagueRank, 
                                      LeagueDivision leagueCurrentDivision, 
                                      LeagueRank dLeagueRank, 
                                      LeagueDivision leagueDesiredDivision){
        double finalPrice = 0.0;
        
        if (cLeagueRank.equals(LeagueRank.GOLD) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: GOLD IV

            // To: Gold III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 9.9;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 21.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 35.7;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 50.1;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 65.7;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 81.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 104.5;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 130.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 160.4;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 189.4;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 210.9;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 246.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 291.7;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 349.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 419.3;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 518.9;}
        }

        if (cLeagueRank.equals(LeagueRank.GOLD) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: GOLD III

            // To: Gold II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 10.3;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 24.5;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 39.99;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 53.6;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 74.4;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 95.1;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 119.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 147.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 178.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 203.6;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 226.7;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 281.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 329.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 411.4;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 509.0;}
        }

        if (cLeagueRank.equals(LeagueRank.GOLD) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: GOLD II

            // To: Gold I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 12.5;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 28.2;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 40.1;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 60.1;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 81.4;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 109.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 138.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 167.8;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 192.9;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 225.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 271.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 327.8;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 401.7;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice =492.5;}
        }

        if (cLeagueRank.equals(LeagueRank.GOLD) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: GOLD I

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 14.5;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 29.99;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 49.99;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 70.1;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 98.5;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 124.6;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 147.8;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 184.6;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 210.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 259.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 310.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 389.2;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 479.1;}
        }
        return finalPrice;
    }
}