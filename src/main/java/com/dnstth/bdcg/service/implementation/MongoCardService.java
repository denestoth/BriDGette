package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.service.CardService;
import com.dnstth.bdcg.view.CardView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link CardService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoCardService implements CardService {
    @Override
    public List<CardView> getCards() {
        return null;
    }

    @Override
    public CardView getCardById(String id) {
        return null;
    }

    @Override
    public CardView addCard(CardView cardView) {
        return null;
    }

    @Override
    public CardView updateCard(CardView cardView) {
        return null;
    }

    @Override
    public void deleteCardById(String id) {

    }
}
