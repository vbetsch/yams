package io.github.vbetsch.codecracker;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class TranslationDictionary {

    private final Map<Character, Character> decryptions = Map.ofEntries(
            entry('!', 'a'),
            entry(')', 'b'),
            entry('"', 'c'),
            entry('(', 'd'),
            entry('£', 'e'),
            entry('*', 'f'),
            entry('%', 'g'),
            entry('&', 'h'),
            entry('>', 'i'),
            entry('<', 'j'),
            entry('@', 'k'),
            entry('a', 'l'),
            entry('b', 'm'),
            entry('c', 'n'),
            entry('d', 'o'),
            entry('e', 'p'),
            entry('f', 'q'),
            entry('g', 'r'),
            entry('h', 's'),
            entry('i', 't'),
            entry('j', 'u'),
            entry('k', 'v'),
            entry('l', 'w'),
            entry('m', 'x'),
            entry('n', 'y'),
            entry('o', 'z')
    );

    private final Map<Character, Character> encryptions = invert(decryptions);

    private static Map<Character, Character> invert(Map<Character, Character> map) {
        Map<Character, Character> inverted = new HashMap<>();
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            inverted.put(entry.getValue(), entry.getKey());
        }
        return inverted;
    }

    public Map<Character, Character> getDecryptions() {
        return decryptions;
    }

    public Map<Character, Character> getEncryptions() {
        return encryptions;
    }

    public boolean containsDecryptionValue(char letter) {
        return decryptions.containsValue(letter);
    }
}