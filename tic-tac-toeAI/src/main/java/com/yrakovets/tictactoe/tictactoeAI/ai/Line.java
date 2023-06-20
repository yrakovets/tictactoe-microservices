package com.yrakovets.tictactoe.tictactoeAI.ai;

import java.util.Map;

class Line {
    private final Map<Integer, Integer> fields;
    private final int value;

    public Line(Map<Integer, Integer> fields) {
        this.fields = fields;
        value = fields.values().stream().mapToInt(x -> x).sum();
    }

    boolean isWinning() {
        return value == 2;
    }

    boolean isAlreadyWon() {
        return value == 3;
    }

    boolean isCritical() {
        return value == -2;
    }

    boolean isAlreadyLost() {
        return value == -3;
    }

    int getEmpty() {
        return fields.entrySet().stream().filter(x -> x.getValue() == 0).findFirst().map(Map.Entry::getKey).get();
    }

    @Override
    public int hashCode() {
        return fields.entrySet().stream()
                .map(entry -> entry.getKey().hashCode() ^ entry.getValue().hashCode())
                .reduce(0, (x,y) -> x ^ y);
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Line) {
            return fields.entrySet().stream()
                    .allMatch(field -> field.getValue().equals(((Line) another).fields.get(field.getKey())));
        }
        return false;
    }
}
