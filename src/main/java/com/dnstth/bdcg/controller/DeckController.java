package com.dnstth.bdcg.controller;

import com.dnstth.bdcg.service.DeckService;
import com.dnstth.bdcg.view.DeckView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Deck controller.
 *
 * @author Denes Toth
 */
@RestController
@RequestMapping("/api/v1")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping(value = "/decks")
    public List<DeckView> getDecks() {
        return deckService.getDecks();
    }

    /**
     * Create a deck.
     */
    @PostMapping(value = "/decks", produces = "application/json")
    public DeckView createDeck() {
        return deckService.addDeck();
    }
}
