package com.dnstth.bdcg.service.transformer;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.view.CardView;
import org.springframework.stereotype.Component;

@Component
public class CardTransformer {

    /**
     * Transforms {@link CardView} into {@link Card}.
     *
     * @param cardView {@link CardView}
     * @return {@link Card}
     */
    public Card transform(final CardView cardView) {
        Card card = new Card();
        card.setId(cardView.getId());
        card.setSuit(cardView.getSuit());
        card.setFace(cardView.getFace());
        return card;
    }

    /**
     * Transforms {@link Card} into {@link CardView}.
     *
     * @param card {@link Card}
     * @return {@link CardView}
     */
    public CardView transform(final Card card) {
        CardView cardView = new CardView();
        cardView.setId(card.getId());
        cardView.setSuit(card.getSuit());
        cardView.setFace(card.getFace());
        return cardView;
    }
}
