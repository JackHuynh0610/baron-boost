package com.webapp.BaronBoost.users.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.BaronBoost.users.models.BoostStatus;
import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.services.UserService;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controller class for managing user-related endpoints.
 * 
 * <p>
 * This controller provides endpoints for CRUD operations on users such as
 * finding all users, finding users by ID or username, deleting users, updating users,
 * and updating user boost status.
 * </p>
 * 
 * @see UserService
 * @see User
 * @see ResponseEntity
 * @see HttpStatus
 * @see PreAuthorize
 * @see CrossOrigin
 * @see RestController
 * @see RequestMapping
 * @see GetMapping
 * @see PostMapping
 * @see PutMapping
 * @see PatchMapping
 * @see DeleteMapping
 * @see PathVariable
 * @see RequestBody
 * @see Optional
 * @see List
 * @see EntityNotFoundException
 */
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Get all users.
     * 
     * @return a response entity with a list of users or an error message
     */
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> findAllUsers() {
        try {
            List<User> users = userService.findAllUser();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Get a user by ID.
     * 
     * @param id the user ID
     * @return a response entity with the user or an error message
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> userOptional = userService.findUserById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }else{
            throw new EntityNotFoundException("Could not find user with id: " + id);
        }
    }

    /**
     * Get a user by username.
     * 
     * @param username the username
     * @return a response entity with the user or an error message
     */
    @GetMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username){
        Optional<User> userOptional = userService.findUserByUsername(username);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }else{
            throw new EntityNotFoundException("Could not find user with username: " + username);
        }
    }

    /**
     * Delete a user by ID.
     * 
     * @param id the user ID
     * @return a response entity with a success message or an error message
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        try {
            String deleteMessage = userService.deleteUserById(id);
            return ResponseEntity.ok(deleteMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Delete a user by username.
     * 
     * @param username the username
     * @return a response entity with a success message or an error message
     */
    @DeleteMapping("/username/{username}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username){
        try {
            String deleteMessage = userService.deleteUserByUsername(username);
            return ResponseEntity.ok(deleteMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Update a user by ID.
     * 
     * @param id the user ID
     * @param user the updated user object
     * @return a response entity with the updated user or an error message
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUserById(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Update a user by username.
     * 
     * @param username the username
     * @param user the updated user object
     * @return a response entity with the updated user or an error message
     */
    @PutMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER', 'BOOSTER')")
    public ResponseEntity<User> updateUserByUsername(@PathVariable String username, @RequestBody User user) {
        User updatedUser = userService.updateUserByUsername(username, user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Update the boost status of a user by ID.
     * 
     * @param id the user ID
     * @param status the new boost status
     * @return a response entity with the updated user or an error message
     */
    @PatchMapping("/{id}/boostStatus/{status}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<User> updateUserBoostStatusById(@PathVariable Long id, @PathVariable BoostStatus status) {
        try {
            User updatedUser = userService.updateUserBoostStatusById(id, status);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Update the boost status of a user by username.
     * 
     * @param username the username of the user
     * @param status the new boost status
     * @return a response entity with the updated user or an error message
     */
    @PatchMapping("/username/{username}/boostStatus/{status}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BOOSTER')")
    public ResponseEntity<User> updateUserBoostStatusByUsername(@PathVariable String username, @PathVariable BoostStatus status) {
        try {
            User updatedUser = userService.updateUserBoostStatusByUsername(username, status);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}