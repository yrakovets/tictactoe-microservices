package com.yrakovets.tictactoe.tictactoeAI.ai;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldBuilderTest {

    @Test
    public void testEmptyField () {
        List<Character> field = new FieldBuilder().build();
        assertEquals(field.size(), 9);
        for (int i = 0; i < 9; i++) {
            assertNull(field.get(i));
        }
    }


    @Test
    public void testFieldWithSimpleSteps () {
        List<Character> field = new FieldBuilder().setCross(5).setZero(7).build();
        assertEquals(field.size(), 9);
        assertNull(field.get(6));
        assertNull(field.get(4));
        assertSame(AI.cross, field.get(5));
        assertSame(AI.zero, field.get(7));
    }

    @Test
    public void testFieldWithArraySteps () {
        List<Character> field = new FieldBuilder()
                .setCrosses(Arrays.asList(3,5))
                .setZeros(Arrays.asList(2,7))
                .build();

        assertEquals(field.size(), 9);
        assertNull(field.get(6));
        assertNull(field.get(4));
        assertSame(AI.cross, field.get(5));
        assertSame(AI.zero, field.get(7));
    }

}
