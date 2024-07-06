package com.webapp.BaronBoost.utils.league_prices.rank_prices;

import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;

public class IronToMaster {

    private IronToMaster(){};

    public static double getIronToMasterPrice(LeagueRank cLeagueRank, 
                                      LeagueDivision leagueCurrentDivision, 
                                      LeagueRank dLeagueRank, 
                                      LeagueDivision leagueDesiredDivision){
        double finalPrice = 0.0;
        if(cLeagueRank.equals(LeagueRank.IRON) && leagueCurrentDivision.equals(LeagueDivision.IV)){ //FROM: IRON IV 

            //To: Iron III, II, I
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 5.0;}
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 10.5;}
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 15.5;} 

            //To: Bronze IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 21.8;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 27.4;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 32.1;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 39.99;}

            //To: Silver IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 46.8;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 52.0;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 60.5;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 65.8;}

            //To: Gold IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 76.0;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 87.99;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 99.99;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 110.9;}

            //To: Platinum IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 125.7;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 143.0;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 161.5;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 180.7;}

            //To: Emerald IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 204.7;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 232.3;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 260.1;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 290.5;}

            //To: Diamond IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 320.6;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 368.8;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 420.5;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 499.9;}

            //To: Master
            if(dLeagueRank.equals(LeagueRank.MASTER)){finalPrice = 590.8;}

        }if(cLeagueRank.equals(LeagueRank.IRON) && leagueCurrentDivision.equals(LeagueDivision.III)){  //FROM: IRON III

            //To: Iron II, I
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 5.1;}
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 10.5;}

            //To: Bronze IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 14.8;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 20.6;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 27.9;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 33.8;}

            //To: Silver IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 39.99;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 46.7;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 50.8;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 60.3;}

            //To: Gold IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 69.99;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 80.4;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 93.2;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 103.88;}

            //To: Platinum IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 119.99;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 135.7;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 150.8;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 174.99;}

            //To: Emerald IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 203.6;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 215.8;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 250.0;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 280.99;}

            //To: Diamond IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 319.6;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 360.3;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 419.6;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 494.4;}

            //To: Master
            if(dLeagueRank.equals(LeagueRank.MASTER)){finalPrice = 588.6;}
            
        }if(cLeagueRank.equals(LeagueRank.IRON) && leagueCurrentDivision.equals(LeagueDivision.II)){ //FROM: IRON II

            //To: Iron I
            if(dLeagueRank.equals(LeagueRank.IRON) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 5.1;}

            //To: Bronze IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 8.4;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 15.0;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 22.6;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 27.6;}

            //To: Silver IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 34.8;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 40.5;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 48.6;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 55.7;}

            //To: Gold IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 64.3;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 74.5;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 87.6;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 99.99;}

            //To: Platinum IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 115.4;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 130.5;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 149.9;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 171.3;}

            //To: Emerald IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 199.2;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 215.4;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 248.9;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 279.99;}

            //To: Diamond IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 313.5;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 359.0;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 415.6;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 489.2;}

            //To: Master
            if(dLeagueRank.equals(LeagueRank.MASTER)){finalPrice = 580.1;}
        }
        
        if(cLeagueRank.equals(LeagueRank.IRON) && leagueCurrentDivision.equals(LeagueDivision.I)){ //FROM: IRON I

            //To: Bronze IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 5.8;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 10.3;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 16.9;}
            if(dLeagueRank.equals(LeagueRank.BRONZE) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 23.5;}

            //To: Silver IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 30.5;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 37.8;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 45.6;}
            if(dLeagueRank.equals(LeagueRank.SILVER) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 50.7;}

            //To: Gold IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 59.1;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 70.5;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 80.4;}
            if(dLeagueRank.equals(LeagueRank.GOLD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 90.3;}

            //To: Platinum IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 110.4;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 124.6;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 143.7;}
            if(dLeagueRank.equals(LeagueRank.PLATINUM) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 163.2;}

            //To: Emerald IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 190.7;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 210.8;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 241.0;}
            if(dLeagueRank.equals(LeagueRank.EMERALD) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 273.7;}

            //To: Diamond IV, III, II, I
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.IV)){finalPrice = 306.7;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.III)){finalPrice = 347.0;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.II)){finalPrice = 400.0;}
            if(dLeagueRank.equals(LeagueRank.DIAMOND) && leagueDesiredDivision.equals(LeagueDivision.I)){finalPrice = 476.99;}

            //To: Master
            if(dLeagueRank.equals(LeagueRank.MASTER)){finalPrice = 579.0;}
        }       
        return finalPrice;
    }
}