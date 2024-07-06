package com.webapp.BaronBoost.orders.league_of_legends.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.BaronBoost.orders.league_of_legends.models.SoloOrder;

/**
 * Repository interface for managing soloOrder entities in the database.
 * 
 * <p>
 * This interface extends the {@link JpaRepository} interface provided by 
 * Spring Data JPA and defines additional methods for performing CRUD operations
 * and custom queries on the {@link User} entity.
 * </p>
 * 
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
 */
@Repository
public interface SoloOrderRepository extends JpaRepository<SoloOrder, Long>{
    List<SoloOrder> findAllByUser_Username(String username);
}
