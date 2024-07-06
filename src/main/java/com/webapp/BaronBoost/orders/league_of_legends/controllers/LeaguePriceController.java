package com.webapp.BaronBoost.orders.league_of_legends.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.BaronBoost.orders.league_of_legends.models.CoachOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.DuoOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.NetWinOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;
import com.webapp.BaronBoost.utils.league_prices.CoachPrice;
import com.webapp.BaronBoost.utils.league_prices.DuoPrice;
import com.webapp.BaronBoost.utils.league_prices.NetWinPrice;
import com.webapp.BaronBoost.utils.league_prices.SoloPrice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller class responsible for handling HTTP requests related to League of Legends order prices.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/leaguePrices")
public class LeaguePriceController {
    
    /**
     * Calculates the price for a SoloOrder.
     *
     * @param soloOrder The details of the SoloOrder.
     * @return The price of the SoloOrder.
     */
    @PostMapping("/soloOrder")
    public double getSoloPrice(@RequestBody SoloOrder soloOrder) {
        return SoloPrice.getSoloPrice(soloOrder.getCurrentRank(), soloOrder.getCurrentDivision(), soloOrder.getCurrentLp(), 
                                    soloOrder.getDesiredRank(), soloOrder.getDesiredDivision(), soloOrder.getLpPerGame());
    }

    /**
     * Calculates the price for a DuoOrder.
     *
     * @param duoOrder The details of the DuoOrder.
     * @return The price of the DuoOrder.
     */
    @PostMapping("/duoOrder")
    public double getDuoPrice(@RequestBody DuoOrder duoOrder) {
        return DuoPrice.getDuoPrice(duoOrder.getCurrentRank(), duoOrder.getCurrentDivision(), duoOrder.getCurrentLp(), 
                                    duoOrder.getDesiredRank(), duoOrder.getDesiredDivision(), duoOrder.getLpPerGame());
    }

    /**
     * Calculates the price for a NetWinOrder.
     *
     * @param netWinOrder The details of the NetWinOrder.
     * @return The price of the NetWinOrder.
     */
    @PostMapping("/netWinOrder")
    public double getNetWinPrice(@RequestBody NetWinOrder netWinOrder) {
        return NetWinPrice.getNetWinPrice(netWinOrder.getCurrentRank(), netWinOrder.getNumberOfGameWin());
    }

     /**
     * Calculates the price for a CoachOrder.
     *
     * @param coachOrder The details of the CoachOrder.
     * @return The price of the CoachOrder.
     */
    @PostMapping("/coachOrder")
    public double getCoachPrice(@RequestBody CoachOrder coachOrder) {
        return CoachPrice.getCoachPrice(coachOrder.getNumberOfGame());
    }
}
