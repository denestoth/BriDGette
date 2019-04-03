package com.dnstth.bdcg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shoe.
 *
 * @author Denes Toth
 */
@Document(collection = "shoe")
public class Shoe {

    @Id
    private String id;

    @Field
    private List<Card> cards;

    public Shoe() {
        this.cards = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    public void addDeck(final Deck deck) {
        this.cards.addAll(deck.getCards());
    }
}
