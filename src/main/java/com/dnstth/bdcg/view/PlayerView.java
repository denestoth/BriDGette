package com.dnstth.bdcg.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Player view.
 *
 * @author Denes Toth
 */
@JsonDeserialize
public class PlayerView {

    private String id;
    private List<CardView> hand  = new ArrayList<>();

    public PlayerView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CardView> getHand() {
        return hand;
    }

    public void setHand(List<CardView> hand) {
        this.hand = hand;
    }

    /**
     * Deals a card to player.
     *
     * @param card {@link CardView}
     */
    public void dealCard(final CardView card) {
        this.hand.add(card);
    }
}
