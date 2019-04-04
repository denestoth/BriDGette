package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Player;
import com.dnstth.bdcg.repository.PlayerRepository;
import com.dnstth.bdcg.service.GameService;
import com.dnstth.bdcg.service.PlayerService;
import com.dnstth.bdcg.service.transformer.PlayerTransformer;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.GameView;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link PlayerService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoPlayerService implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerTransformer playerTransformer;

    @Autowired
    private GameService gameService;

    @Override
    public List<PlayerView> getPlayers(String gameId) {
        return gameService.getGameById(gameId).getPlayers();
    }

    @Override
    public PlayerView getPlayerById(final String id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (!optionalPlayer.isPresent()) {
            // throw new EntityNotFoundException(Player.class, id);
        }
        return playerTransformer.transform(optionalPlayer.get());
    }

    @Override
    public PlayerView addPlayer(final String gameId) {
        Player player = new Player();
        playerRepository.save(player);
        PlayerView playerView = playerTransformer.transform(player);

        GameView gameView = gameService.getGameById(gameId);
        gameView.addPlayer(playerView);
        gameService.updateGame(gameView);

        return playerTransformer.transform(player);
    }

    @Override
    public PlayerView updatePlayer(final PlayerView playerView) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerView.getId());
        if (!optionalPlayer.isPresent()) {
            // throw new EntityNotFoundException(Player.class, id);
        }

        Player player = optionalPlayer.get();
        Player tmpPlayer = playerTransformer.transform(playerView);
        player.setHand(tmpPlayer.getHand());
        playerRepository.save(player);
        return playerView;
    }

    @Override
    public void deletePlayerById(final String id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerView dealCardToPlayer(String gameId, String playerId, int nrOfCards) {
        GameView gameView = gameService.getGameById(gameId);
        PlayerView playerView = getPlayerById(playerId);

        for (int i = 0; i < nrOfCards && gameView.getShoe().getCards().size() > 0; i++) {
            CardView cardView = gameView.getShoe().getCards().get(0);
            gameView.getShoe().getCards().remove(cardView);
            playerView.dealCard(cardView);
        }

        updatePlayer(playerView);
        gameService.updateGame(gameView);
        return playerView;
    }
}
