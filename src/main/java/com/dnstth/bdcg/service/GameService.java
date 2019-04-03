package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.GameView;

import java.util.List;

/**
 * Game service.
 *
 * @author Denes Toth
 */
public interface GameService {
    List<GameView> getGames();

    GameView getGameById(final String id);

    GameView addGame(final GameView gameView);

    GameView updateGame(final GameView gameView);

    void deleteGameById(final String id);
}
