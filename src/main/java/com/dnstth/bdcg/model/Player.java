package com.dnstth.bdcg.model;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player.
 *
 * @author Denes Toth
 */
@Document(collection = "player")
public class Player {

    @Id
    private String id;

    @Field
    private List<Card> hand  = new ArrayList<>();

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /**
     * Computes total added value of player's hand.
     *
     * @return sum
     */
    public int getHandValue() {
        int handValue = 0;
        for (Card card: hand) {
            handValue += card.getValue();
        }
        return handValue;
    }
}
