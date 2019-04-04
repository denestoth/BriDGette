package com.dnstth.bdcg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Represents a card.
 *
 * @author Denes Toth
 */
@Document(collection = "card")
public class Card {

    @Id
    private String id;

    @Field
    private Suit suit;

    @Field
    private Face face;

    public Card() {
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

    public int getValue() {
        return face.getValue();
    }

    @Override
    public String toString(){
        return this.face.name() + " of " + this.suit.name();
    }
}
