package io.github.vbetsch.yams;

public class Main {
    static void main() {
        CodeCracker codeCracker = new CodeCracker();
        IO.println("Hello world!");
        System.out.println("Encrypted : " + codeCracker.encryptString("Hello world!"));
    }
}
