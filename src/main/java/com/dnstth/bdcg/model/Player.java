package com.dnstth.bdcg.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player.
 *
 * @author Denes Toth
 */
public class Player {
    List<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public void dealCard(final Card card) {
        this.hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card card: hand) {
            handValue += card.getValue();
        }
        return handValue;
    }
}
