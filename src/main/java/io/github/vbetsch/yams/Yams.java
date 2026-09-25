package io.github.vbetsch.yams;

import java.util.List;

public class Yams {
    public int computeScore(List<Integer> combination, CategoryEnum category) {
        if (category == CategoryEnum.CHANCE) {
            int result = 0;
            for (Integer integer : combination) {
                result += integer;
            }
            return result;
        }
        return 1000;
    }
}
