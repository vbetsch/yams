package io.github.vbetsch.codecracker;

public class Main {
    static void main() {
        CodeCracker codeCracker = new CodeCracker();
        IO.println("Hello world!");
        System.out.println("Encrypted : " + codeCracker.encryptString("Hello world!"));
    }
}
