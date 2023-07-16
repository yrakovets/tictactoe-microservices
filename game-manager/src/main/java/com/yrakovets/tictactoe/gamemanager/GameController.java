package com.yrakovets.tictactoe.gamemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class GameController {
    @Autowired
    private GameManager gameManager;

    @GetMapping(path = "/getDesk")
    public Game getCurrentGame() {
        Game currentGame = gameManager.getActiveGame();
        if (currentGame != null) {
            return gameManager.getActiveGame();
        } else {
            return gameManager.createNewGame(true);
        }
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
