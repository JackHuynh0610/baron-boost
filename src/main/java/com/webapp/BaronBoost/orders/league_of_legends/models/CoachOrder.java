package com.webapp.BaronBoost.orders.league_of_legends.models;


import com.webapp.BaronBoost.users.models.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a coaching order in the League of Legends game.
 * Extends the LeagueOrder class to include specific attributes for coaching orders.
 * 
 * <p>The CoachOrder class provides the following functionalities:</p>
 * <ul>
 *     <li>Stores the number of games for a coaching order</li>
 *     <li>Inherits common order properties such as user details, game credentials, and order price from LeagueOrder</li>
 * </ul>
 * 
 * <p>Key attributes:</p>
 * <ul>
 *     <li>{@code numberOfGame} - The number of coaching games for the order</li>
 * </ul>
 * 
 * <p>Annotations used:</p>
 * <ul>
 *     <li>{@code @Entity} - Specifies that this class is an entity and is mapped to a database table</li>
 *     <li>{@code @NoArgsConstructor} - Generates a no-arguments constructor</li>
 *     <li>{@code @Getter} - Generates getter methods for all fields</li>
 *     <li>{@code @Setter} - Generates setter methods for all fields</li>
 *     <li>{@code @Table} - Specifies the table name in the database</li>
 *     <li>{@code @Column} - Specifies the column properties for the fields</li>
 * </ul>
 * 
 * @see LeagueOrder
 * @see User
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "coach_orders")
public class CoachOrder extends LeagueOrder{

    /**
     * The type of the order.
    */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderType orderType = OrderType.COACH;

    /**
     * The number of game to Coach.
     */
    @Column(nullable = false)
    private Integer numberOfGame;

    public CoachOrder(User user, String gameUsername, String gamePassword, Double orderPrice, Integer numberOfGame){
        super(user, gameUsername, gamePassword, orderPrice);
        this.numberOfGame = numberOfGame;
    }
}
