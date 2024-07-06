package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class SilverToMaster {

    private SilverToMaster(){}

    public static double getSilverToMasterPrice(LeagueRank cLeagueRank,
                                                LeagueDivision leagueCurrentDivision,
                                                LeagueRank dLeagueRank,
                                                LeagueDivision leagueDesiredDivision) {
        double finalPrice = 0.0;
        if (cLeagueRank.equals(LeagueRank.SILVER) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: SILVER IV

            // To: Silver III, II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 6.8;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 12.8;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 19.99;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 30.5;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 40.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 52.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 63.3;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 80.1;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 93.99;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 109.4;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 133.5;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 160.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 189.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 211.5;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 241.0;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 275.8;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 320.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 379.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 447.1;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 548.1;}
        }

        if (cLeagueRank.equals(LeagueRank.SILVER) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: SILVER III

            // To: Silver II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 7.0;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 12.8;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 23.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 33.8;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 46.6;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 57.99;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 73.4;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 89.5;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 104.9;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 130.4;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 152.7;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 183.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 206.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 232.7;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 271.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 317.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 370.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 448.0;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 541.5;}
        }

        if (cLeagueRank.equals(LeagueRank.SILVER) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: SILVER II

            // To: Silver I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 7.3;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 17.3;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 27.6;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 39.9;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 51.6;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 67.4;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 83.5;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 99.99;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 123.4;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 145.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 175.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 207.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 226.0;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 260.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 309.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 361.8;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 440.8;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 529.0;}
        }

        if (cLeagueRank.equals(LeagueRank.SILVER) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: SILVER I

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 9.6;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 18.5;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 30.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 44.2;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 59.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 72.5;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 96.7;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 109.9;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 142.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 169.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 199.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 220.0;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 257.9;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 302.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 360.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 427.8;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 529.9;}
        }
        return finalPrice;
    }
}