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
        IntStream reducedCombination = combination
                .stream()
                .mapToInt(Integer::intValue)
                .distinct();
        if (reducedCombination.count() == 1) {
            IO.println("ITS A YAMS!!! GOOD GAME !!!");
            return 50;
        } else {
            return 0;
        }
    }

    private int handleAcesScore(List<Integer> combination) {
        return combination
                .stream()
                .filter(dice -> dice == 1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int handleFivesScore(List<Integer> combination) {
        return combination
                .stream()
                .filter(dice -> dice == 5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int computeScore(List<Integer> combination, CategoryEnum category) {
        return switch (category) {
            case CategoryEnum.CHANCE -> this.handleChanceScore(combination);
            case CategoryEnum.YAMS -> this.handleYamsScore(combination);
            case CategoryEnum.ACES -> this.handleAcesScore(combination);
            case CategoryEnum.FIVES -> this.handleFivesScore(combination);
            default -> 1000;
        };
    }
}
