package com.dnstth.bdcg.service.transformer;

import com.dnstth.bdcg.model.Game;
import com.dnstth.bdcg.model.Player;
import com.dnstth.bdcg.view.GameView;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameTransformer {

    @Autowired
    private ShoeTransformer shoeTransformer;

    @Autowired
    private PlayerTransformer playerTransformer;

    /**
     * Transforms {@link GameView} into {@link Game}.
     *
     * @param gameView {@link GameView}
     * @return {@link Game}
     */
    public Game transform(final GameView gameView) {
        Game game = new Game();
        game.setId(gameView.getId());
        game.setShoe(shoeTransformer.transform(gameView.getShoe()));
        List<Player> players = gameView.getPlayers()
                .stream()
                .map(playerView -> playerTransformer.transform(playerView))
                .collect(Collectors.toList());
        game.setPlayers(players);
        return game;
    }

    /**
     * Transforms {@link Game} into {@link GameView}.
     *
     * @param game {@link Game}
     * @return {@link GameView}
     */
    public GameView transform(final Game game) {
        GameView gameView = new GameView();
        gameView.setId(game.getId());
        gameView.setShoe(shoeTransformer.transform(game.getShoe()));
        List<PlayerView> players = game.getPlayers()
                .stream()
                .map(player -> playerTransformer.transform(player))
                .collect(Collectors.toList());
        gameView.setPlayers(players);
        return gameView;
    }

}
