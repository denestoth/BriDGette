package com.dnstth.bdcg.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeckController {

    /**
     * Create a deck.
     */
    @PostMapping("decks")
    void createDeck() {

    }
}