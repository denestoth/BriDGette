package com.dnstth.bdcg.controller;

import com.dnstth.bdcg.model.Deck;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ShoeController {

    /**
     * Get count of how many cards per suit are left undealt in the game deck.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/shoe")
    void getNumberOfUndealtCardsPerSuit(@PathVariable long gameId) {

    }

    /**
     * Add deck to a shoe.
     *
     * @param gameId game id
     * @param deck deck to be added to shoe
     */
    @PatchMapping("/games/{gameId}/shoe")
    void addDeckToShoe(@PathVariable long gameId, @RequestBody Deck deck) {

    }

    /**
     * Get count of each card (suit and value) remaining in the game deck sorted by suit
     * (hearts, spades, clubs, and diamonds) and face value from high value to low value.
     *
     * @param gameId game id
     */
    @GetMapping("/games/{gameId}/shoe/cardCount")
    void getCardCount(@PathVariable long gameId) {

    }

    /**
     * Shuffle the game deck (shoe).
     *
     * @param gameId game id
     */
    @GetMapping("games/{gameId}/shoe/shuffle")
    void shuffle(@PathVariable long gameId) {

    }
}
