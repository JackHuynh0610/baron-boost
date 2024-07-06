package com.webapp.BaronBoost.orders.league_of_legends.models;

import com.webapp.BaronBoost.users.models.User;
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
 * Represents a Net Win Order in the League of Legends boosting service.
 * 
 * <p>This class extends the {@link LeagueOrder} and includes additional properties specific to Net Win Orders:</p>
 * <ul>
 *     <li>Current rank</li>
 *     <li>Number of game wins</li>
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
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "netwin_orders")
public class NetWinOrder extends LeagueOrder{

    /**
     * The type of the order.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderType orderType = OrderType.NETWIN;

    /**
     * The current rank of the user.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueRank currentRank;

    /**
     * The number of game wins required in the order.
     */
    @Column(nullable = false)
    private Integer numberOfGameWin;

    /**
     * The main lane of the order.
     */
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Lane mainLane;

    /**
     * The second lane of the order.
     */
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Lane secondLane;

    /**
     * Champions of the order.
     */
    @Column(length = 64)
    private String champion1;

    @Column(length = 64)
    private String champion2;

    @Column(length = 64)
    private String champion3;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private Spell flash;

    /**
     * Constructs a new NetWinOrder with the specified details.
     * 
     * @param user the user who placed the order
     * @param gameUsername the username for the League of Legends account
     * @param gamePassword the password for the League of Legends account
     * @param orderPrice the price of the order
     * @param currentLeagueRank the current rank of the user
     * @param numberOfGameWin the number of game wins required in the order
     * @param mainLane the main lane of the order
     * @param secondLane the second lane of the order
     * @param champion1 the first champion of the order
     * @param champion2 the second champion of the order
     * @param champion3 the third champion of the order
     * @param flash the flash spell of the order
     */
    public NetWinOrder(User user, String gameUsername, String gamePassword, Double orderPrice, LeagueRank currentLeagueRank, Integer numberOfGameWin,
            Lane mainLane, Lane secondLane, String champion1, String champion2, String champion3, Spell flash) {
        super(user, gameUsername, gamePassword, orderPrice);
        this.currentRank = currentLeagueRank;
        this.numberOfGameWin = numberOfGameWin;
        this.mainLane = mainLane;
        this.secondLane = secondLane;
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.champion3 = champion3;
        this.flash = flash;
    }
}
