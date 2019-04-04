package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.model.Deck;
import com.dnstth.bdcg.repository.DeckRepository;
import com.dnstth.bdcg.service.DeckService;
import com.dnstth.bdcg.service.transformer.CardTransformer;
import com.dnstth.bdcg.service.transformer.DeckTransformer;
import com.dnstth.bdcg.view.DeckView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link DeckService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoDeckService implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckTransformer deckTransformer;

    @Override
    public List<DeckView> getDecks() {
        return deckRepository
                .findAll()
                .stream()
                .map(deck -> deckTransformer.transform(deck))
                .collect(Collectors.toList());
    }

    @Override
    public DeckView getDeckById(final String id) {
        Optional<Deck> optionalDeck = deckRepository.findById(id);
        if (optionalDeck.isEmpty()) {
            // throw new EntityNotFoundException(Deck.class, id);
        }
        return deckTransformer.transform(optionalDeck.get());
    }

    @Override
    public DeckView addDeck(final DeckView deckView) {
        Deck deck = deckTransformer.transform(deckView);
        deckRepository.save(deck);
        deckView.setId(deck.getId());
        return deckView;
    }

    @Override
    public DeckView updateDeck(final DeckView deckView) {
        Optional<Deck> optionalDeck = deckRepository.findById(deckView.getId());
        if (optionalDeck.isEmpty()) {
            // throw new EntityNotFoundException(Deck.class, id);
        }
        Deck deck = optionalDeck.get();
        Deck tmpDeck = deckTransformer.transform(deckView);
        deck.setCards(tmpDeck.getCards());
        deckRepository.save(deck);
        return deckView;
    }

    @Override
    public void deleteDeckById(final String id) {
        deckRepository.deleteById(id);
    }
}
