package com.webapp.BaronBoost.orders.league_of_legends.models;



import com.webapp.BaronBoost.users.models.User;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class representing a League of Legends order.
 * This class serves as a base for specific types of orders such as coaching orders.
 * 
 * <p>The LeagueOrder class includes common properties and mappings used in various types of League of Legends orders:</p>
 * <ul>
 *     <li>Order ID</li>
 *     <li>User details</li>
 *     <li>Game credentials (username and password)</li>
 *     <li>Region</li>
 *     <li>Order status</li>
 *     <li>Order price</li>
 * </ul>
 * 
 * <p>Annotations used:</p>
 * <ul>
 *     <li>{@code @MappedSuperclass} - Specifies that this class is a mapped superclass in JPA inheritance</li>
 *     <li>{@code @Id} - Marks the field as a primary key</li>
 *     <li>{@code @GeneratedValue} - Specifies the generation strategy for the primary key</li>
 *     <li>{@code @ManyToOne} - Defines a many-to-one relationship with the User entity</li>
 *     <li>{@code @JoinColumn} - Specifies the foreign key column for the user</li>
 *     <li>{@code @Column} - Specifies column properties for the fields</li>
 *     <li>{@code @Enumerated} - Specifies that an enum is mapped to a database column</li>
 *     <li>{@code @Getter} - Generates getter methods for all fields</li>
 *     <li>{@code @Setter} - Generates setter methods for all fields</li>
 * </ul>
 * 
 * @see User
 * @see Region
 * @see OrderStatus
 */
@MappedSuperclass
@Getter
@Setter
public abstract class LeagueOrder {

    /**
     * The identifier for every league order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The User will link as ID.
     */
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user;

    /**
     * The ingame username of the USER for login.
     */
    @Column(nullable = false, length = 64)
    private String leagueUsername;

    /**
     * The ingame password of the USER for login.
     */
    @Column(nullable = false, length = 64)
    private String leaguePassword;

    /**
     * The region of the account.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Region region;

    /**
     * The order status indidcate if it NOT_TAKEN, TAKEN OR COMPLETE.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    /**
     * The total prices of the order included discounts.
     */
    @Column(nullable = false)
    private Double orderPrice;
    
    public LeagueOrder() {}

    public LeagueOrder(User user, String leagueUsername, String leaguePassword, Double orderPrice) {
        this.user = user;
        this.leagueUsername = leagueUsername;
        this.leaguePassword = leaguePassword;
        this.orderPrice = orderPrice;
    }
}
