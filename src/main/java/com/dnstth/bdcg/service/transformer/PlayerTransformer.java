package com.dnstth.bdcg.service.transformer;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.model.Player;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerTransformer {

    @Autowired
    private CardTransformer cardTransformer;

    /**
     * Transforms {@link PlayerView} into {@link Player}.
     *
     * @param playerView {@link PlayerView}
     * @return {@link Player}
     */
    public Player transform(final PlayerView playerView) {
        Player player = new Player();
        player.setId(playerView.getId());
        List<Card> cards = playerView.getHand()
                .stream()
                .map(cardView -> cardTransformer.transform(cardView))
                .collect(Collectors.toList());
        player.setHand(cards);
        return player;
    }

    /**
     * Transforms {@link Player} into {@link PlayerView}.
     *
     * @param player {@link Player}
     * @return {@link PlayerView}
     */
    public PlayerView transform(final Player player) {
        PlayerView playerView = new PlayerView();
        playerView.setId(player.getId());
        List<CardView> cards = player.getHand()
                .stream()
                .map(card -> cardTransformer.transform(card))
                .collect(Collectors.toList());
        playerView.setHand(cards);
        return playerView;
    }
}
