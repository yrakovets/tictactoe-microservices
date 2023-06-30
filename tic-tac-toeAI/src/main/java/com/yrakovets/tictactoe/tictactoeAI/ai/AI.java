package com.yrakovets.tictactoe.tictactoeAI.ai;

import java.util.*;

public class AI {
    public static final char cross = 'x';
    public static final char zero = 'o';

    public int getStep(List<Character> field, boolean isCross) {
        List<Line> lines = new LinesConstructor(field, isCross).getLines();

        Optional<Integer> winning = lines
                .stream()
                .filter(Line::isWinning)
                .map(Line::getEmpty).findFirst();

        if (winning.isPresent()) {
            return winning.get();
        }

        Optional<Integer> saving = lines.stream().filter(Line::isCritical).map(Line::getEmpty).findFirst();

        if (saving.isPresent()) {
            return saving.get();
        }

        return getEmptyByPriority(field);
    }

    private int getEmptyByPriority(List<Character> field) {
        // center is top priority
        if (field.get(4) == null) {
            return 4;
        }

        //then corner
        List<Integer> corners = Arrays.asList(0, 2, 6, 8);
        Collections.shuffle(corners);
        Optional<Integer> emptyCorner = corners.stream().filter(index -> field.get(index) == null).findFirst();
        if (emptyCorner.isPresent()) {
            return emptyCorner.get();
        }

        List<Integer> sides = Arrays.asList(1, 3, 5, 7);
        Collections.shuffle(sides);
        Optional<Integer> emptySide = sides.stream().filter(index -> field.get(index) == null).findFirst();

        return emptySide.orElse(-1);
    }
}
