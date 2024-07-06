package com.webapp.BaronBoost.orders.league_of_legends.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.BaronBoost.orders.league_of_legends.models.CoachOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.DuoOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.LeagueOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.NetWinOrder;
import com.webapp.BaronBoost.orders.league_of_legends.models.OrderStatus;
import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;
import com.webapp.BaronBoost.orders.league_of_legends.services.LeagueOrderService;
import com.webapp.BaronBoost.users.models.BoostStatus;
import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.services.UserService;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controller class responsible for handling HTTP requests related to League of Legends orders.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class LeagueOrderController {
    private final LeagueOrderService leagueOrderService;
    private final UserService userService;
    

    public LeagueOrderController(LeagueOrderService leagueOrderService, UserService userService){
        this.leagueOrderService = leagueOrderService;
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<LeagueOrder>> findAllLeagueOrders(){
        try {
            List<LeagueOrder> leagueOrders = leagueOrderService.findAllLeagueOrder();
            return ResponseEntity.ok(leagueOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/soloOrders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<SoloOrder>> findAllSoloOrders(){
        try {
            List<SoloOrder> soloOrders = leagueOrderService.findAllSoloOrder();
            return ResponseEntity.ok(soloOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/duoOrders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<DuoOrder>> findAllDuoOrders(){
        try {
            List<DuoOrder> duoOrders = leagueOrderService.findAllDuoOrder();
            return ResponseEntity.ok(duoOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/coachOrders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<CoachOrder>> findAllCoachOrders(){
        try {
            List<CoachOrder> coachOrders = leagueOrderService.findAllCoachOrder();
            return ResponseEntity.ok(coachOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/netWinOrders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<NetWinOrder>> findAllNetWinOrders(){
        try {
            List<NetWinOrder> netWinOrders = leagueOrderService.findAllNetWinOrder();
            return ResponseEntity.ok(netWinOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<List<LeagueOrder>> findAllLeagueOrderByUsername(@PathVariable String username){
        try {
            List<LeagueOrder> leagueOrderFromUser = leagueOrderService.findLeagueOrderByUsername(username);
            return ResponseEntity.ok(leagueOrderFromUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<List<LeagueOrder>> findAllLeagueOrderByStatus(@PathVariable OrderStatus status){
        try {
            List<LeagueOrder> leagueOrderFromStatus = leagueOrderService.findAllLeagueOrderByStatus(status);
            return ResponseEntity.ok(leagueOrderFromStatus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/soloOrder/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','BOOSTER')")
    public ResponseEntity<SoloOrder> findSoloOrderById(@PathVariable Long id){
        Optional<SoloOrder> soloOrderOptional = leagueOrderService.findSoloOrderById(id);
        if(soloOrderOptional.isPresent()){
            SoloOrder soloOrder = soloOrderOptional.get();
            return ResponseEntity.ok(soloOrder);
        }else{
            throw new EntityNotFoundException("Could not find Solo Order with id: " + id);
        }
    }

    @GetMapping("/duoOrder/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','BOOSTER')")
    public ResponseEntity<DuoOrder> findDuoOrderById(@PathVariable Long id){
        Optional<DuoOrder> duoOrderOptional = leagueOrderService.findDuoOrderById(id);
        if(duoOrderOptional.isPresent()){
            DuoOrder duoOrder = duoOrderOptional.get();
            return ResponseEntity.ok(duoOrder);
        }else{
            throw new EntityNotFoundException("Could not find Duo Order with id: " + id);
        }
    }

    @GetMapping("/coachOrder/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','BOOSTER')")
    public ResponseEntity<CoachOrder> findCoachOrderById(@PathVariable Long id){
        Optional<CoachOrder> coachOrderOptional = leagueOrderService.findCoachOrderById(id);
        if(coachOrderOptional.isPresent()){
            CoachOrder coachOrder = coachOrderOptional.get();
            return ResponseEntity.ok(coachOrder);
        }else{
            throw new EntityNotFoundException("Could not find Coach Order with id: " + id);
        }
    }

    @GetMapping("/netWinOrder/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','BOOSTER')")
    public ResponseEntity<NetWinOrder> findNetWinOrderById(@PathVariable Long id){
        Optional<NetWinOrder> netWinOrderOptional = leagueOrderService.findNetWinOrderById(id);
        if(netWinOrderOptional.isPresent()){
            NetWinOrder netWinOrder = netWinOrderOptional.get();
            return ResponseEntity.ok(netWinOrder);
        }else{
            throw new EntityNotFoundException("Could not find NetWin Order with id: " + id);
        }
    }

    @PostMapping("/soloOrder")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<SoloOrder> saveSoloOrder(@RequestBody SoloOrder soloOrder){
        try{
            return ResponseEntity.ok(leagueOrderService.saveSoloOrder(soloOrder));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/duoOrder")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<DuoOrder> saveDuoOrder(@RequestBody DuoOrder duoOrder){
        try{
            return ResponseEntity.ok(leagueOrderService.saveDuoOrder(duoOrder));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/coachOrder")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<CoachOrder> saveCoachOrder(@RequestBody CoachOrder coachOrder){
        try{
            return ResponseEntity.ok(leagueOrderService.saveCoachOrder(coachOrder));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/netWinOrder")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<NetWinOrder> saveNetWinOrder(@RequestBody NetWinOrder netWinOrder){
        try{
            return ResponseEntity.ok(leagueOrderService.saveNetWinOrder(netWinOrder));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/soloOrder/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteSoloOrderById(@PathVariable Long id) {
        try {
            String result = leagueOrderService.deleteSoloOrderById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/duoOrder/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteDuoOrderById(@PathVariable Long id) {
        try {
            String result = leagueOrderService.deleteDuoOrderById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/coachOrder/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteCoachOrderById(@PathVariable Long id) {
        try {
            String result = leagueOrderService.deleteCoachOrderById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/netWinOrder/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteNetWinOrderById(@PathVariable Long id) {
        try {
            String result = leagueOrderService.deleteNetWinOrderById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/soloOrder/{id}/status/{soloOrderStatus}/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<SoloOrder> updateSoloOrderStatus(@PathVariable Long id, @PathVariable OrderStatus soloOrderStatus, @PathVariable String username) {
        try {
            /*
             * Check if the current user is BOOSTING.
             * If it's then don't allow update because each booster can only boost 1 account. Admin can change this.
            */
            Optional<User> currentUser = userService.findUserByUsername(username);
            if (!currentUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            User user = currentUser.get();
            if (user.getBoostStatus().equals(BoostStatus.BOOSTING)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            SoloOrder updatedSoloOrder = leagueOrderService.updateSoloOrderStatusById(id, soloOrderStatus);
            return ResponseEntity.ok(updatedSoloOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/duoOrder/{id}/status/{duoOrderStatus}/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<DuoOrder> updateDuoOrderStatus(@PathVariable Long id, @PathVariable OrderStatus duoOrderStatus, @PathVariable String username) {
        try {
            /*
             * Check if the current user is BOOSTING.
             * If it's then don't allow update because each booster can only boost 1 account. Admin can change this. 
             * The username is the person who currently request this endpoint.
            */
            Optional<User> currentUser = userService.findUserByUsername(username);
            if (!currentUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            User user = currentUser.get();
            if (user.getBoostStatus().equals(BoostStatus.BOOSTING)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            DuoOrder updatedDuoOrder = leagueOrderService.updateDuoOrderStatusById(id, duoOrderStatus);
            return ResponseEntity.ok(updatedDuoOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/coachOrder/{id}/status/{coachOrderStatus}/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<CoachOrder> updateCoachOrderStatus(@PathVariable Long id, @PathVariable OrderStatus coachOrderStatus, @PathVariable String username) {
        try {
            /*
             * Check if the current user is BOOSTING.
             * If it's then don't allow update because each booster can only boost 1 account. Admin can change this. 
             * The username is the person who currently request this endpoint.
            */
            Optional<User> currentUser = userService.findUserByUsername(username);
            if (!currentUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            User user = currentUser.get();
            if (user.getBoostStatus().equals(BoostStatus.BOOSTING)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            CoachOrder updatedCoachOrder = leagueOrderService.updateCoachOrderStatusById(id, coachOrderStatus);
            return ResponseEntity.ok(updatedCoachOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/netWinOrder/{id}/status/{netWinOrderStatus}/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<NetWinOrder> updateNetWinOrderStatus(@PathVariable Long id, @PathVariable OrderStatus netWinOrderStatus, @PathVariable String username) {
        try {
            /*
             * Check if the current user is BOOSTING.
             * If it's then don't allow update because each booster can only boost 1 account. Admin can change this. 
             * The username is the person who currently request this endpoint.
            */
            Optional<User> currentUser = userService.findUserByUsername(username);
            if (!currentUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            User user = currentUser.get();
            if (user.getBoostStatus().equals(BoostStatus.BOOSTING)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            NetWinOrder updatedNetWinOrder = leagueOrderService.updateNetWinOrderStatusById(id, netWinOrderStatus);
            return ResponseEntity.ok(updatedNetWinOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}