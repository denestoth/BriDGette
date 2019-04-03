package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.CardView;

import java.util.List;

/**
 * Card service.
 *
 * @author Denes Toth
 */
public interface CardService {
    List<CardView> getCards();

    CardView getCardById(final String id);

    CardView addCard(final CardView cardView);

    CardView updateCard(final CardView cardView);

    void deleteCardById(final String id);
}
