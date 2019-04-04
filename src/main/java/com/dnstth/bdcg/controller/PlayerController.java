package com.dnstth.bdcg.controller;

import com.dnstth.bdcg.service.PlayerService;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Player controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Get the list of players in a game along with the total added value of all the cards each
     * player holds.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/players")
    public List<PlayerView> getPlayers(@PathVariable String gameId) {
        return playerService.getPlayers(gameId);
    }

    /**
     * Add new player to a game.
     *
     * @param gameId game id
     */
    @PostMapping("/games/{gameId}/players")
    public PlayerView addPlayer(@PathVariable String gameId) {
        return playerService.addPlayer(gameId);
    }

    /**
     * Delete player from a game.
     *
     * @param gameId   game id
     * @param playerId player id
     */
    @DeleteMapping("/games/{gameId}/players/{playerId}")
    public void deletePlayer(@PathVariable String gameId, @PathVariable String playerId) {
        playerService.deletePlayerById(playerId);
    }

    /**
     * Deal cards to a player.
     *
     * @param gameId    game id
     * @param playerId  player id
     * @param nrOfCards nr of cards to be dealt to the player
     */
    @PostMapping("/games/{gameId}/players/{playerId}")
    public void dealCard(@PathVariable String gameId, @PathVariable String playerId, @RequestBody int nrOfCards) {
        playerService.dealCardToPlayer(gameId, playerId, nrOfCards);
    }

    /**
     * Get the list of cards for a player.
     *
     * @param gameId   game id
     * @param playerId player id
     */
    @GetMapping("/games/{gameId}/players/{playerId}/hand")
    public List<CardView> getCards(@PathVariable String gameId, @PathVariable String playerId) {
        return playerService.getPlayerById(playerId).getHand();
    }
}
