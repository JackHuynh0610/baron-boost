package com.webapp.BaronBoost.orders.league_of_legends.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.webapp.BaronBoost.orders.league_of_legends.models.CoachOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.DuoOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.LeagueOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.NetWinOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.OrderStatus;
import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;
import com.webapp.BaronBoost.orders.league_of_legends.repositories.CoachOrderRepository;
import com.webapp.BaronBoost.orders.league_of_legends.repositories.DuoOrderRepository;
import com.webapp.BaronBoost.orders.league_of_legends.repositories.NetWinOrderRepository;
import com.webapp.BaronBoost.orders.league_of_legends.repositories.SoloOrderRepository;
import com.webapp.BaronBoost.utils.league_prices.CoachPrice;
import com.webapp.BaronBoost.utils.league_prices.DuoPrice;
import com.webapp.BaronBoost.utils.league_prices.NetWinPrice;
import com.webapp.BaronBoost.utils.league_prices.SoloPrice;

import jakarta.persistence.EntityNotFoundException;

/**
 * Service implementation for managing League of Legends orders.
 * This class provides methods for CRUD operations and status updates on different types of orders.
 */
@Service
public class LeagueOrderServiceImpl implements LeagueOrderService{
    private final SoloOrderRepository soloOrderRepository;
    private final DuoOrderRepository duoOrderRepository;
    private final CoachOrderRepository coachOrderRepository;
    private final NetWinOrderRepository netWinOrderRepository;

    public LeagueOrderServiceImpl(SoloOrderRepository soloOrderRepository, DuoOrderRepository duoOrderRepository, CoachOrderRepository coachOrderRepository, NetWinOrderRepository netWinOrderRepository) {
        this.soloOrderRepository = soloOrderRepository;
        this.duoOrderRepository = duoOrderRepository;
        this.coachOrderRepository = coachOrderRepository;
        this.netWinOrderRepository = netWinOrderRepository;
    }

    @Override
    public List<LeagueOrder> findAllLeagueOrder() {
        List<LeagueOrder> leagueOrder = new ArrayList<>();
        leagueOrder.addAll(soloOrderRepository.findAll());
        leagueOrder.addAll(duoOrderRepository.findAll());
        leagueOrder.addAll(coachOrderRepository.findAll());
        leagueOrder.addAll(netWinOrderRepository.findAll());
        return leagueOrder;
    }

    @Override
    public List<SoloOrder> findAllSoloOrder() {
       return soloOrderRepository.findAll();
    }

    @Override
    public List<DuoOrder> findAllDuoOrder() {
        return duoOrderRepository.findAll();
    }

    @Override
    public List<CoachOrder> findAllCoachOrder() {
        return coachOrderRepository.findAll();
    }

    @Override
    public List<NetWinOrder> findAllNetWinOrder() {
        return netWinOrderRepository.findAll();
    }

    @Override
    public List<LeagueOrder> findLeagueOrderByUsername(String username) {
        List<LeagueOrder> allOrders = findAllLeagueOrder();
        List<LeagueOrder> filterOrders = new ArrayList<>();
        for(LeagueOrder order: allOrders){
            if(order.getUser().getUsername().equals(username)){
                filterOrders.add(order);
            }
        }
        return filterOrders;
    }

    @Override
    public List<LeagueOrder> findAllLeagueOrderByStatus(OrderStatus status) {
        List<LeagueOrder> allOrders = findAllLeagueOrder();
        List<LeagueOrder> filterOrders = new ArrayList<>();
        for(LeagueOrder order: allOrders){
            if(order.getStatus().name().equals(status.name())){
                filterOrders.add(order);
            }
        }
        return filterOrders;
    }

    @Override
    public Optional<SoloOrder> findSoloOrderById(Long id) {
        return soloOrderRepository.findById(id);
    }

    @Override
    public Optional<DuoOrder> findDuoOrderById(Long id) {
        return duoOrderRepository.findById(id);
    }

    @Override
    public Optional<CoachOrder> findCoachOrderById(Long id) {
        return coachOrderRepository.findById(id);
    }

    @Override
    public Optional<NetWinOrder> findNetWinOrderById(Long id) {
        return netWinOrderRepository.findById(id);
    }

