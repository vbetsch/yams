package io.github.vbetsch.yams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YamsTest {
    // --- CHANCE ---
    @Test
    void chance_returnPoints_whenGivenLargeStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 2, 3, 4, 5), CategoryEnum.CHANCE);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void chance_returnPoints_whenGivenSmallStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 2, 3, 4, 6), CategoryEnum.CHANCE);

        // Assert
        assertEquals(16, result);
    }

    // --- YAMS ---
    @Test
    void yams_returnPoints_whenGivenFiveDicesSix() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(6, 6, 6, 6, 6), CategoryEnum.YAMS);

        // Assert
        assertEquals(50, result);
    }

    @Test
    void yams_returnPoints_whenGivenFiveDicesThree() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(3, 3, 3, 3, 3), CategoryEnum.YAMS);

        // Assert
        assertEquals(50, result);
    }

    @Test
    void yams_returnPoints_whenGivenRollWithDuplicates() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 1, 2, 2, 3), CategoryEnum.YAMS);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void yams_returnPoints_whenGivenRollWithoutDuplicates() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 4, 5, 6, 3), CategoryEnum.YAMS);

        // Assert
        assertEquals(0, result);
    }

    // --- ACES ---
    @Test
    void aces_returnPoints_whenGivenRollWithThreeDicesAces() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 1, 1, 2, 3), CategoryEnum.ACES);

        // Assert
        assertEquals(3, result);
    }

    // --- TOP PARTS ---
    @Test
    void twos_returnPoints_whenGivenRollWithThreeDicesTwos() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 2, 1, 3), CategoryEnum.TWOS);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void three_returnPoints_whenGivenRollWithThreeDicesThrees() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(3, 3, 3, 2, 1), CategoryEnum.THREES);

        // Assert
        assertEquals(9, result);
    }

    @Test
    void four_returnPoints_whenGivenRollWithThreeDicesFours() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(4, 4, 4, 2, 3), CategoryEnum.FOURS);

        // Assert
        assertEquals(12, result);
    }

    @Test
    void five_returnPoints_whenGivenRollWithThreeDicesFives() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(5, 5, 5, 2, 3), CategoryEnum.FIVES);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void sixes_returnPoints_whenGivenRollWithThreeDicesSixes() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(6, 6, 6, 2, 3), CategoryEnum.SIXES);

        // Assert
        assertEquals(18, result);
    }

    // --- PAIRS ---
    @Test
    void pair_throwIllegalArgumentException_whenGivenNotPair() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(1, 2, 3, 4, 5), CategoryEnum.PAIR),
                "We cannot compute score with category PAIR for this roll"
        );
    }

    @Test
    void pair_returnPoints_whenGivenRollWithOnlyOnePairOfTwo() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 3, 4, 5), CategoryEnum.PAIR);

        // Assert
        assertEquals(4, result);
    }

    @Test
    void pair_returnPoints_whenGivenRollWithOnlyOnePairOfThree() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(3, 3, 4, 5, 1), CategoryEnum.PAIR);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void pair_returnPoints_whenGivenRollWithTwoPairs() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(3, 3, 4, 4, 1), CategoryEnum.PAIR);

        // Assert
        assertEquals(8, result);
    }

    // --- THREE OF A KIND ---
    @Test
    void threeOfAKind_returnPoints_whenGivenThreeDicesOnes() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 1, 1, 2, 3), CategoryEnum.THREE_OF_A_KIND);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void threeOfAKind_returnPoints_whenGivenThreeDicesTwos() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 2, 1, 3), CategoryEnum.THREE_OF_A_KIND);

        // Assert
        assertEquals(10, result);
    }

    @Test
    void threeOfAKind_returnPoints_whenGivenMoreThanThreeDicesTwos() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 2, 2, 3), CategoryEnum.THREE_OF_A_KIND);

        // Assert
        assertEquals(11, result);
    }

    @Test
    void threeOfAKind_throwIllegalArgumentException_whenGivenLargeStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(1, 2, 3, 4, 5), CategoryEnum.THREE_OF_A_KIND),
                "We cannot compute score with category ThreeOfAKind for this roll"
        );
    }

    // --- FOUR OF A KIND ---
    @Test
    void fourOfAKind_returnPoints_whenGivenFourDicesOnes() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(1, 1, 1, 1, 3), CategoryEnum.FOUR_OF_A_KIND);

        // Assert
        assertEquals(7, result);
    }

    @Test
    void fourOfAKind_returnPoints_whenGivenFourDicesTwos() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 2, 2, 3), CategoryEnum.FOUR_OF_A_KIND);

        // Assert
        assertEquals(11, result);
    }

    @Test
    void fourOfAKind_returnPoints_whenGivenMoreThanFourDicesTwos() {
        // Arrange
        Yams yams = new Yams();

        // Act
        int result = yams.computeScore(List.of(2, 2, 2, 2, 2), CategoryEnum.FOUR_OF_A_KIND);

        // Assert
        assertEquals(10, result);
    }

    @Test
    void fourOfAKind_throwIllegalArgumentException_whenGivenLargeStraight() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(1, 2, 3, 4, 5), CategoryEnum.FOUR_OF_A_KIND),
                "We cannot compute score with category FourOfAKind for this roll"
        );
    }

    // --- CHECKS ---
    @Test
    void throwIllegalArgumentException_whenGivenLessThanFiveDices() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(1, 2, 3, 4), CategoryEnum.CHANCE),
                "Roll must contain exactly 5 dices"
        );
    }

    @Test
    void throwIllegalArgumentException_whenGivenMoreThanFiveDices() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(1, 2, 3, 4, 5, 6), CategoryEnum.CHANCE),
                "Roll must contain exactly 5 dices"
        );
    }

    @Test
    void throwIllegalArgumentException_whenGivenNoDice() {
        // Arrange
        Yams yams = new Yams();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> yams.computeScore(List.of(), CategoryEnum.CHANCE),
                "Roll must contain exactly 5 dices"
        );
    }
}
