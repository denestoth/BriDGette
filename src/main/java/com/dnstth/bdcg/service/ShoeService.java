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

    ShoeView getShoeById(final ShoeView shoeView);

    ShoeView addShoe(final ShoeView shoeView);

    ShoeView updateShoe(final ShoeView shoeView);

    void deleteShoe(final String id);
}
