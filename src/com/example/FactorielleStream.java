package com.example;

import java.util.stream.IntStream;

public class FactorielleStream {
    public static void main(String[] args) {
        // Version impérative
        System.out.println("Factorielles (version impérative):");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + factorielleImperative(i));
        }
        
        // Version fonctionnelle avec IntStream
        System.out.println("\nFactorielles (version fonctionnelle):");
        for (int i = 0; i <= 10; i++) {
            final int n = i; // Pour utilisation dans la lambda
            System.out.println(n + "! = " + factorielleStream(n));
        }
    }
    
    // Version impérative classique
    private static long factorielleImperative(int n) {
        if (n <= 1) return 1;
        long resultat = 1;
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }
    
    // Version fonctionnelle avec IntStream
    private static long factorielleStream(int n) {
        if (n <= 1) return 1;
        return IntStream.rangeClosed(2, n)
                       .mapToLong(Long::valueOf)
                       .reduce(1, (a, b) -> a * b);
    }
}