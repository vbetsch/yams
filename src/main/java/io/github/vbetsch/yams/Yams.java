package io.github.vbetsch.yams;

import java.util.List;
import java.util.stream.IntStream;

public class Yams {
    public int computeScore(List<Integer> combination, CategoryEnum category) {
        if (category == CategoryEnum.CHANCE) {
            int result = 0;
            for (Integer integer : combination) {
                result += integer;
            }
            return result;
        } else if (category == CategoryEnum.YAMS) {
            IntStream distinctedCombination = combination
                    .stream()
                    .mapToInt(Integer::intValue)
                    .distinct();
            if (distinctedCombination.count() == 1) {
                IO.println("ITS A YAMS!!! GOOD GAME");
                return 50;
            } else {
                IO.println("SOOO BAAAAD !");
                return 0;
            }
        }
        return 1000;
    }
}