    @Override
    public SoloOrder saveSoloOrder(SoloOrder soloOrder) {
        soloOrder.setOrderPrice(SoloPrice.getSoloPrice(soloOrder.getCurrentRank(), soloOrder.getCurrentDivision(), 
                                                        soloOrder.getCurrentLp(), 
                                                        soloOrder.getDesiredRank(), soloOrder.getDesiredDivision(),
                                                        soloOrder.getLpPerGame()));
        return soloOrderRepository.save(soloOrder);
    }

    @Override
    public DuoOrder saveDuoOrder(DuoOrder duoOrder) {
        duoOrder.setOrderPrice(DuoPrice.getDuoPrice(duoOrder.getCurrentRank(), duoOrder.getCurrentDivision(), 
                                                    duoOrder.getCurrentLp(), 
                                                    duoOrder.getDesiredRank(), duoOrder.getDesiredDivision(),
                                                    duoOrder.getLpPerGame()));       
        return duoOrderRepository.save(duoOrder);
    }

    @Override
    public CoachOrder saveCoachOrder(CoachOrder coachOrder) {
        coachOrder.setOrderPrice(CoachPrice.getCoachPrice(coachOrder.getNumberOfGame()));
        return coachOrderRepository.save(coachOrder);
    }

    @Override
    public NetWinOrder saveNetWinOrder(NetWinOrder netWinOrder) {
        netWinOrder.setOrderPrice(NetWinPrice.getNetWinPrice(netWinOrder.getCurrentRank(), netWinOrder.getNumberOfGameWin()));
        return netWinOrderRepository.save(netWinOrder);
    }

    @Override
    public String deleteSoloOrderById(Long id) {
        soloOrderRepository.deleteById(id);
        String message = "Solo Order with " + id + " deleted successfully";
        return message;
    }

    @Override
    public String deleteDuoOrderById(Long id) {
        duoOrderRepository.deleteById(id);
        String message = "Duo Order with " + id + " deleted successfully";
        return message;
    }

    @Override
    public String deleteCoachOrderById(Long id) {
        coachOrderRepository.deleteById(id);
        String message = "Coach Order with " + id + " deleted successfully";
        return message;
    }

    @Override
    public String deleteNetWinOrderById(Long id){
        netWinOrderRepository.deleteById(id);
        String message = "NetWin Order with " + id + " deleted successfully";
        return message;
    }

    public SoloOrder updateSoloOrderStatusById(Long id, OrderStatus soloOrderStatus) {
        Optional<SoloOrder> soloOrderOptional = soloOrderRepository.findById(id);
        if(soloOrderOptional.isPresent()){
            SoloOrder soloOrder = soloOrderOptional.get();
            soloOrder.setStatus(soloOrderStatus);
            return soloOrderRepository.save(soloOrder);
        }else{
            throw new EntityNotFoundException("Solo Order with ID " + id + " not found");
        }
    }

    public DuoOrder updateDuoOrderStatusById(Long id, OrderStatus duoOrderStatus) {
    Optional<DuoOrder> duoOrderOptional = duoOrderRepository.findById(id);
        if (duoOrderOptional.isPresent()) {
            DuoOrder duoOrder = duoOrderOptional.get();
            duoOrder.setStatus(duoOrderStatus);
            return duoOrderRepository.save(duoOrder); 
        } else {
            throw new EntityNotFoundException("Duo Order with ID " + id + " not found");
        }
    }

    public CoachOrder updateCoachOrderStatusById(Long id, OrderStatus coachOrderStatus) {
        Optional<CoachOrder> coachOrderOptional = coachOrderRepository.findById(id);
        if (coachOrderOptional.isPresent()) {
            CoachOrder coachOrder = coachOrderOptional.get();
            coachOrder.setStatus(coachOrderStatus);
            return coachOrderRepository.save(coachOrder); 
        } else {
            throw new EntityNotFoundException("Coach Order with ID " + id + " not found");
        }
    }

    public NetWinOrder updateNetWinOrderStatusById(Long id, OrderStatus netWinOrderStatus) {
        Optional<NetWinOrder> netWinOrderOptional = netWinOrderRepository.findById(id);
        if (netWinOrderOptional.isPresent()) {
            NetWinOrder netWinOrder = netWinOrderOptional.get();
            netWinOrder.setStatus(netWinOrderStatus);
            return netWinOrderRepository.save(netWinOrder);
        } else {
            throw new EntityNotFoundException("NetWin Order with ID " + id + " not found");
        }
    }
    
}
