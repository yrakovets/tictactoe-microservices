package com.yrakovets.tictactoe.tictactoeAI.ai;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yrakovets.tictactoe.tictactoeAI.ai.AI.cross;
import static com.yrakovets.tictactoe.tictactoeAI.ai.AI.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinesConstructorTest {

    @Test
    public void testLines() {
        List<Character> field = new FieldFactory().build();

        field.set(0, cross);
        field.set(4, cross);
        field.set(2, zero);

        LinesConstructor constructor = new LinesConstructor(field, true);

        List<Line> lines = constructor.getLines();

        assertEquals(8, lines.size());

        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 2, -1 },
                { 4, 1 },
                { 6, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line lineToFind = new Line(map);

        assertTrue(lines.stream().anyMatch(lineToFind::equals));

        map = Stream.of(new Integer[][] {
                { 6, -1 },
                { 7, 1 },
                { 8, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line lineToFind2 = new Line(map);

        assertTrue(lines.stream().noneMatch(line -> line.equals(lineToFind2)));
    }

}