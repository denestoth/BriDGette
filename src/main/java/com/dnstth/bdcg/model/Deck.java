package com.dnstth.bdcg.model;

import com.dnstth.bdcg.helper.CardHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deck.
 *
 * @author Denes Toth
 */
@Document(collection = "deck")
public class Deck {

    @Id
    private String id;

    @Field
    private List<Card> cards;

    public Deck() {
    }

    private Deck(final List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Creates deck.
     *
     * @return {@link Deck}
     */
    public static Deck create() {
        List<Card> cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                Card card = new Card();
                card.setSuit(suit);
                card.setFace(face);
                cards.add(card);
            }
        }

        cards = CardHelper.shuffle(cards);

        return new Deck(cards);
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

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
