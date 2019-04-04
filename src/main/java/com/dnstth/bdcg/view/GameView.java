package com.dnstth.bdcg.view;

import com.dnstth.bdcg.model.Deck;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Game view.
 *
 * @author Denes Toth
 */
@JsonDeserialize
public class GameView {

    private String id;
    private List<PlayerView> players  = new ArrayList<>();
    private ShoeView shoe  = new ShoeView();

    public GameView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PlayerView> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerView> players) {
        this.players = players;
    }

    public ShoeView getShoe() {
        return shoe;
    }

    public void setShoe(ShoeView shoe) {
        this.shoe = shoe;
    }

    public void addPlayer(final PlayerView playerView) {
        this.players.add(playerView);
    }

    public void addDeckToShoe(final DeckView deck) {
        this.shoe.addDeck(deck);
    }
}
