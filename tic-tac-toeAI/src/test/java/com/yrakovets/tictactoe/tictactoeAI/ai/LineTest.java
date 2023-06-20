package com.yrakovets.tictactoe.tictactoeAI.ai;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testWinningForTrue() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, 1 },
                { 1, 1 },
                { 2, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertTrue(line.isWinning());
    }

    @Test
    void testWinningForFewEmpty() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 2, 0 },
                { 5, 1 },
                { 8, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isWinning());
    }

    @Test
    void testWinningForFull() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 4, 1 },
                { 8, 1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isWinning());
    }

    @Test
    void isAlreadyWonForTrue() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 3, 1 },
                { 4, 1 },
                { 5, 1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertTrue(line.isAlreadyWon());
    }

    @Test
    void isAlreadyWonForMixed() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, 1 },
                { 1, -1 },
                { 2, 1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isAlreadyWon());
    }

    @Test
    void isAlreadyWonForEmpty() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 2, 0 },
                { 4, 0 },
                { 6, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isAlreadyWon());
    }

    @Test
    void isCriticalForTrue() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 3, 0 },
                { 6, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertTrue(line.isCritical());
    }

    @Test
    void isCriticalForMoreThanOneEmpty() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, 0 },
                { 1, 0 },
                { 2, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isCritical());
    }

    @Test
    void isCriticalForFull() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 2, -1 },
                { 5, 1 },
                { 8, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isCritical());
    }

    @Test
    void isCriticalForAlreadyLost() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 4, -1 },
                { 8, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isCritical());
    }

    @Test
    void isCriticalForMixed() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 1, 1 },
                { 2, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isCritical());
    }

    @Test
    void isAlreadyLostForTrue() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 3, -1 },
                { 6, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertTrue(line.isAlreadyLost());
    }

    @Test
    void isAlreadyLostForMixed() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 2, -1 },
                { 4, 1 },
                { 6, -1 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertFalse(line.isAlreadyLost());
    }

    @Test
    void getEmpty() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, -1 },
                { 1, 1 },
                { 2, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertEquals(2, line.getEmpty());
    }

    @Test
    void getEmpty2() {
        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                { 0, 0 },
                { 4, 1 },
                { 8, 0 }
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Line line = new Line(map);
        assertEquals(0, line.getEmpty());
    }
}