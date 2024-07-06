package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class BronzeToMaster {

    private BronzeToMaster(){};

    public static double getBronzeToMasterPrice(LeagueRank cLeagueRank, 
                                      LeagueDivision leagueCurrentDivision, 
                                      LeagueRank dLeagueRank, 
                                      LeagueDivision leagueDesiredDivision){
        double finalPrice = 0.0;
        if (cLeagueRank.equals(LeagueRank.BRONZE) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: BRONZE IV

            // To: Bronze III, II, I
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 5.7;}
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 10.7;}
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 17.5;}

            // To: Silver IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 23.7;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 28.1;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 38.5;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 43.6;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 54.3;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 64.2;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 74.6;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 90.1;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 100.0;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 120.3;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 138.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 160.3;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 187.4;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 210.6;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 239.0;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 269.5;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 300.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 347.4;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 402.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 475.6;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 569.7;}
        }

        if (cLeagueRank.equals(LeagueRank.BRONZE) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: BRONZE III

            // To: Bronze II, I
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 6.0;}
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 11.4;}

            // To: Silver IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 17.9;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 24.6;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 29.8;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 37.8;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 48.6;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 59.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 69.99;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 84.4;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 98.7;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 113.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 132.6;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 152.8;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 181.2;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 201.5;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 217.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 259.1;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 287.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 336.8;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 396.99;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 471.9;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 567.3;}
        }

        if (cLeagueRank.equals(LeagueRank.BRONZE) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: BRONZE II

            // To: Bronze I
            if (dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 6.3;}

            // To: Silver IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 12.6;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 18.9;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 25.6;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 32.1;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 41.2;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 51.3;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 60.1;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 79.99;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 92.1;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 108.0;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 126.8;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 148.5;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 172.8;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 200.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 227.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 256.9;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 287.5;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 336.1;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 390.2;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 468.5;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 561.3;}
        }

        if (cLeagueRank.equals(LeagueRank.BRONZE) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: BRONZE I

            // To: Silver IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 6.5;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 11.4;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 19.5;}
            if (dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 26.7;}

            // To: Gold IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 36.4;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 48.8;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 59.99;}
            if (dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 71.7;}

            // To: Platinum IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 87.4;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 101.2;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 120.6;}
            if (dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 143.4;}

            // To: Emerald IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 170.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 189.9;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 220.1;}
            if (dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 245.7;}

            // To: Diamond IV, III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)) {finalPrice = 280.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 329.0;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 281.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 459.7;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 552.3;}
        }
        return finalPrice;
    }
}