package com.dnstth.bdcg.helper;

import com.dnstth.bdcg.model.Card;


import java.util.Collections;
import java.util.List;

/**
 * Helper class for cards.
 *
 * @author Denes Toth
 */
public class CardHelper {

    /**
     * Shuffles cards.
     *
     * @param cards list of {@link Card}
     * @return shuffled list of {@link Card}
     */
    public static List<Card> shuffle(final List<Card> cards) {
        Collections.shuffle(cards);
        return cards;
    }
}
