package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.ShoeView;

import java.util.List;

/**
 * Shoe service.
 *
 * @author Denes Toth
 */
public interface ShoeService {
    List<ShoeView> getShoes();

    ShoeView getShoeById(final String id);

    ShoeView addShoe(final ShoeView shoeView);

    ShoeView updateShoe(final ShoeView shoeView);

    void deleteShoe(final String id);

    void addDeckToShoeById(final String gameId, final String deckId);

    ShoeView shuffle(final String gameId);

    String getUndealtCards(final String gameId);
}
