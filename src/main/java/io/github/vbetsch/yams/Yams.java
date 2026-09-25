package io.github.vbetsch.yams;

import java.util.List;
import java.util.stream.IntStream;

public class Yams {
    private int handleChanceScore(List<Integer> combination) {
        int result = 0;
        for (Integer integer : combination) {
            result += integer;
        }
        return result;
    }

    private int handleYamsScore(List<Integer> combination) {
        IntStream distinctedCombination = combination
                .stream()
                .mapToInt(Integer::intValue)
                .distinct();
        if (distinctedCombination.count() == 1) {
            IO.println("ITS A YAMS!!! GOOD GAME !!!");
            return 50;
        } else {
            return 0;
        }
    }

    public int computeScore(List<Integer> combination, CategoryEnum category) {
        if (category == CategoryEnum.CHANCE) {
            return this.handleChanceScore(combination);
        } else if (category == CategoryEnum.YAMS) {
            return this.handleYamsScore(combination);
        }
        return 1000;
    }
}
