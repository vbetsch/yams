package io.github.vbetsch.yams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YamsTest {
    @Test
    void chance_return15Points_whenGivenLargeStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 2, 3, 4, 5), CategoryEnum.CHANCE);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void chance_return16Points_whenGivenSmallStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 2, 3, 4, 6), CategoryEnum.CHANCE);

        // Assert
        assertEquals(16, result);
    }
}
