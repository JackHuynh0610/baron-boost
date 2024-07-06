package com.webapp.BaronBoost.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.BaronBoost.users.models.User;
import java.util.Optional;

/**
 * Repository interface for managing user entities in the database.
 * 
 * <p>
 * This interface extends the {@link JpaRepository} interface provided by 
 * Spring Data JPA and defines additional methods for performing CRUD operations
 * and custom queries on the {@link User} entity.
 * </p>
 * 
 * <p>
 * It provides methods for finding users by username, deleting users by username,
 * counting admin users, finding users by verification code, finding users by 
 * reset password token, and checking if a username exists in the database.
 * </p>
 * 
 * @see JpaRepository
 * @see User
 * @see Optional
 * @see Query
 * @see Repository
 * @see JpaRepository
 * @see Optional
 * @see Query
 * @see Repository
 * @see User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * Find a user by username.
     * 
     * @param username the username of the user
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<User> findByUsername(String username);

    /**
     * Delete a user by username.
     * 
     * @param username the username of the user to delete
     * @return a message indicating the deletion status
     */
    String deleteByUsername(String username);

    /**
     * Count the number of admin users in the database.
     * 
     * @return the count of admin users
     */
    @Query("SELECT COUNT(u) FROM User u WHERE u.role = 'ADMIN'")
    long countAdminUsers();

    /**
     * Find a user by verification code.
     * 
     * @param code the verification code of the user
     * @return the user if found, null otherwise
     */
    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    User findByVerificationCode(String code);

    /**
     * Find a user by reset password token.
     * 
     * @param token the reset password token of the user
     * @return the user if found, null otherwise
     */
    User findByResetPasswordToken(String token);

    /**
     * Check if a username exists in the database.
     * 
     * @param username the username to check
     * @return true if the username exists, false otherwise
     */
    boolean existsByUsername(String username);
}