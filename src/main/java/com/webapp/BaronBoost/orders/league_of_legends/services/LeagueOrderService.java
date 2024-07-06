package com.webapp.BaronBoost.orders.league_of_legends.services;

import java.util.List;
import java.util.Optional;

import com.webapp.BaronBoost.orders.league_of_legends.models.CoachOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.DuoOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.LeagueOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.NetWinOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.OrderStatus;
import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;

/**
 * Service interface for managing League of Legends orders. Provides methods for
 * CRUD operations and status updates on different types of orders.
 */
public interface LeagueOrderService {
    List<LeagueOrder> findAllLeagueOrder();

    List<SoloOrder> findAllSoloOrder();
    List<DuoOrder> findAllDuoOrder();
    List<CoachOrder> findAllCoachOrder();
    List<NetWinOrder> findAllNetWinOrder();
    
    List<LeagueOrder> findLeagueOrderByUsername(String username);
    List<LeagueOrder> findAllLeagueOrderByStatus(OrderStatus status);

    Optional<SoloOrder> findSoloOrderById(Long id);
    Optional<DuoOrder> findDuoOrderById(Long id);
    Optional<CoachOrder> findCoachOrderById(Long id);
    Optional<NetWinOrder> findNetWinOrderById(Long id);

    SoloOrder saveSoloOrder(SoloOrder soloOrder);
    DuoOrder saveDuoOrder(DuoOrder duoOrder);
    CoachOrder saveCoachOrder(CoachOrder coachOrder);
    NetWinOrder saveNetWinOrder(NetWinOrder netWinOrder);

    String deleteSoloOrderById(Long id);
    String deleteDuoOrderById(Long id);
    String deleteCoachOrderById(Long id);
    String deleteNetWinOrderById(Long id);

    SoloOrder updateSoloOrderStatusById(Long id, OrderStatus soloOrderStatus);
    DuoOrder updateDuoOrderStatusById(Long id, OrderStatus duoOrderStatus);
    CoachOrder updateCoachOrderStatusById(Long id, OrderStatus coachOrderStatus);
    NetWinOrder updateNetWinOrderStatusById(Long id, OrderStatus netWinOrderStatus);
} 