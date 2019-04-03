package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.service.PlayerService;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link PlayerService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoPlayerService implements PlayerService {
    @Override
    public List<PlayerView> getPlayers() {
        return null;
    }

    @Override
    public PlayerView getPlayerById(String id) {
        return null;
    }

    @Override
    public PlayerView addPlayer(PlayerView playerView) {
        return null;
    }

    @Override
    public PlayerView updatePlayer(PlayerView playerView) {
        return null;
    }

    @Override
    public void deletePlayerById(String id) {

    }
}
