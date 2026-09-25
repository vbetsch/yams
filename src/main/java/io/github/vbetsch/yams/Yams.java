package io.github.vbetsch.yams;

import java.util.List;

public class Yams {
    public int computeScore(List<Integer> combination, CategoryEnum category) {
        if (category == CategoryEnum.CHANCE) {
            return combination
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        return 1000;
    }
}
