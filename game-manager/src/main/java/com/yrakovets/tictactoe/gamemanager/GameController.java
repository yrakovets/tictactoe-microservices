package com.yrakovets.tictactoe.gamemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    private GameManager gameManager;

    @GetMapping(path = "/getDesk")
    public Game getCurrentGame() {
        return gameManager.getActiveGame();
    }

    @PostMapping(path = "/newGame")
    public Game setNewGame() {
        gameManager.closeActiveGame();
        return gameManager.createNewGame(true);
    }

    @PostMapping(path = "/newGame/{playedCrosses}")
    public Game setNewGame(@PathVariable Boolean playedCrosses) {
        gameManager.closeActiveGame();
        return gameManager.createNewGame(playedCrosses);
    }

    @PostMapping(path = "/makeStep/{step}")
    public Game makeStep(@PathVariable int step) {
        return gameManager.makeUserStep(step);
    }
}
