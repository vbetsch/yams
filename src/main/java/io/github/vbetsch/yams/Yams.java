package io.github.vbetsch.yams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Yams {
    static final int DICES_COUNT = 5;

    // Utils
    private Map<Integer, Integer> getOccurrencesByValue(List<Integer> roll) {
        Map<Integer, Integer> occurrencesByValue = new HashMap<>();
        for (int i = 0; i < roll.size(); i++) {
            int diceValue = roll.get(i);
            occurrencesByValue.merge(diceValue, 1, Integer::sum);
        }
        IO.println(occurrencesByValue);
        return occurrencesByValue;
    }

    private boolean containsAtLeastDuplicatesNth(Map<Integer, Integer> occurrencesByValue, int duplicatesNumber) {
        return occurrencesByValue
                .entrySet()
                .stream()
                .anyMatch(occurrenceByValue -> occurrenceByValue.getValue() >= duplicatesNumber);
    }

    private int calculateSumOfDices(List<Integer> roll) {
        return roll
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Handlers
    private int handleChanceScore(List<Integer> roll) {
        return this.calculateSumOfDices(roll);
    }

    private int handleYamsScore(List<Integer> roll) {
        IntStream reducedRoll = roll
                .stream()
                .mapToInt(Integer::intValue)
                .distinct();
        if (reducedRoll.count() == 1) {
            IO.println("ITS A YAMS!!! GOOD GAME !!!");
            return 50;
        } else {
            return 0;
        }
    }

    private int handleTopPartScores(List<Integer> roll, int target) {
        return roll
                .stream()
                .filter(dice -> dice == target)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int handlePairScore(List<Integer> roll) throws IllegalArgumentException {
        Map<Integer, Integer> occurrencesByValue = this.getOccurrencesByValue(roll);
        if (!this.containsAtLeastDuplicatesNth(occurrencesByValue, 2)) {
            throw new CategoryNotAuthorizedForThisRollError(CategoryEnum.PAIR);
        }
        return occurrencesByValue
                .entrySet()
                .stream()
                .filter(occurrenceByValue -> occurrenceByValue.getValue() == 2)
                .map(Map.Entry::getKey)
                .max(Integer::compare)
                .orElse(0) * 2;
    }

    private int handleThreeOfAKindScore(List<Integer> roll) throws IllegalArgumentException {
        Map<Integer, Integer> occurrencesByValue = this.getOccurrencesByValue(roll);
        if (!this.containsAtLeastDuplicatesNth(occurrencesByValue, 3)) {
            throw new CategoryNotAuthorizedForThisRollError(CategoryEnum.THREE_OF_A_KIND);
        }
        return this.calculateSumOfDices(roll);
    }

    private int handleFourOfAKindScore(List<Integer> roll) throws IllegalArgumentException {
        Map<Integer, Integer> occurrencesByValue = this.getOccurrencesByValue(roll);
        if (!this.containsAtLeastDuplicatesNth(occurrencesByValue, 4)) {
            throw new CategoryNotAuthorizedForThisRollError(CategoryEnum.FOUR_OF_A_KIND);
        }
        return this.calculateSumOfDices(roll);
    }

    // Public method
    public int computeScore(List<Integer> roll, CategoryEnum category) throws InvalidRollSizeError {
        if (roll.size() != Yams.DICES_COUNT) {
            throw new InvalidRollSizeError(roll.size());
        }
        return switch (category) {
            case CategoryEnum.CHANCE -> this.handleChanceScore(roll);
            case CategoryEnum.YAMS -> this.handleYamsScore(roll);
            case CategoryEnum.ACES -> this.handleTopPartScores(roll, 1);
            case CategoryEnum.TWOS -> this.handleTopPartScores(roll, 2);
            case CategoryEnum.THREES -> this.handleTopPartScores(roll, 3);
            case CategoryEnum.FOURS -> this.handleTopPartScores(roll, 4);
            case CategoryEnum.FIVES -> this.handleTopPartScores(roll, 5);
            case CategoryEnum.SIXES -> this.handleTopPartScores(roll, 6);
            case CategoryEnum.PAIR -> this.handlePairScore(roll);
            case CategoryEnum.THREE_OF_A_KIND -> this.handleThreeOfAKindScore(roll);
            case CategoryEnum.FOUR_OF_A_KIND -> this.handleFourOfAKindScore(roll);
            default -> 1000;
        };
    }
}
