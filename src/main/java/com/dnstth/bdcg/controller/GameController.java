package com.dnstth.bdcg.controller;

import com.dnstth.bdcg.service.GameService;
import com.dnstth.bdcg.view.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Game controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Get the list of games.
     */
    @GetMapping(value = "/games", produces = "application/json")
    public List<GameView> getGames() {
        return gameService.getGames();
    }

    /**
     * Creates new game.
     */
    @PostMapping(value = "/games", produces = "application/json", consumes = "application/json")
    public GameView newGame() {
        return gameService.addGame(new GameView());
    }

    /**
     * Deletes a game.
     *
     * @param gameId game id
     */
    @DeleteMapping(value = "/games/{gameId}", consumes = "application/json")
    public void deleteGame(@PathVariable String gameId) {
        gameService.deleteGameById(gameId);
    }
}
