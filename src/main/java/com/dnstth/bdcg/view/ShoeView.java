package com.dnstth.bdcg.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Shoe view.
 *
 * @author Denes Toth
 */
@JsonDeserialize
public class ShoeView {

    private String id;
    private List<CardView> cards;

    public ShoeView() {
        cards = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CardView> getCards() {
        return cards;
    }

    public void setCards(List<CardView> cards) {
        this.cards = cards;
    }

    public void addDeck(final DeckView deck) {
        this.cards.addAll(deck.getCards());
    }
}
