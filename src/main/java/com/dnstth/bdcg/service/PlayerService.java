package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.PlayerView;

import java.util.List;

/**
 * Player service.
 *
 * @author Denes Toth
 */
public interface PlayerService {
    List<PlayerView> getPlayers();

    PlayerView getPlayerById(final String id);

    PlayerView addPlayer(final PlayerView playerView);

    PlayerView updatePlayer(final PlayerView playerView);

    void deletePlayerById(final String id);
}
