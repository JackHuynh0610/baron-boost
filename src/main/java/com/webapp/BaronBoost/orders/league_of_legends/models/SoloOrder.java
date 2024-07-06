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
 * Represents a Solo Order for a League of Legends boosting service.
 * This entity extends {@link LeagueOrder} and adds additional fields specific to solo orders.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "solo_orders")
public class SoloOrder extends LeagueOrder {

    /**
     * The type of the order.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderType orderType = OrderType.SOLO;

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
     * The desired rank to be achieved.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueRank desiredRank;

    /**
     * The desired division to be achieved.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LeagueDivision desiredDivision;

    /**
     * The LP per game that the user gains.
     */
    @Column(nullable = false)
    private Integer lpPerGame;

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
     * Constructs a new SoloOrder with the specified details.
     *
     * @param user The user placing the order.
     * @param gameUsername The username for the League of Legends account.
     * @param gamePassword The password for the League of Legends account.
     * @param orderPrice The price of the order.
     * @param currentRank The current rank of the user.
     * @param currentDivision The current division of the user.
     * @param currentLp The current LP of the user.
     * @param desiredRank The desired rank to be achieved.
     * @param desiredDivision The desired division to be achieved.
     * @param lpPerGame The LP per game that the user gains.
     * @param mainLane The main lane of the order.
     * @param secondLane The second lane of the order.
     * @param champion1 The first champion of the order.
     * @param champion2 The second champion of the order.
     * @param champion3 The third champion of the order.
     * @param flash The flash spell of the order.
     */
    public SoloOrder(User user, String gameUsername, String gamePassword,
                    Double orderPrice, 
                    LeagueRank currentRank, LeagueDivision currentDivision, Integer currentLp,
                    LeagueRank desiredRank, LeagueDivision desiredDivision, Integer lpPerGame,
                    Lane mainLane, Lane secondLane, String champion1, String champion2, String champion3, Spell flash) {

        super(user, gameUsername, gamePassword, orderPrice);
        this.currentRank = currentRank;
        this.currentDivision = currentDivision;
        this.currentLp = currentLp;
        this.desiredRank = desiredRank;
        this.desiredDivision = desiredDivision;
        this.lpPerGame = lpPerGame;
        this.mainLane = mainLane;
        this.secondLane = secondLane;
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.champion3 = champion3;
        this.flash = flash;
    }
}
