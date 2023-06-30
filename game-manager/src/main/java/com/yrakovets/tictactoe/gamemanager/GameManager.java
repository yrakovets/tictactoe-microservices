package com.yrakovets.tictactoe.gamemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameManager {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private AiProxy proxy;

    Game createNewGame(boolean playedCrosses) {
        Game newGame = new Game();
        newGame.setPlayedCrosses(playedCrosses);
        if (!playedCrosses) {
            makeAiStep(newGame);
        }
        gameRepository.save(newGame);
        return newGame;
    }

    void closeActiveGame() {
        List<Game> gameList = gameRepository.findTop1ByOrderByIdDesc();
        if (gameList.size() > 0) {
            Game game = gameList.get(0);
            if (!game.isFinished()) {
                game.close();
                gameRepository.save(game);
            }
        }
    }

    public Game getActiveGame() {
        List<Game> gameList = gameRepository.findTop1ByOrderByIdDesc();
        if (gameList.size() > 0) {
            return gameList.get(0);
        }
        return null;
    }

    private void makeAiStep(Game game) {
        int aiStep = proxy.getAnswer(game.getCrosses(), game.getZeros(), !game.isPlayedCrosses());
        if (game.isPlayedCrosses()) {
            game.setZeros(game.getZeros() + aiStep);
        } else {
            game.setCrosses(game.getCrosses() + aiStep);
        }
    }

    public Game makeUserStep(int step) {
        Game game = getActiveGame();
        if (!checkCorrectness(game, step)) {
            return game;
        }
        if (game.isPlayedCrosses()) {
            game.setCrosses(game.getCrosses() + step);
        } else {
            game.setZeros(game.getZeros() + step);
        }
        makeAiStep(game);
        gameRepository.save(game);
        return game;
    }

    private boolean checkCorrectness(Game game, int step) {
        return step >= 0 && step <= 8 && !game.getCrosses().contains(Integer.toString(step))
                && !game.getZeros().contains(Integer.toString(step));
    }
}
