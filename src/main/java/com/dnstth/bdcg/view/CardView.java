package com.dnstth.bdcg.view;

import com.dnstth.bdcg.model.Face;
import com.dnstth.bdcg.model.Suit;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Card view.
 *
 * @author Denes Toth
 */
@JsonDeserialize
public class CardView {

    private String id;

    private Suit suit;

    private Face face;

    public CardView() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }
}
