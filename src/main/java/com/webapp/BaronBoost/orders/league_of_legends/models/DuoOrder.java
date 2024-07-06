package com.webapp.BaronBoost.orders.league_of_legends.models;

import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.utils.league_prices.LeagueDivision;
import com.webapp.BaronBoost.utils.league_prices.LeagueRank;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Duo Order in the League of Legends boosting service.
 * 
 * <p>This class extends the {@link LeagueOrder} and includes additional properties specific to Duo Orders:</p>
 * <ul>
 *     <li>Current rank and division</li>
 *     <li>Current LP (League Points)</li>
 *     <li>Desired rank and division</li>
 *     <li>LP per game</li>
 * </ul>
 * 
 * <p>Annotations used:</p>
 * <ul>
 *     <li>{@code @Entity} - Specifies that this class is an entity and is mapped to a database table</li>
 *     <li>{@code @NoArgsConstructor} - Generates a no-argument constructor</li>
 *     <li>{@code @Getter} - Generates getter methods for all fields</li>
 *     <li>{@code @Setter} - Generates setter methods for all fields</li>
 *     <li>{@code @Table} - Specifies the table name for the entity</li>
 *     <li>{@code @Enumerated} - Specifies that an enum is mapped to a database column</li>
 *     <li>{@code @Column} - Specifies column properties for the fields</li>
 * </ul>
 * 
 * @see LeagueOrder
 * @see User
 * @see LeagueRank
 * @see LeagueDivision
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "duo_orders")
public class DuoOrder extends LeagueOrder{

    /**
     * The type of the order.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderType orderType = OrderType.DUO;

    /**
     * The current rank of the user.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueRank currentRank;

    /**
     * The current division of the user.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueDivision currentDivision;

    /**
     * The current League Points (LP) of the user.
     */
    @Column(nullable = false)
    private Integer currentLp;

    /**
     * The desired rank the user wants to achieve.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueRank desiredRank;

    /**
     * The desired division the user wants to achieve.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueDivision desiredDivision;

    /**
     * The LP per game the user wants to achieve.
     */
    @Column(nullable = false)
    private Integer lpPerGame;
    

     /**
     * Constructs a new DuoOrder with the specified details.
     * 
     * @param user the user who placed the order
     * @param gameUsername the username for the League of Legends account
     * @param gamePassword the password for the League of Legends account
     * @param orderPrice the price of the order
     * @param currentRank the current rank of the user
     * @param currentDivision the current division of the user
     * @param currentLp the current LP of the user
     * @param desiredRank the desired rank the user wants to achieve
     * @param desiredDivision the desired division the user wants to achieve
     * @param lpPerGame the LP per game the user wants to achieve
     * @param mainLane the main lane of the order
     * @param secondLane the second lane of the order
     * @param champion1 the first champion of the order
     * @param champion2 the second champion of the order
     * @param champion3 the third champion of the order
     * @param flash the flash spell of the order
     */
    public DuoOrder(User user, String gameUsername, String gamePassword,
                    Double orderPrice, 
                    LeagueRank currentRank, LeagueDivision currentDivision, Integer currentLp,
                    LeagueRank desiredRank, LeagueDivision desiredDivision, Integer lpPerGame) {

        super(user, gameUsername, gamePassword, orderPrice);
        this.currentRank = currentRank;
        this.currentDivision = currentDivision;
        this.currentLp = currentLp;
        this.desiredRank = desiredRank;
        this.desiredDivision = desiredDivision;
        this.lpPerGame = lpPerGame;
    }
}
