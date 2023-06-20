package com.yrakovets.tictactoe.tictactoeAI.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.yrakovets.tictactoe.tictactoeAI.ai.AI.cross;
import static com.yrakovets.tictactoe.tictactoeAI.ai.AI.zero;

class LinesConstructor {

    private final List<Character> field;
    private final boolean isCross;

    final static List<List<Integer>> lineIndexes = new ArrayList<>() {{
        add(Arrays.asList(0,1,2));
        add(Arrays.asList(0,3,6));
        add(Arrays.asList(0,4,8));
        add(Arrays.asList(1,4,7));
        add(Arrays.asList(2,5,8));
        add(Arrays.asList(2,4,6));
        add(Arrays.asList(3,4,5));
        add(Arrays.asList(6,7,8));

    }};


    LinesConstructor(List<Character> field, boolean isCross) {
        this.field = field;
        this.isCross = isCross;
    }

    List<Line> getLines() {
        return lineIndexes.stream().map(this::createLine).collect(Collectors.toList());
    }

    private Line createLine(List<Integer> lineIndex) {
        Map<Integer, Integer> map = lineIndex.stream().collect(Collectors.toMap(index -> index, this::calculateValue));
        return new Line(map);
    }

    private Integer calculateValue(Integer index) {
        if (field.get(index) == null) return 0;
        if (isCross) {
            return switch (field.get(index)) {
                case cross -> 1;
                case zero -> -1;
                default -> 0;
            };
        } else {
            return switch (field.get(index)) {
                case cross -> -1;
                case zero -> 1;
                default -> 0;
            };
        }
    }
}
