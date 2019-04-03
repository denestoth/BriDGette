package com.dnstth.bdcg.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shoe.
 *
 * @author Denes Toth
 */
public class Shoe {
    private final List<Card> cards;

    public Shoe() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addDeck(final Deck deck) {
        this.cards.addAll(deck.getCards());
    }
}
