package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.repository.CardRepository;
import com.dnstth.bdcg.service.CardService;
import com.dnstth.bdcg.service.transformer.CardTransformer;
import com.dnstth.bdcg.view.CardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link CardService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoCardService implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardTransformer cardTransformer;

    @Override
    public List<CardView> getCards() {
        return cardRepository
                .findAll()
                .stream()
                .map(card -> cardTransformer.transform(card))
                .collect(Collectors.toList());
    }

    @Override
    public CardView getCardById(final String id) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isEmpty()) {
            // throw new EntityNotFoundException(Card.class, id);
        }
        return cardTransformer.transform(optionalCard.get());
    }

    @Override
    public CardView addCard(final CardView cardView) {
        Card card = cardTransformer.transform(cardView);
        cardRepository.save(card);
        cardView.setId(card.getId());
        return cardView;
    }

    @Override
    public CardView updateCard(final CardView cardView) {
        Optional<Card> optionalCard = cardRepository.findById(cardView.getId());
        if (optionalCard.isEmpty()) {
            // throw new EntityNotFoundException(Card.class, id);
        }
        Card card = optionalCard.get();
        card.setFace(cardView.getFace());
        card.setSuit(cardView.getSuit());
        cardRepository.save(card);
        return cardView;
    }

    @Override
    public void deleteCardById(final String id) {
        cardRepository.deleteById(id);
    }
}
