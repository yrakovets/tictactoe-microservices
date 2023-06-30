package com.yrakovets.tictactoe.gamemanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.apache.logging.log4j.util.Strings;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private boolean isFinished;
    private boolean playedCrosses;
    private String crosses = Strings.EMPTY;
    private String zeros = Strings.EMPTY;

    public Game() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getCrosses() {
        return crosses;
    }

    public void setCrosses(String crosses) {
        this.crosses = crosses;
    }

    public String getZeros() {
        return zeros;
    }

    public void setZeros(String zeros) {
        this.zeros = zeros;
    }

    public void close() {
        this.isFinished = true;
    }

    public boolean isPlayedCrosses() {
        return playedCrosses;
    }

    public void setPlayedCrosses(boolean playedCrosses) {
        this.playedCrosses = playedCrosses;
    }
}
