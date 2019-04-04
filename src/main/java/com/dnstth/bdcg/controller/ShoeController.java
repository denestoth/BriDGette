package com.dnstth.bdcg.controller;

import com.dnstth.bdcg.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Shoe (game deck) controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    /**
     * Get count of how many cards per suit are left undealt in the game deck.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/shoe")
    public String getNumberOfUndealtCardsPerSuit(@PathVariable String gameId) {
        return shoeService.getUndealtCards(gameId);
    }

    /**
     * Add deck to a shoe.
     *
     * @param gameId game id
     * @param deckId id of deck to be added to shoe
     */
    @PatchMapping("/games/{gameId}/shoe")
    public void addDeckToShoe(@PathVariable String gameId, @RequestBody String deckId) {
        shoeService.addDeckToShoeById(gameId, deckId);
    }

    /**
     * Get count of each card (suit and value) remaining in the game deck sorted by suit
     * (hearts, spades, clubs, and diamonds) and face value from high value to low value.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/shoe/cardCount")
    public void getCardCount(@PathVariable String gameId) {

    }

    /**
     * Shuffle the game deck (shoe).
     *
     * @param gameId game id
     */
    @GetMapping("games/{gameId}/shoe/shuffle")
    public void shuffle(@PathVariable String gameId) {
        shoeService.shuffle(gameId);
    }
}
