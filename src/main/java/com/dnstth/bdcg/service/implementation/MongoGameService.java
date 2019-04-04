package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Game;
import com.dnstth.bdcg.repository.GameRepository;
import com.dnstth.bdcg.service.GameService;
import com.dnstth.bdcg.service.transformer.GameTransformer;
import com.dnstth.bdcg.view.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link GameService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoGameService implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameTransformer gameTransformer;

    @Override
    public List<GameView> getGames() {
        return gameRepository
                .findAll()
                .stream()
                .map(game -> gameTransformer.transform(game))
                .collect(Collectors.toList());
    }

    @Override
    public GameView getGameById(final String id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (!optionalGame.isPresent()) {
            // throw new EntityNotFoundException(Game.class, id);
        }
        return gameTransformer.transform(optionalGame.get());
    }

    @Override
    public GameView addGame(final GameView gameView) {
        Game game = gameTransformer.transform(gameView);
        gameRepository.save(game);
        gameView.setId(game.getId());
        return gameView;
    }

    @Override
    public GameView updateGame(final GameView gameView) {
        Optional<Game> optionalGame = gameRepository.findById(gameView.getId());
        if (!optionalGame.isPresent()) {
            // throw new EntityNotFoundException(Game.class, id);
        }
        Game game = optionalGame.get();
        Game tmpGame = gameTransformer.transform(gameView);
        game.setShoe(tmpGame.getShoe());
        game.setPlayers(tmpGame.getPlayers());
        gameRepository.save(game);
        return gameView;
    }

    @Override
    public void deleteGameById(final String id) {
        gameRepository.deleteById(id);
    }
}
