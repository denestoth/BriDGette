package com.dnstth.bdcg.service.transformer;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.model.Shoe;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.ShoeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoeTransformer {

    @Autowired
    private CardTransformer cardTransformer;

    /**
     * Transforms {@link ShoeView} into {@link Shoe}.
     *
     * @param shoeView {@link ShoeView}
     * @return {@link Shoe}
     */
    public Shoe transform(final ShoeView shoeView) {
        Shoe shoe = new Shoe();
        shoe.setId(shoeView.getId());
        List<Card> cards = shoeView.getCards()
                .stream()
                .map(cardView -> cardTransformer.transform(cardView))
                .collect(Collectors.toList());
        shoe.setCards(cards);
        return shoe;
    }

    /**
     * Transforms {@link Shoe} into {@link ShoeView}.
     *
     * @param shoe {@link Shoe}
     * @return {@link ShoeView}
     */
    public ShoeView transform(final Shoe shoe) {
        ShoeView shoeView = new ShoeView();
        shoeView.setId(shoe.getId());
        List<CardView> cards = shoe.getCards()
                .stream()
                .map(card -> cardTransformer.transform(card))
                .collect(Collectors.toList());
        shoeView.setCards(cards);
        return shoeView;
    }
}
