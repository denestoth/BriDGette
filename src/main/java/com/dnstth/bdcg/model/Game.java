package com.dnstth.bdcg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game.
 *
 * @author Denes Toth
 */
@Document(collection = "game")
public class Game {

    @Id
    private String id;

    @Field
    private List<Player> players;

    @Field
    private Shoe shoe;

    public Game() {
        players = new ArrayList<>();
        shoe = new Shoe();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    public void removePlayer(final Player player) {
        this.players.remove(player);
    }

    public void addDeckToShoe(final Deck deck) {
        this.shoe.addDeck(deck);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
}
