package com.yrakovets.tictactoe.tictactoeAI.ai;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AITest {
    @Test
    void getStepWithWinning() {
        List<Character> field = new FieldFactory()
                .setCrosses(Arrays.asList(0,4))
                .setZeros(Arrays.asList(2))
                .build();

        assertEquals(8, new AI().getStep(field, true));
    }

    @Test
    void getStepWithWinning2() {
        List<Character> field = new FieldFactory()
                .setCrosses(Arrays.asList(4))
                .setZeros(Arrays.asList(2,0))
                .build();

        assertEquals(1, new AI().getStep(field, false));
    }

    @Test
    void getStepWithWinning3() {
        List<Character> field = new FieldFactory()
                .setCrosses(Arrays.asList(4,6,8))
                .setZeros(Arrays.asList(3,2,0))
                .build();

        assertEquals(7, new AI().getStep(field, true));
    }

    @Test
    void getSavingStep() {
        List<Character> field = new FieldFactory()
                .setCrosses(Arrays.asList(4,6))
                .setZero(0)
                .build();

        assertEquals(2, new AI().getStep(field, false));
    }

    @Test
    void getPriorityStep() {
        List<Character> field = new FieldFactory()
                .setCross(2)
                .build();

        assertEquals(4, new AI().getStep(field, false));
    }


    @Test
    void getPriorityStep2() {
        List<Character> field = new FieldFactory()
                .setCross(4)
                .build();

        assertTrue(Arrays.asList(0,2,6,8).contains(new AI().getStep(field, false)));
    }

    @Test
    void getPriorityStep3() {
        List<Character> field = new FieldFactory()
                .setCrosses(Arrays.asList(4,1,8))
                .setZeros(Arrays.asList(0,7))
                .build();

        assertTrue(Arrays.asList(2,6).contains(new AI().getStep(field, false)));
    }
}