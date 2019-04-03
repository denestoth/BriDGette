package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.service.DeckService;
import com.dnstth.bdcg.view.DeckView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link DeckService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoDeckService implements DeckService {
    @Override
    public List<DeckView> getDecks() {
        return null;
    }

    @Override
    public DeckView getDeckById(String id) {
        return null;
    }

    @Override
    public DeckView addDeck(DeckView deckView) {
        return null;
    }

    @Override
    public DeckView updateDeck(DeckView deckView) {
        return null;
    }

    @Override
    public void deleteDeckById(String id) {

    }
}
