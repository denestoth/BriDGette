package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.service.GameService;
import com.dnstth.bdcg.view.GameView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link GameService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoGameService implements GameService {
    @Override
    public List<GameView> getGames() {
        return null;
    }

    @Override
    public GameView getGameById(String id) {
        return null;
    }

    @Override
    public GameView addGame(GameView gameView) {
        return null;
    }

    @Override
    public GameView updateGame(GameView gameView) {
        return null;
    }

    @Override
    public void deleteGameById(String id) {

    }
}
