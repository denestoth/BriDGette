package com.dnstth.bdcg.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Game controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class GameController {

    /**
     * Get the list of games.
     */
    @GetMapping("/games")
    void getGames() {

    }

    /**
     * Creates new game.
     */
    @PostMapping("/games")
    void newGame() {

    }

    /**
     * Deletes a game.
     *
     * @param gameId game id
     */
    @DeleteMapping("/games/{gameId}")
    void deleteGame(@PathVariable long gameId) {

    }
}
