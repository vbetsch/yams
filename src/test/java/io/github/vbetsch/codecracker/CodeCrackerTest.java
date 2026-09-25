package io.github.vbetsch.codecracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeCrackerTest {

    @Test
    void should_returnLetterA_whenDecryptExclamationPoint() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        char decryptedExclamationPoint = codeCracker.decryptChar('!');

        // Assert
        assertEquals('a', decryptedExclamationPoint);
    }

    @Test
    void should_returnLetterB_whenDecryptEndParenthesis() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        char decryptedEndParenthesis = codeCracker.decryptChar(')');

        // Assert
        assertEquals('b', decryptedEndParenthesis);
    }

    @Test
    void should_returnWordAB_whenDecryptExclamationPointAndEndParenthesis() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String decryptedString = codeCracker.decryptString("!)");

        // Assert
        assertEquals("ab", decryptedString);
    }

    @Test
    void should_decryptWordHello() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String decryptedString = codeCracker.decryptString("&£aad");

        // Assert
        assertEquals("hello", decryptedString);
    }

    @Test
    void should_decryptWordWorld() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String decryptedString = codeCracker.decryptString("ldga(");

        // Assert
        assertEquals("world", decryptedString);
    }

    @Test
    void should_returnExclamationPoint_whenEncryptLetterA() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        char encryptedLetterA = codeCracker.encryptLetter('a');

        // Assert
        assertEquals('!', encryptedLetterA);
    }

    @Test
    void should_returnEndParenthesis_whenEncryptLetterB() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        char encryptedLetterB = codeCracker.encryptLetter('b');

        // Assert
        assertEquals(')', encryptedLetterB);
    }

    @Test
    void should_returnExclamationPointAndEndParenthesis_whenEncryptAB() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String encryptedAB = codeCracker.encryptString("ab");

        // Assert
        assertEquals("!)", encryptedAB);
    }

    @Test
    void should_encryptWordHello() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String encryptedHello = codeCracker.encryptString("hello");

        // Assert
        assertEquals("&£aad", encryptedHello);
    }

    @Test
    void should_encryptWordWorld() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String encryptedWorld = codeCracker.encryptString("world");

        // Assert
        assertEquals("ldga(", encryptedWorld);
    }

    @Test
    void should_handleUpperCaseInEncrypt() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String encryptedHello = codeCracker.encryptString("Hello");

        // Assert
        assertEquals("&£aad", encryptedHello);
    }

    @Test
    void should_handleUnknownCharacters() {
        // Arrange
        CodeCracker codeCracker = new CodeCracker();

        // Act
        String encryptedHello = codeCracker.encryptString("Hello !");

        // Assert
        assertEquals("&£aad", encryptedHello);
    }
}
