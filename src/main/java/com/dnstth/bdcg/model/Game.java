package com.dnstth.bdcg.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game.
 *
 * @author Denes Toth
 */
public class Game {
    private final List<Player> players;
    private final Shoe shoe;

    public Game() {
        players = new ArrayList<>();
        shoe = new Shoe();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    public void addDeckToShoe(final Deck deck) {
        this.shoe.addDeck(deck);
    }
}
