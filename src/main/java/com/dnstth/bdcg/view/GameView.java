package com.dnstth.bdcg.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize
public class GameView {

    private String id;
    private List<PlayerView> players;
    private ShoeView shoe;

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
}
