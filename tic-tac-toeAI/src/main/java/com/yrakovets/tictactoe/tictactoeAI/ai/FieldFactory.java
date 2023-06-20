package com.yrakovets.tictactoe.tictactoeAI.ai;

import java.util.ArrayList;
import java.util.List;

public class FieldFactory {
    List<Character> field;

    public FieldFactory() {
        field = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            field.add(i, null);
        }
    }


    //TODO:  refactor with DRY principle
    public FieldFactory setCrosses(List<Integer> indexes) {
        for (Integer index : indexes) {
            field.set(index, AI.cross);
        }
        return this;
    }

    public FieldFactory setCrosses(String indexString) {
        for (char indexChar : indexString.toCharArray()) {
            field.set(Integer.parseInt(String.valueOf(indexChar)), AI.cross);
        }
        return this;
    }

    public FieldFactory setCross(Integer index) {
        field.set(index, AI.cross);
        return this;
    }

    public FieldFactory setZeros(List<Integer> indexes) {
        for (Integer index : indexes) {
            field.set(index, AI.zero);
        }
        return this;
    }

    public FieldFactory setZeros(String indexString) {
        for (char indexChar : indexString.toCharArray()) {
            field.set(Integer.parseInt(String.valueOf(indexChar)), AI.zero);
        }
        return this;
    }

    public FieldFactory setZero(Integer index) {
        field.set(index, AI.zero);
        return this;
    }

    public List<Character> build() {
        return field;
    }
}
