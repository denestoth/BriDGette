package com.dnstth.bdcg.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deck.
 *
 * @author Denes Toth
 */
public class Deck {
    private List<Card> cards;

    public Deck(final List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Creates deck.
     *
     * @return {@link Deck}
     */
    public Deck create() {
        List<Card> cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                cards.add(Card.create(suit, face));
            }
        }

        return new Deck(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
