package com.dnstth.bdcg.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Player view.
 *
 * @author Denes Toth
 */
@JsonDeserialize
public class PlayerView {

    private String id;
    private List<CardView> hand;

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
}
