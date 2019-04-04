package com.dnstth.bdcg.service.transformer;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.model.Deck;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.DeckView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeckTransformer {

    @Autowired
    private CardTransformer cardTransformer;

    /**
     * Transforms {@link DeckView} into {@link Deck}.
     *
     * @param deckView {@link DeckView}
     * @return {@link Deck}
     */
    public Deck transform(final DeckView deckView) {
        Deck deck = new Deck();
        deck.setId(deckView.getId());
        List<Card> cards = deckView.getCards()
                .stream()
                .map(cardView -> cardTransformer.transform(cardView))
                .collect(Collectors.toList());
        deck.setCards(cards);
        return deck;
    }

    /**
     * Transforms {@link Deck} into {@link DeckView}.
     *
     * @param deck {@link Deck}
     * @return {@link DeckView}
     */
    public DeckView transform(final Deck deck) {
        DeckView deckView = new DeckView();
        deckView.setId(deck.getId());
        List<CardView> cards = deck.getCards()
                .stream()
                .map(card -> cardTransformer.transform(card))
                .collect(Collectors.toList());
        deckView.setCards(cards);
        return deckView;
    }

}
