package com.yrakovets.tictactoe.gamemanager;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameEstimation {
    private static final List<List<String>> lines = Lists.newArrayList(
            Lists.newArrayList("0", "1", "2"),
            Lists.newArrayList("0", "3", "6"),
            Lists.newArrayList("0", "4", "8"),
            Lists.newArrayList("1", "4", "7"),
            Lists.newArrayList("2", "4", "6"),
            Lists.newArrayList("3", "4", "5"),
            Lists.newArrayList("6", "7", "8")
    );

    public void estimate(Game game) {
        if (crossWin(game)) {
            game.setWinner(Game.cross);
            game.setFinished(true);
            return;
        }
        if (zeroWin(game)) {
            game.setWinner(Game.zero);
            game.setFinished(true);
            return;
        }
        if (game.getCrosses().length() + game.getZeros().length() == 9) {
            game.setFinished(true);
        }
    }

    private boolean zeroWin(Game game) {
        return containsWholeLine(game.getZeros());
    }

    private boolean crossWin(Game game) {
        return containsWholeLine(game.getCrosses());
    }

    private boolean containsWholeLine(String string) {
        return lines.stream().anyMatch(line -> containsAllSymbols(string, line));
    }

    private boolean containsAllSymbols(String string, List<String> chars) {
        return chars.stream().allMatch(string::contains);
    }
}
