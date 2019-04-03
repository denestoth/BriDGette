package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.DeckView;

import java.util.List;

/**
 * Deck service.
 *
 * @author Denes Toth
 */
public interface DeckService {
    List<DeckView> getDecks();

    DeckView getDeckById(final String id);

    DeckView addDeck(final DeckView deckView);

    DeckView updateDeck(final DeckView deckView);

    void deleteDeckById(final String id);
}
