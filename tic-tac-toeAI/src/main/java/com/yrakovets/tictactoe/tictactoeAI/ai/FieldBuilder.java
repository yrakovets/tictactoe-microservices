package com.yrakovets.tictactoe.tictactoeAI.ai;

import java.util.ArrayList;
import java.util.List;

public class FieldBuilder {
    List<Character> field;

    public FieldBuilder() {
        field = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            field.add(i, null);
        }
    }


    //TODO:  refactor with DRY principle
    public FieldBuilder setCrosses(List<Integer> indexes) {
        for (Integer index : indexes) {
            field.set(index, AI.cross);
        }
        return this;
    }

    public FieldBuilder setCrosses(String indexString) {
        for (char indexChar : indexString.toCharArray()) {
            field.set(Integer.parseInt(String.valueOf(indexChar)), AI.cross);
        }
        return this;
    }

    public FieldBuilder setCross(Integer index) {
        field.set(index, AI.cross);
        return this;
    }

    public FieldBuilder setZeros(List<Integer> indexes) {
        for (Integer index : indexes) {
            field.set(index, AI.zero);
        }
        return this;
    }

    public FieldBuilder setZeros(String indexString) {
        for (char indexChar : indexString.toCharArray()) {
            field.set(Integer.parseInt(String.valueOf(indexChar)), AI.zero);
        }
        return this;
    }

    public FieldBuilder setZero(Integer index) {
        field.set(index, AI.zero);
        return this;
    }

    public List<Character> build() {
        return field;
    }
}
