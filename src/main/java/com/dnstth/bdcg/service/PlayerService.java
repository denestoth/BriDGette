package com.dnstth.bdcg.service;

import com.dnstth.bdcg.view.PlayerView;

import java.util.List;

/**
 * Player service.
 *
 * @author Denes Toth
 */
public interface PlayerService {
    List<PlayerView> getPlayers(String gameId);

    PlayerView getPlayerById(final String id);

    PlayerView addPlayer(final String gameId);

    PlayerView updatePlayer(final PlayerView playerView);

    void deletePlayerById(final String id);

    PlayerView dealCardToPlayer(final String gameId, final String playerId, final int nrOfCards);
}
