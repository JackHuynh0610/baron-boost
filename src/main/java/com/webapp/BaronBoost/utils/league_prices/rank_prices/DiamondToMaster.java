package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class DiamondToMaster {

    private DiamondToMaster(){}

    public static double getDiamondToMasterPrice(LeagueRank cLeagueRank,
                                              LeagueDivision leagueCurrentDivision,
                                              LeagueRank dLeagueRank,
                                              LeagueDivision leagueDesiredDivision) {
        double finalPrice = 0.0;

        if (cLeagueRank.equals(LeagueRank.DIAMOND) && leagueCurrentDivision.equals(LeagueDivision.IV)) { // FROM: Diamond IV

            // To: Diamond III, II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)) {finalPrice = 46.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 100.3;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 176.5;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 268.1;}
        }

        if (cLeagueRank.equals(LeagueRank.DIAMOND) && leagueCurrentDivision.equals(LeagueDivision.III)) { // FROM: Diamond III

            // To: Diamond II, I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)) {finalPrice = 53.6;}
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 128.9;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 221.4;}
        }

        if (cLeagueRank.equals(LeagueRank.DIAMOND) && leagueCurrentDivision.equals(LeagueDivision.II)) { // FROM: Diamond II

            // To: Diamond I
            if (dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)) {finalPrice = 74.7;}

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 169.5;}
        }

        if (cLeagueRank.equals(LeagueRank.DIAMOND) && leagueCurrentDivision.equals(LeagueDivision.I)) { // FROM: Diamond I

            // To: Master
            if (dLeagueRank.equals(LeagueRank.MASTER)) {finalPrice = 94.7;}
        }
        
        return finalPrice;
    }
}
