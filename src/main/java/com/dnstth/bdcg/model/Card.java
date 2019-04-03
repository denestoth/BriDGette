package com.dnstth.bdcg.model;

/**
 * Represents a card.
 *
 * @author Denes Toth
 */
public class Card {
    private final Suit suit;
    private final Face face;

    private Card(final Suit suit, final Face face) {
        this.suit = suit;
        this.face = face;
    }

    public static Card create(final Suit suit, final Face face) {
        return new Card(suit, face);
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }

    public int getValue() {
        return face.getValue();
    }
}
