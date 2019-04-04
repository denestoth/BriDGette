package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Card;
import com.dnstth.bdcg.model.Player;
import com.dnstth.bdcg.repository.PlayerRepository;
import com.dnstth.bdcg.service.PlayerService;
import com.dnstth.bdcg.service.transformer.CardTransformer;
import com.dnstth.bdcg.service.transformer.PlayerTransformer;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<PlayerView> getPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(player -> playerTransformer.transform(player))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerView getPlayerById(final String id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            // throw new EntityNotFoundException(Player.class, id);
        }
        return playerTransformer.transform(optionalPlayer.get());
    }

    @Override
    public PlayerView addPlayer(final PlayerView playerView) {
        Player player = playerTransformer.transform(playerView);
        playerRepository.save(player);
        playerView.setId(player.getId());
        return playerView;
    }

    @Override
    public PlayerView updatePlayer(final PlayerView playerView) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerView.getId());
        if (optionalPlayer.isEmpty()) {
            // throw new EntityNotFoundException(Player.class, id);
        }

        Player player = optionalPlayer.get();
        Player tmpPlayer = playerTransformer.transform(playerView);
        player.setHand(tmpPlayer.getHand());
        return playerView;
    }

    @Override
    public void deletePlayerById(final String id) {
        playerRepository.deleteById(id);
    }
}
