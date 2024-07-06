package com.webapp.BaronBoost.purge.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webapp.BaronBoost.orders.league_of_legends.models.CoachOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.DuoOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.NetWinOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;
import com.webapp.BaronBoost.orders.league_of_legends.services.LeagueOrderService;
import com.webapp.BaronBoost.users.models.BoostStatus;
import com.webapp.BaronBoost.users.models.Role;
import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.services.UserService;

@Service
public class PurgeServiceImp implements PurgeService{


    private final UserService userService;
    private final LeagueOrderService leagueOrderService;

    public PurgeServiceImp(UserService userService, LeagueOrderService leagueOrderService){
        this.userService = userService;
        this.leagueOrderService = leagueOrderService;
    }

    @Override
    public void wipeData() {

        //Get all customer
        List<User> customerUsers = userService.findAllUser().stream().filter(user -> user.getRole().equals(Role.CUSTOMER)).toList();

        //Get all Order
        List<SoloOrder> soloOrders = leagueOrderService.findAllSoloOrder();
        List<DuoOrder> duoOrders = leagueOrderService.findAllDuoOrder();
        List<NetWinOrder> netWinOrders = leagueOrderService.findAllNetWinOrder();
        List<CoachOrder> coachOrders = leagueOrderService.findAllCoachOrder();

        //Get all Booster
        List<User> boosterUsers = userService.findAllUser().stream().filter(user -> user.getRole().equals(Role.BOOSTER)).toList();

        //Delete soloOrder
        for(SoloOrder order: soloOrders){
            leagueOrderService.deleteSoloOrderById(order.getId());
        }

        //Delete duoOrder
        for(DuoOrder order: duoOrders){
            leagueOrderService.deleteDuoOrderById(order.getId());
        }

        //Delete coachOrder
        for(CoachOrder order: coachOrders){
            leagueOrderService.deleteCoachOrderById(order.getId());
        }

        //Delete netWinOrder
        for(NetWinOrder order: netWinOrders){
            leagueOrderService.deleteNetWinOrderById(order.getId());
        }
        
        //Delete all customer
        for(User customer : customerUsers){
            userService.deleteUserByUsername(customer.getUsername());
        }

        //Set all booster status back to NOT_BOOSTING
        for(User booster : boosterUsers){
            userService.updateUserBoostStatusByUsername(booster.getUsername(), BoostStatus.NOT_BOOSTING);
        }
    }
}
