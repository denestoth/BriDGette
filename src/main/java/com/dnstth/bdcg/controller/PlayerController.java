package com.dnstth.bdcg.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Player controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    /**
     * Get the list of players in a game along with the total added value of all the cards each
     * player holds.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/players")
    void getPlayers(@PathVariable long gameId) {

    }

    /**
     * Add new player to a game.
     *
     * @param gameId game id
     */
    @PostMapping("/games/{gameId}/players")
    void addPlayer(@PathVariable long gameId) {

    }

    /**
     * Delete player from a game.
     *
     * @param gameId   game id
     * @param playerId player id
     */
    @DeleteMapping("/games/{gameId}/players/{playerId}")
    void deletePlayer(@PathVariable long gameId, @PathVariable long playerId) {

    }

    /**
     * Deal cards to a player.
     *
     * @param gameId    game id
     * @param playerId  player id
     * @param nrOfCards nr of cards to be dealt to the player
     */
    @PostMapping("/games/{gameId}/players/{playerId}")
    void dealCard(@PathVariable long gameId, @PathVariable long playerId, @RequestBody int nrOfCards) {

    }

    /**
     * Get the list of cards for a player.
     *
     * @param gameId   game id
     * @param playerId player id
     */
    @GetMapping("/games/{gameId}/players/{playerId}/hand")
    void getCards(@PathVariable long gameId, @PathVariable long playerId) {

    }
}
