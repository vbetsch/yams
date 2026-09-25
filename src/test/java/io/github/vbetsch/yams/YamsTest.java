package io.github.vbetsch.yams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamsTest {
    @Test
    void should_return40Points() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 2, 3, 4, 5), "LARGE_STRAIGHT");

        // Assert
        assertEquals(40, result);
    }
}
